package br.edu.infnet.appLanchonete.model.negocio;

public class Bebida extends Produto {

	private float medida;
	private String marca;
	
	public Bebida(String descricao, float valor, boolean producaoPropria) {
		super(descricao, valor, producaoPropria);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(this.getMedida());
		sb.append(";");
		sb.append(this.getMarca());
		
		return sb.toString();
	}

	@Override
	public float calcularValorVenda() {
		
		float valorProducaoPropria = 0;
		if(this.isProducaoPropria()) {
			valorProducaoPropria = 2;
		}
		
		return this.getValor() + valorProducaoPropria + this.getMedida() * 0.02f;
	}

	public float getMedida() {
		return medida;
	}
	public void setMedida(float medida) {
		this.medida = medida;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
}