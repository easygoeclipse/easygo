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

import it.Model.Provincia;
import it.Model.Regione;
import it.Model.Viaggio;

public class ProvinciaDTO implements ProvinciaDAO {
	
	
	
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
	
	private static final String TABLE_NAME = "provincia";

	@Override
	public void doSave(Provincia provincia) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ProvinciaDTO.TABLE_NAME
				+ " (sigla,nome,capoluogo,istatregione) VALUES (?, ?, ?,?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, provincia.getSigla());
			preparedStatement.setString(2, provincia.getNome());
			preparedStatement.setString(3, provincia.getCapoluogo());
			preparedStatement.setInt(4, provincia.getRegione().getCodiceistat());

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
	public boolean doDelete(String code) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ProvinciaDTO.TABLE_NAME + " WHERE sigla = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, code);

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
	public Provincia doRetrieveByKey(String code) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Provincia bean = new Provincia();

		String selectSQL = "SELECT * FROM provincia JOIN regione ON provincia.istatregione=regione.codiceistat WHERE sigla=?";

		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, code);;

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				bean.setSigla(rs.getString("sigla"));
				bean.setNome(rs.getString("nome"));
				bean.setCapoluogo(rs.getString("capoluogo"));
				bean.setRegione(setRegione(rs.getInt("istatregione")));
				
			
				
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
	public ArrayList<Provincia> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Provincia> province = new ArrayList<Provincia>();

		String selectSQL = "SELECT * FROM " + ProvinciaDTO.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Provincia bean = new Provincia();

				bean.setSigla(rs.getString("provincia"));
				bean.setNome(rs.getString("nome"));
				bean.setCapoluogo(rs.getString("capoluogo"));
				bean.setRegione(setRegione(rs.getInt("istatregione")));
				
				province.add(bean);
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
		return province;
	}
	
	
	private Regione setRegione(int code) throws SQLException{
		
		RegioneDTO regione= new RegioneDTO();
		return regione.doRetrieveByKey(code);
		
	}

}
