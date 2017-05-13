package it.Model.DAODTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import it.Model.Utente;
import it.Model.Viaggio;

public interface ViaggioDAO {
	
		public void doSave(Viaggio viaggio) throws SQLException;

		public boolean doDelete(int code) throws SQLException;

		public Viaggio doRetrieveByKey(int code) throws SQLException;
		
		public ArrayList<Viaggio> doRetrieveAll(String order) throws SQLException;
}

