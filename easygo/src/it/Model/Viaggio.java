package it.Model;

import java.sql.Time;
import java.util.GregorianCalendar;

public class Viaggio {
	
	
	public Viaggio(){}
	
	public int getCodicetratta() {
		return codicetratta;
	}

	public void setCodicetratta(int codicetratta) {
		this.codicetratta = codicetratta;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Time getDurata() {
		return durata;
	}

	public void setDurata(Time durata) {
		this.durata = durata;
	}

	public Autobus getAutobus() {
		return autobus;
	}

	public void setAutobus(Autobus autobus) {
		this.autobus = autobus;
	}
	
	public GregorianCalendar getDataOraPartenza() {
		return dataorapartenza;
	}

	public void setDataOraPartenza(GregorianCalendar dataorapartenza) {
		this.dataorapartenza = dataorapartenza;
	}

	public GregorianCalendar getDataOraArrivo() {
		return dataoraarrivo;
	}

	public void setDataOraArrivo(GregorianCalendar dataoraarrivo) {
		this.dataoraarrivo = dataoraarrivo;
	}

	public Fermata getPartenza() {
		return partenza;
	}

	public void setPartenza(Fermata partenza) {
		this.partenza = partenza;
	}

	public Fermata getArrivo() {
		return arrivo;
	}

	public void setArrivo(Fermata arrivo) {
		this.arrivo = arrivo;
	}

	
	
	
	private int codicetratta;
	private double prezzo;
	private Time durata;
	private Autobus autobus;
	private GregorianCalendar dataorapartenza;
	private GregorianCalendar dataoraarrivo;
	private Fermata partenza;
	private Fermata arrivo;

}
