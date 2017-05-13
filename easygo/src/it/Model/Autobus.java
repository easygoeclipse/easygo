package it.Model;

public class Autobus {
	
	
	public Autobus(){}

	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public int getPostidisp() {
		return postidisp;
	}
	public void setPostidisp(int postidisp) {
		this.postidisp = postidisp;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	private String targa;
	private int postidisp;
	private String tipo;

}
