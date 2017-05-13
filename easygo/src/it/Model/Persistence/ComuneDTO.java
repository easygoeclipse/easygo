package it.Model.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import it.Model.Comune;
import it.Model.Provincia;

public class ComuneDTO implements ComuneDAO {
	
	private static final String TABLE_NAME = "comune";

	
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
	
	
	public void doSave(Comune comune) throws SQLException{
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ComuneDTO.TABLE_NAME
				+ " (latitudine, longitudine, nome, provincia) VALUES (?,?,?,?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, comune.getLatitudine());
			preparedStatement.setString(2, comune.getLongitudine());
			preparedStatement.setString(3, comune.getNome());
			preparedStatement.setString(4, comune.getProvincia().getSigla());
			
			insertSQL= "SELECT Max(codice) AS maxcodice FROM" + ComuneDTO.TABLE_NAME;
			preparedStatement = connection.prepareStatement(insertSQL);
			ResultSet rs = preparedStatement.executeQuery();
			comune.setCodice(rs.getInt("maxcodice"));
			

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

	public boolean doDelete(int code) throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ComuneDTO.TABLE_NAME + " WHERE codice = ?";

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

	public Comune doRetrieveByKey(int code) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Comune bean = new Comune();

		String selectSQL = "SELECT * FROM " + ComuneDTO.TABLE_NAME + " JOIN provincia ON comune.provincia=provincia.sigla WHERE codice = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				bean.setCodice(rs.getInt("codice"));

				bean.setLatitudine(rs.getString("latitudine"));
				bean.setLongitudine(rs.getString("longitudine"));
				bean.setNome(rs.getString("nome"));
				
				Provincia provincia = new Provincia();
				provincia.setSigla(rs.getString("provincia"));
				provincia.setNome(rs.getString("nome"));
				provincia.setCapoluogo(rs.getString("capoluogo"));
				
				bean.setProvincia(provincia);
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
	
	public Collection<Comune> doRetrieveAll(String order) throws SQLException{
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Comune> comuni = new ArrayList<Comune>();

		String selectSQL = "SELECT * FROM " + ComuneDTO.TABLE_NAME + " JOIN provincia ON comune.provincia=provincia.sigla";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Comune bean = new Comune();

				bean.setCodice(rs.getInt("codice"));

				bean.setLatitudine(rs.getString("latitudine"));
				bean.setLongitudine(rs.getString("longitudine"));
				bean.setNome(rs.getString("nome"));
				
				Provincia provincia = new Provincia();
				provincia.setSigla(rs.getString("provincia"));
				provincia.setNome(rs.getString("nome"));
				provincia.setCapoluogo(rs.getString("capoluogo"));
				
				bean.setProvincia(provincia);
				
				comuni.add(bean);
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
		return comuni;
		
	}
	
	
}
