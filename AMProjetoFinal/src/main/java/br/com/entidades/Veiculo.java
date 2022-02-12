package br.com.entidades;

public class Veiculo {
	
	private Integer id_veiculo;
	private String modelo;
	private Integer ano_veiculo;
	
	public Veiculo(String modelo, Integer ano_veiculo) {
		super();
		this.modelo = modelo;
		this.ano_veiculo = ano_veiculo;
	}

	public Integer getId_veiculo() {
		return id_veiculo;
	}

	public void setId_veiculo(Integer id_veiculo) {
		this.id_veiculo = id_veiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno_veiculo() {
		return ano_veiculo;
	}

	public void setAno_veiculo(Integer ano_veiculo) {
		this.ano_veiculo = ano_veiculo;
	}

	public String toString() {
		return this.id_veiculo + ": " +
			   this.modelo + ": " +
			   this.ano_veiculo;
	}
	
}
