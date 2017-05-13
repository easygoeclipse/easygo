package it.Model;

public class ViaggioPromo extends Viaggio{
	
	
	public ViaggioPromo(){}
	
	
	
	
	public double getPrezzoscontato() {
		return prezzoscontato;
	}
	public void setPrezzoscontato(double prezzoscontato) {
		this.prezzoscontato = prezzoscontato;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getSconto() {
		return sconto;
	}
	public void setSconto(int sconto) {
		this.sconto = sconto;
	}




	private double prezzoscontato;
	private String descrizione;
	private int sconto;

}
