package it.Model.Persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import it.Model.Autista;
import it.Model.Viaggio;

public interface AutistaDAO {
	
	
	public void doSave(Autista autista) throws SQLException;

	public boolean doDelete(int code) throws SQLException;

	public Autista doRetrieveByKey(int code) throws SQLException;
	
	public ArrayList<Autista> doRetrieveAll(String order) throws SQLException;

}
