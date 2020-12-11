package br.edu.infnet.appLanchonete.model.negocio;

import br.edu.infnet.appLanchonete.model.exception.ComplementoInvalidoException;

public class Comida extends Produto {

	private boolean doce;
	private String complemento;
	
	public Comida(String descricao, float valor, boolean producaoPropria) {
		super(descricao, valor, producaoPropria);
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.isDoce());
		sb.append(";");
		sb.append(this.getComplemento());

		return sb.toString();
	}

	@Override
	public float calcularValorVenda() {
		return this.getValor() + (this.isProducaoPropria() ? 2 : 0) + (this.isDoce() ? 3 : 0);
	}

	public boolean isDoce() {
		return doce;
	}
	public void setDoce(boolean doce) {
		this.doce = doce;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) throws ComplementoInvalidoException {
		
		if(complemento == null) {
			throw new ComplementoInvalidoException("Complemento inválido.");
		}
		
		this.complemento = complemento;
	}
}