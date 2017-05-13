package it.Model.DAODTO;

import java.sql.SQLException;
import java.util.ArrayList;

import it.Model.Fermata;


public interface FermataDAO {
	
	public void doSave(Fermata fermata) throws SQLException;

	public boolean doDelete(int code) throws SQLException;

	public Fermata doRetrieveByKey(int code) throws SQLException;
	
	public ArrayList<Fermata> doRetrieveAll(String order) throws SQLException;

}
