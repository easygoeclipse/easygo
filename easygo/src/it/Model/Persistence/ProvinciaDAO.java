package it.Model.DAODTO;

import java.sql.SQLException;
import java.util.ArrayList;

import it.Model.Provincia;
import it.Model.Viaggio;

public interface ProvinciaDAO {
	
	
	public void doSave(Provincia provincia) throws SQLException;

	public boolean doDelete(String code) throws SQLException;

	public Provincia doRetrieveByKey(String code) throws SQLException;
	
	public ArrayList<Provincia> doRetrieveAll(String order) throws SQLException;

}
