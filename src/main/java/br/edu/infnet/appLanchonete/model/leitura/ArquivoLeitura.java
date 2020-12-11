package br.edu.infnet.appLanchonete.model.leitura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.edu.infnet.appLanchonete.model.exception.ComplementoInvalidoException;
import br.edu.infnet.appLanchonete.model.exception.MedidaInvalidaException;
import br.edu.infnet.appLanchonete.model.exception.PorcaoInvalidaException;
import br.edu.infnet.appLanchonete.model.negocio.Bebida;
import br.edu.infnet.appLanchonete.model.negocio.Comida;
import br.edu.infnet.appLanchonete.model.negocio.Sobremesa;

public class ArquivoLeitura {

	public static void main(String[] args) {
		
		String dir = "C:/dev/workspace20E4/";
		String arq = "pedidos.txt";

		try {
			FileReader leitura = new FileReader(dir+arq);			
			BufferedReader in = new BufferedReader(leitura);
			
			FileWriter escrita = new FileWriter(dir+"out_"+arq);			
			BufferedWriter out = new BufferedWriter(escrita);

			String linha = in.readLine();
			
			while(linha != null) {
				
				String[] campos = linha.split(";");
				
				
				switch (campos[0].toUpperCase()) {
				case "B":
					Bebida bebida = new Bebida(campos[1], Float.valueOf(campos[2]), Boolean.valueOf(campos[3]));
					bebida.setMedida(Float.valueOf(campos[4]));
					bebida.setMarca(campos[5]);
					
					out.write(bebida.obterValorPorProduto());
					break;

				case "C":
					Comida comida = new Comida(campos[1], Float.valueOf(campos[2]), Boolean.valueOf(campos[3]));
					comida.setDoce(Boolean.valueOf(campos[4]));
					comida.setComplemento(campos[5]);

					out.write(comida.obterValorPorProduto());					
					break;

				case "S":
					Sobremesa sobremesa = new Sobremesa(campos[1], Float.valueOf(campos[2]), Boolean.valueOf(campos[3]));
					sobremesa.setCalda(Boolean.valueOf(campos[4]));
					sobremesa.setPorcao(Integer.valueOf(campos[5]));

					out.write(sobremesa.obterValorPorProduto());
					break;
					
				default:
					break;
				}

				linha = in.readLine();
			}

			in.close();
			leitura.close();
			
			out.close();
			escrita.close();
			
			System.out.println(args.length == 1 ? args[0] : "Pronto!!");
		} catch (IOException | MedidaInvalidaException | ComplementoInvalidoException | PorcaoInvalidaException e) {
			System.out.println(e.getMessage());
		}
	}
}