package it.Model.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import it.Model.Autista;
import it.Model.Autobus;
import it.Model.Viaggio;

public class AutistaDTO implements AutistaDAO {

private static DataSource ds;
	
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/sql11173555");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}

	}

	private static final String TABLE_NAME = "autista";

	
	@Override
	public void doSave(Autista autista) throws SQLException {
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + AutistaDTO.TABLE_NAME
				+ " (nome, cognome, ,autobus) VALUES (?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, autista.getNome());
			preparedStatement.setString(2, autista.getCognome());
			preparedStatement.setString(3, autista.getAutobus().getTarga());
			
			preparedStatement.executeUpdate();
			
			insertSQL= "SELECT Max(codice) AS maxcodice FROM" + AutistaDTO.TABLE_NAME;
			preparedStatement = connection.prepareStatement(insertSQL);
			ResultSet rs = preparedStatement.executeQuery();
			autista.setCodice(rs.getInt("maxcodice"));
			
			connection.commit();
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}

		
		
	}

	@Override
	public boolean doDelete(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + AutistaDTO.TABLE_NAME + " WHERE codice = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		
		return (result != 0);
	}

	@Override
	public Autista doRetrieveByKey(int code) throws SQLException {
	
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Autista bean = new Autista();

		String selectSQL = "SELECT * FROM " + AutistaDTO.TABLE_NAME + "JOIN autobus ON autista.autobus=autobus.targa WHERE codice = ?";

		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				bean.setCodice(rs.getInt("codice"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				
				Autobus autobus = new Autobus();
				autobus.setTarga(rs.getString("targa"));
				autobus.setPostidisp(rs.getInt("postidisp"));
				autobus.setTipo(rs.getString("tipo"));
				
				bean.setAutobus(autobus);;
				
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return bean;
		
	}

	@Override
	public ArrayList<Autista> doRetrieveAll(String order) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Autista> autisti = new ArrayList<Autista>();

		String selectSQL = "SELECT * FROM " + AutistaDTO.TABLE_NAME + "JOIN autobus ON autista.autobus=autobus.targa";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				Autista bean = new Autista();
				
				bean.setCodice(rs.getInt("codice"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				
				Autobus autobus = new Autobus();
				autobus.setTarga(rs.getString("targa"));
				autobus.setPostidisp(rs.getInt("postidisp"));
				autobus.setTipo(rs.getString("tipo"));
				
				bean.setAutobus(autobus);
				autisti.add(bean);

			}
			

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return autisti;
	}
	
	
	

}
