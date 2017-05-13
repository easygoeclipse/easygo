package it.Model.Persistence;

import java.sql.SQLException;
import java.util.Collection;

import it.Model.Comune;

public interface ComuneDAO {
	
	
	public void doSave(Comune comune) throws SQLException;

	public boolean doDelete(int code) throws SQLException;

	public Comune doRetrieveByKey(int code) throws SQLException;
	
	public Collection<Comune> doRetrieveAll(String order) throws SQLException;

}
