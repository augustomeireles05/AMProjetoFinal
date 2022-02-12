package br.com.entidades;

public class Ipva {
	
	private Integer id_ipva;
	private String ano;
	
	public Ipva(Integer id_ipva, String ano) {
		super();
		this.id_ipva = id_ipva;
		this.ano = ano;
	}

	public Integer getId_ipva() {
		return id_ipva;
	}

	public void setId_ipva(Integer id_ipva) {
		this.id_ipva = id_ipva;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public String toString() {
		return this.id_ipva + ": " +
			   this.ano;
	}
	
}
