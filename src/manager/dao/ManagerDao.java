package manager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import manager.domain.Manager;

/**
 * DDL functions performed in database
 */
public class ManagerDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "getfit_america"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "gfamerica"; //TODO change password

	public Manager findByID(Integer id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Manager manager = new Manager();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
		    String sql = "select * from manager where id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,id_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer id = Integer.parseInt(resultSet.getString("id"));
		    	System.out.println("id:" + id + "id_p:" + id_p);
		    	// CHANGED FROM == to .equals()
		    	if(id.equals(id_p) ){
		    		System.out.println("inside if statement");
		    		manager.setCreated_at(resultSet.getDate("created_at"));
		    		manager.setDepartment_id(Integer.parseInt(resultSet.getString("department_id")));
		    		manager.setFirst_name(resultSet.getString("first_name"));
		    		manager.setId(id);
		    		manager.setLast_name(resultSet.getString("last_name"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println("manger:" + manager.getId());
		return manager;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Manager form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "insert into manager values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setInt(1,form.getId());
		    preparestatement.setInt(2,form.getDepartment_id());
		    preparestatement.setString(3,form.getFirst_name());
		    preparestatement.setString(4,form.getLast_name());
		    preparestatement.setDate(5,form.getCreated_at());
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
	
	
	public void update(Manager form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "UPDATE manager SET department_id = ?, first_name = ?, last_name = ?, created_at = ? where id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setInt(1,form.getDepartment_id());
			preparestatement.setString(2,form.getFirst_name());
		    preparestatement.setString(3,form.getLast_name());
		    preparestatement.setDate(4,form.getCreated_at());
			preparestatement.setInt(5,form.getId());
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
	
	
	public void delete(String id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "delete from manager where id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(id_p));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
