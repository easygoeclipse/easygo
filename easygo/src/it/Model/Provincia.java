package it.Model;

public class Provincia {
	
	public Provincia(){}

	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCapoluogo() {
		return capoluogo;
	}
	public void setCapoluogo(String capoluogo) {
		this.capoluogo = capoluogo;
	}
	
	public Regione getRegione() {
		return regione;
	}
	public void setRegione(Regione regione) {
		this.regione = regione;
	}




	private String sigla;
	private String nome;
	private String capoluogo;
	private Regione regione;

}
