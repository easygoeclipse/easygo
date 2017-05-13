package it.Model;

import java.util.GregorianCalendar;

public class Biglietto {
	
	
	public Biglietto(){}
	
	
	
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String numeroprenotazione) {
		this.codice = numeroprenotazione;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public Viaggio getViaggio() {
		return viaggio;
	}
	public void setViaggio(Viaggio viaggio) {
		this.viaggio = viaggio;
	}
	
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




	public String getCell() {
		return cell;
	}




	public void setCell(String cell) {
		this.cell = cell;
	}

	public int getQuantita() {
		return quantita;
	}




	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}






	private String codice;
	private String nome;
	private String cognome;
	private String cell;
	private double prezzo;
	private Viaggio viaggio;
	private int quantita;

}
