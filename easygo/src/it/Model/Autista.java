package it.Model;

public class Autista {
	
	public Autista(){	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public Autobus getAutobus() {
		return autobus;
	}
	public void setAutobus(Autobus autobus) {
		this.autobus = autobus;
	}

	
	private String nome;
	private String cognome;
	private int codice;

	private Autobus autobus;
}
