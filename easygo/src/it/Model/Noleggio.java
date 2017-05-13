package it.Model;

import java.util.GregorianCalendar;

public class Noleggio {
	
	public Noleggio(){}
	
	
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public GregorianCalendar getDatapartenza() {
		return datapartenza;
	}
	public void setDatapartenza(GregorianCalendar datapartenza) {
		this.datapartenza = datapartenza;
	}
	public GregorianCalendar getDatafine() {
		return datafine;
	}
	public void setDatafine(GregorianCalendar datafine) {
		this.datafine = datafine;
	}
	public Utente getUtente() {
		return utente;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	
	private int codice;
	private GregorianCalendar datapartenza;
	private GregorianCalendar datafine;
	private double prezzo;
	private Utente utente;


}
