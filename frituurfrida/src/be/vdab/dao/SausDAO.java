package be.vdab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.sql.DataSource;

import be.vdab.entities.Saus;

public class SausDAO {
	
	public final static String JNDI_NAME = "jdbc/frituurfrieda";   
	protected DataSource dataSource; 
	private static final String BEGIN_SELECT = "SELECT sauzen.sausid,sausnaam,ingredientnaam FROM sauzen";
	private static final String JOIN_ALL = " LEFT JOIN (recepten INNER JOIN ingredienten ON recepten.ingredientid=ingredienten.ingredientid) ON sauzen.sausid=recepten.sausid";
	private static final String FIND_ALL_SQL = BEGIN_SELECT + JOIN_ALL + " ORDER BY sausnaam ASC";
	private static final String MATCH_SQL = BEGIN_SELECT + JOIN_ALL + " WHERE ingredientnaam=? ORDER BY sausnaam ASC";
	private static final String DELETE_SQL = "delete from sauzen where sausid=?"; 
		
	public void setDataSource(DataSource dataSource) {     
		this.dataSource = dataSource;
	}
		
	public CopyOnWriteArrayList<Saus> findAll() {
		try (Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
		    		ResultSet resultSet = statement.executeQuery(FIND_ALL_SQL)) {
			CopyOnWriteArrayList<Saus> sauzen = new CopyOnWriteArrayList<>();
			long currentId=0;
		    while (resultSet.next()) {
		    	if (resultSet.getLong("sausid") != currentId){
		    		sauzen.add(resultSetRijNaarSausLegeIngredienten(resultSet));
		    		currentId = resultSet.getLong("sausid");
		    	} 
		    	sauzen.get(sauzen.size()-1).addIngredient(resultSet.getString("ingredientnaam"));		    	
		    }
		    return sauzen;
		    } catch (SQLException ex) { 
		    	throw new DAOException(ex); 
		    }
	}
			
	private Saus resultSetRijNaarSausLegeIngredienten(ResultSet resultSet) throws SQLException { 	
		return new Saus(resultSet.getLong("sausid"), resultSet.getString("sausnaam"), new CopyOnWriteArrayList<String>());
	}
	
	public Iterable<Saus> findByIngredient(String ingredient) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(MATCH_SQL)) {
			CopyOnWriteArrayList<Saus> sauzen = new CopyOnWriteArrayList<>();
			statement.setString(1, ingredient);    
			try (ResultSet resultSet = statement.executeQuery()) {
			   	while (resultSet.next()) {
			   		sauzen.add(resultSetRijNaarSausLegeIngredienten(resultSet));
			    }
			    return sauzen;
			    }
		} catch (SQLException ex) {
			throw new DAOException(ex);
		}
	}
	
	public void verwijderSaus(long nummer) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
			statement.setLong(1, nummer);
			statement.executeUpdate(); 
		} catch (SQLException ex) {
			throw new DAOException(ex);
		}
	}
	
	public int hoeveelSauzen() {
		return findAll().size();
	}
	
}