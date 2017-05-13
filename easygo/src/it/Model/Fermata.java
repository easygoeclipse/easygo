package it.Model;

import java.util.GregorianCalendar;

public class Fermata {
	
	public Fermata(){}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		
		this.indirizzo = indirizzo;
	}
	public Comune getComune() {
		return comune;
	}
	public void setComune(Comune comune) {
		this.comune = comune;
	}
	
	
	
	private int id;
	private String indirizzo;
	private Comune comune;


}
