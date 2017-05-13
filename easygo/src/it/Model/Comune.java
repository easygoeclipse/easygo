package it.Model;

public class Comune {
	
	public Comune(){}

	
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public String getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(String latitudine) {
		this.latitudine = latitudine;
	}
	public String getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(String longitudine) {
		this.longitudine = longitudine;
	}
	public String getNome() {
		return nome;
	}
	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	private int codice;
	private String latitudine;
	private String longitudine;
	private String nome;
	private Provincia provincia;
}
