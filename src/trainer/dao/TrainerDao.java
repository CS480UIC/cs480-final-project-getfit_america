package trainer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import trainer.domain.Trainer;
import trainer.domain.TrainerClient;


/**
 * DDL functions performed in database
 */
public class TrainerDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "getfit_america"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "gfamerica"; //TODO change password

	public Trainer findByEmployeeID(Integer employee_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Trainer trainer = new Trainer();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
		    String sql = "select * from trainer  where employee_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,employee_id_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer employee_id = Integer.parseInt(resultSet.getString("employee_id"));
		    	if(employee_id.equals(employee_id_p)){
		    		trainer.setEmployee_id(employee_id);
		    		trainer.setFirst_name(resultSet.getString("first_name"));
		    		trainer.setLast_name(resultSet.getString("last_name"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return trainer;
	}	
	
	
	
	
	
	/**
	 * insert Trainer
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */	
	public void add(Trainer form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "insert into trainer (employee_id,first_name,last_name) values(?,?,?)";
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
	public void update(Trainer form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "UPDATE trainer SET first_name = ?, last_name = ? where employee_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    
			preparestatement.setString(1,form.getFirst_name());
		    preparestatement.setString(2,form.getLast_name());
		    preparestatement.setInt(3,form.getEmployee_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param employee_id_p
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String employee_id_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			
			String sql = "delete from trainer where employee_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(employee_id_p));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}






	
	public List<Object> findallTrainers() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			String sql = "select * from trainer where employee_id < 200";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Trainer trainer = new Trainer();
				trainer.setEmployee_id(resultSet.getInt("employee_id"));
	    		trainer.setFirst_name(resultSet.getString("first_name"));
	    		trainer.setLast_name(resultSet.getString("last_name"));
	    		list.add(trainer);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> findTrainerClient() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/getfitamerica", MySQL_user, MySQL_password);
			String sql = "select * from trainerclient";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				TrainerClient trainer = new TrainerClient();
				
				trainer.setClient_name(resultSet.getString("trainer_name"));
				trainer.setTrainer_name(resultSet.getString("client_name"));
	    		list.add(trainer);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
