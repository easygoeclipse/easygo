package it.Model;

import java.util.ArrayList;
import java.util.List;

import it.Model.Viaggio;

public class Carrello {
	
	
	private ArrayList<Viaggio> viaggi;
	
	public Carrello() {
		viaggi = new ArrayList<Viaggio>();
	}
	
	public void addProduct(Viaggio viaggio) {
		viaggi.add(viaggio);
	}
	
	public void deleteProduct(Viaggio viaggio) {
		for(Viaggio viaggioc : viaggi) {
			if(viaggio.getCodicetratta()==viaggio.getCodicetratta()) {
				viaggi.remove(viaggioc);
			}
		}
 	}
	
	public ArrayList<Viaggio> getViaggi() {
		
		return  viaggi;
		
	}

}
