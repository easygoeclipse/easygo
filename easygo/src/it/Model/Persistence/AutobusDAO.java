package it.Model.Persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import it.Model.Autobus;

public interface AutobusDAO {
	
	
	
	
	public void doSave(Autobus autobus) throws SQLException;

	public boolean doDelete(String code) throws SQLException;

	public Autobus doRetrieveByKey(String code) throws SQLException;
	
	public ArrayList<Autobus> doRetrieveAll(String order) throws SQLException;

}
