package it.Model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Utente {
	
	public Utente(){}
	
	





	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getTotspeso() {
		return totspeso;
	}
	public void setTotspeso(double totspeso) {
		this.totspeso = totspeso;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
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
	public GregorianCalendar getDataNascita() {
		return datanascita;
	}
	public void setDataNascita(GregorianCalendar datanascita) {
		this.datanascita = datanascita;
	}

	public ArrayList<String> getTelefoni() {
		return telefoni;
	}



	public void setTelefoni(ArrayList<String> telefoni) {
		this.telefoni = telefoni;
	}
	
	public ArrayList<CartaCredito> getCartecc() {
		return cartecc;
	}

	public void setCartecc(ArrayList<CartaCredito> cartecc) {
		this.cartecc = cartecc;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Biglietto> getBiglietti() {
		return biglietti;
	}


	public void setBiglietti(ArrayList<Biglietto> biglietti) {
		this.biglietti = biglietti;
	}


	private String email;
	private String password;
	private double totspeso;
	private String cognome;
	private String nome;
	private String indirizzo;
	private Comune comune;
	private GregorianCalendar datanascita;
	private ArrayList<String> telefoni;
	private ArrayList<CartaCredito> cartecc;
	private ArrayList<Biglietto> biglietti;

}