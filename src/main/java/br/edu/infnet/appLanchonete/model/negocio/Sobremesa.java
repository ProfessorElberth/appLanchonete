package br.edu.infnet.appLanchonete.model.negocio;

import br.edu.infnet.appLanchonete.model.exception.PorcaoInvalidaException;

public class Sobremesa extends Produto {

	private int porcao;
	private boolean calda;
	
	public Sobremesa(String descricao, float valor, boolean producaoPropria) {
		super(descricao, valor, producaoPropria);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.getPorcao());
		sb.append(";");
		sb.append(this.isCalda());
		
		return sb.toString();
	}

	@Override
	public float calcularValorVenda() {
		return this.getValor() + (this.isProducaoPropria() ? 2 : 0) + (this.getValor() * this.getPorcao()) + (this.isCalda() ? 4 : 0);
	}

	public int getPorcao() {
		return porcao;
	}
	public void setPorcao(int porcao) throws PorcaoInvalidaException {
		
		if(porcao <= 0 && porcao >= 10) {
			throw new PorcaoInvalidaException("Porção inválida.");
		}
		
		this.porcao = porcao;
	}
	public boolean isCalda() {
		return calda;
	}
	public void setCalda(boolean calda) {
		this.calda = calda;
	}
}