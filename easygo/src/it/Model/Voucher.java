package it.Model;

import java.util.GregorianCalendar;

public class Voucher {
	
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public double getValuta() {
		return valuta;
	}
	public void setValuta(double valuta) {
		this.valuta = valuta;
	}
	public GregorianCalendar getDatascadenza() {
		return datascadenza;
	}
	public void setDatascadenza(GregorianCalendar datascadenza) {
		this.datascadenza = datascadenza;
	}
	public GregorianCalendar getDatainizio() {
		return datainizio;
	}
	public void setDatainizio(GregorianCalendar datainizio) {
		this.datainizio = datainizio;
	}

	
	
	
	private int codice;
	private double valuta;
	private GregorianCalendar datascadenza;
	private GregorianCalendar datainizio;

}
