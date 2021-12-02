package appointment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import appointment.domain.Appointment;

/**
 * DDL functions performed in database
 */
public class AppointmentDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "getfit_america"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "gfamerica"; //TODO change password

	public Appointment findBySelectedProg(Integer selected_prog_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Appointment appointment = new Appointment();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
		    String sql = "select * from appointment where selected_prog=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,selected_prog_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer selected_prog = Integer.parseInt(resultSet.getString("selected_prog"));
		    	if(selected_prog.equals(selected_prog_p)){
		    		appointment.setSelected_prog(selected_prog);
		    		appointment.setAppointment_date(resultSet.getDate("appointment_date"));
		    		appointment.setLocation(resultSet.getString("location"));
		    		appointment.setProgram_app_num(resultSet.getInt("program_app_num"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return appointment;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Appointment form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "insert into appointment values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getSelected_prog());
		    preparestatement.setDate(2,form.getAppointment_date());
		    preparestatement.setString(3,form.getLocation());
		    preparestatement.setInt(4,form.getProgram_app_num());
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
	public void update(Appointment form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "UPDATE appointment SET appointment_date = ?, location = ?, program_app_num = ? where selected_prog = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setDate(1,form.getAppointment_date());
			preparestatement.setString(2,form.getLocation());
		    preparestatement.setInt(3,form.getProgram_app_num());
		    preparestatement.setInt(4,form.getSelected_prog());
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
	public void delete(String selected_prog_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "delete from appointment where selected_prog = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setInt(1,Integer.parseInt(selected_prog_p));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
