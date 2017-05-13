package it.Model.DAODTO;

import java.sql.SQLException;
import java.util.ArrayList;

import it.Model.Fermata;
import it.Model.Regione;

public interface RegioneDAO {
	
	public void doSave(Regione regione) throws SQLException;

	public boolean doDelete(int code) throws SQLException;

	public Regione doRetrieveByKey(int code) throws SQLException;
	
	public ArrayList<Regione> doRetrieveAll(String order) throws SQLException;

}
