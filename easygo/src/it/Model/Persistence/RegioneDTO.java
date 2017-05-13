package it.Model.DAODTO;

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

import it.Model.Regione;
import it.Model.Viaggio;

public class RegioneDTO implements RegioneDAO{
	
	private static DataSource ds;
	
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/easygodb");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	
	private static final String TABLE_NAME = "regione";
	
	@Override
	public void doSave(Regione regione) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + RegioneDTO.TABLE_NAME
				+ " (codiceistat, nome, capoluogo) VALUES (?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, regione.getCodiceistat());
			preparedStatement.setString(2, regione.getNome());
			preparedStatement.setString(3, regione.getCapoluogo());
			

			preparedStatement.executeUpdate();
	
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

		String deleteSQL = "DELETE FROM " + RegioneDTO.TABLE_NAME + " WHERE codiceistat = ?";

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
	public Regione doRetrieveByKey(int code) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Regione bean = new Regione();

		String selectSQL = "SELECT * FROM " + RegioneDTO.TABLE_NAME + " WHERE codiceistat = ?";

		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				bean.setCodiceistat(rs.getInt("codiceistat"));
				bean.setNome(rs.getString("nome"));
				bean.setCapoluogo(rs.getString("capoluogo"));
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
	public ArrayList<Regione> doRetrieveAll(String order) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Regione> regioni = new ArrayList<Regione>();

		String selectSQL = "SELECT * FROM " + RegioneDTO.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Regione bean = new Regione();

		
				bean.setCodiceistat(rs.getInt("codiceistat"));
				bean.setNome(rs.getString("nome"));
				bean.setCapoluogo(rs.getString("capoluogo"));
				
				regioni.add(bean);
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
		return regioni;
	}
	
	
	

}
