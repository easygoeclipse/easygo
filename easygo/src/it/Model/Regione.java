package it.Model;

public class Regione {
	
	public Regione(){}

	
	public int getCodiceistat() {
		return codiceistat;
	}
	public void setCodiceistat(int codiceistat) {
		this.codiceistat = codiceistat;
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
	
	
	private int codiceistat;
	private String nome;
	private String capoluogo;
	

}
