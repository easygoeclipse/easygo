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

import it.Model.Autobus;
import it.Model.Viaggio;

public class AutobusDTO implements AutobusDAO {
	
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
	
	private static final String TABLE_NAME = "autobus";
	
	

	
	public void doSave(Autobus autobus) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + AutobusDTO.TABLE_NAME
				+ " (targa, postidisp,tipo) VALUES (?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, autobus.getTarga());
			preparedStatement.setInt(2,autobus.getPostidisp());
			preparedStatement.setString(3,autobus.getTipo());
			

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
	
	public boolean doDelete(String code) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + AutobusDTO.TABLE_NAME + " WHERE targa = ?";

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


	public Autobus doRetrieveByKey(String code) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Autobus bean = new Autobus();

		String selectSQL = "SELECT * FROM " + AutobusDTO.TABLE_NAME + " WHERE targa = ?";

		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				bean.setTarga(rs.getString("targa"));
				bean.setPostidisp(rs.getInt("postidisp"));
				bean.setTipo(rs.getString("tipo"));
				
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

	
	public ArrayList<Autobus> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Autobus> autobus = new ArrayList<Autobus>();

		String selectSQL = "SELECT * FROM " + AutobusDTO.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Autobus bean = new Autobus();

				
				
				bean.setTarga(rs.getString("targa"));
				bean.setPostidisp(rs.getInt("postidisp"));
				bean.setTipo(rs.getString("tipo"));
				
				autobus.add(bean);
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
		return autobus;
	}
	
	
	
}
