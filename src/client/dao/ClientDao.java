package client.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import client.domain.Client;
import client.domain.ClientAvg;
import program.domain.ProgramKeto;

/**
 * DDL functions performed in database
 */
public class ClientDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "getfit_america"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "gfamerica"; //TODO change password

	public Client findByClientID(Integer client_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Client client = new Client();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
		    String sql = "select * from client where client_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,client_id_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer client_id = Integer.parseInt( resultSet.getString("client_id"));
		    	if(client_id.equals(client_id_p)){
		    		client.setClient_id(Integer.parseInt( resultSet.getString("client_id")));
		    		client.setTrainer_id(Integer.parseInt( resultSet.getString("trainer_id")));
		    		client.setFirst_name(resultSet.getString("first_name"));
		    		client.setLast_name(resultSet.getString("last_name"));
		    		client.setAge(Integer.parseInt( resultSet.getString("age")));
		    		client.setWeight(Double.parseDouble( resultSet.getString("weight")));
		    		client.setBody_fat(Double.parseDouble( resultSet.getString("body_fat")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return client;
	}	
	
	/**
	 * insert Client
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Client form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "insert into client (client_id, trainer_id, first_name, last_name, age, weight, body_fat) values(?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
			
		    preparestatement.setInt(1,form.getClient_id());
		    preparestatement.setInt(2,form.getTrainer_id());
		    preparestatement.setString(3,form.getFirst_name());
		    preparestatement.setString(4,form.getLast_name());
		    preparestatement.setInt(5,form.getAge());
		    preparestatement.setDouble(6, form.getWeight());
		    preparestatement.setDouble(7, form.getBody_fat());
		    
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(Client form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "UPDATE client SET trainer_id = ?, first_name = ?, last_name = ?, age = ?, weight = ?, body_fat = ? where client_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
			preparestatement.setInt(1, form.getTrainer_id());
		    preparestatement.setString(2,form.getFirst_name());
			preparestatement.setString(3,form.getLast_name());
			preparestatement.setInt(4, form.getAge());
			preparestatement.setDouble(5, form.getWeight());
			preparestatement.setDouble(6, form.getBody_fat());
			preparestatement.setInt(7, form.getClient_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String client_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "delete from client where client_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt( client_id_p));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Object> findWeightAvg() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			String sql = "select * from avg_weight";
			//CREATE VIEW as avg_weight
			//		SELECT AVG(weight) as avg_weight from client WHERE age > 18;
			
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				ClientAvg program = new ClientAvg();
				program.setAvg_weight(Double.parseDouble(resultSet.getString("avg_weight")));
	    		list.add(program);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
