package it.Model.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import it.Model.Comune;
import it.Model.Fermata;
import it.Model.Utente;
import it.Model.Viaggio;

public class ViaggioDTO implements ViaggioDAO {

	
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
	
	private static final String TABLE_NAME = "viaggio";

	@Override
	public void doSave(Viaggio viaggio) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ViaggioDTO.TABLE_NAME
				+ " (prezzo, durata, dataorap, dataorar,idpartenza,idarrivo) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setDouble(1, viaggio.getPrezzo());
			preparedStatement.setTime(2, viaggio.getDurata());
			preparedStatement.setInt(3, viaggio.getPartenza().getId());
			preparedStatement.setInt(4, viaggio.getArrivo().getId());
			

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

		String deleteSQL = "DELETE FROM " + ViaggioDTO.TABLE_NAME + " WHERE codtratta = ?";

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
	public Viaggio doRetrieveByKey(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Viaggio bean = new Viaggio();

		String selectSQL = "SELECT * FROM " + ViaggioDTO.TABLE_NAME + " WHERE codtratta = ?";

		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				bean.setCodicetratta(rs.getInt("codtratta"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setDurata(rs.getTime("durata"));
				
				GregorianCalendar dataorap= new GregorianCalendar();
				dataorap.setTime(rs.getDate("dataorap"));
				bean.setDataOraPartenza(dataorap);
				
				GregorianCalendar dataorar= new GregorianCalendar();
				dataorar.setTime(rs.getDate("dataorar"));
				bean.setDataOraArrivo(dataorar);
				
				bean.setPartenza(setFermata(rs.getInt("idpartenza")));
				bean.setArrivo(setFermata(rs.getInt("idarrivo")));
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
	public ArrayList<Viaggio> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Viaggio> viaggi = new ArrayList<Viaggio>();

		String selectSQL = "SELECT * FROM " + ViaggioDTO.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Viaggio bean = new Viaggio();

				bean.setCodicetratta(rs.getInt("codtratta"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setDurata(rs.getTime("durata"));
				
				GregorianCalendar dataorap= new GregorianCalendar();
				dataorap.setTime(rs.getDate("dataorap"));
				bean.setDataOraPartenza(dataorap);
				
				GregorianCalendar dataorar= new GregorianCalendar();
				dataorar.setTime(rs.getDate("dataorar"));
				bean.setDataOraArrivo(dataorar);
				
				bean.setPartenza(setFermata(rs.getInt("idpartenza")));
				bean.setArrivo(setFermata(rs.getInt("idarrivo")));
				
				viaggi.add(bean);
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
		return viaggi;
	}
	
	private Fermata setFermata(int code) throws SQLException{
		
		FermataDTO fermata= new FermataDTO();
		Fermata bean = fermata.doRetrieveByKey(code);
	
		return bean;	
		
	}


}
