package receptionist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import receptionist.domain.Receptionist;

/**
 * DDL functions performed in database
 */
public class ReceptionistDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "getfit_america"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "gfamerica"; //TODO change password

	public Receptionist findByID(Integer employee_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Receptionist receptionist = new Receptionist();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
		    String sql = "select * from receptionist where employee_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,employee_id_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer employee_id = Integer.parseInt(resultSet.getString("employee_id"));
		    	if(employee_id.equals(employee_id_p)){
		    		receptionist.setEmployee_id(employee_id);
		    		receptionist.setFirst_name(resultSet.getString("first_name"));
		    		receptionist.setLast_name(resultSet.getString("last_name"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return receptionist;
	}	
	
	/**
	 * insert Receptionist
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Receptionist form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "insert into receptionist values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getEmployee_id());
		    preparestatement.setString(2,form.getFirst_name());
		    preparestatement.setString(3,form.getLast_name());
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
	
	
	public void update(Receptionist form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "UPDATE receptionist SET first_name = ?, last_name = ? where employee_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1, form.getFirst_name());
		    preparestatement.setString(2, form.getLast_name());
		    preparestatement.setInt(3, form.getEmployee_id());
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
	
	public void delete(String employee_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "delete from receptionist where employee_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(employee_id_p));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
