package program.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import program.domain.Program;

/**
 * DDL functions performed in database
 */
public class ProgramDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "getfit_america"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "gfamerica"; //TODO change password

	public Program findByEnrollmentNumber(Integer enrollment_number_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Program program = new Program();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
		    String sql = "select * from program where enrollment_number=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,enrollment_number_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer enrollment_number =Integer.parseInt( resultSet.getString("enrollment_number"));
		    	if(enrollment_number.equals(enrollment_number_p)){
		    		program.setEnrollment_number(enrollment_number_p);
		    		program.setProgram_id(Integer.parseInt( resultSet.getString("program_id")));
		    		program.setProgram_name(resultSet.getString("program_name"));	
		    		program.setDescription(resultSet.getString("description"));	
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return program;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Program form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "insert into program (enrollment_number,program_id,program_name,description) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getEnrollment_number());
		    preparestatement.setInt(2,form.getProgram_id());
		    preparestatement.setString(3,form.getProgram_name());
		    preparestatement.setString(4,form.getDescription());
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
	public void update(Program form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "UPDATE program SET program_id = ?, program_name = ?, description = ? where enrollment_number = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getProgram_id());
			preparestatement.setString(2,form.getProgram_name());
		    preparestatement.setString(3,form.getDescription());
		    preparestatement.setInt(4,form.getEnrollment_number());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param enrollment_number_p
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String enrollment_number_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "delete from program where enrollment_number = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt( enrollment_number_p));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
