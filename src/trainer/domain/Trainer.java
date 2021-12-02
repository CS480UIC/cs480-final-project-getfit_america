package trainer.domain;

/**
 * Trainer object
 * 
 * @author Mitchell Misayah
 * 
 */
public class Trainer {
	/*
	 * Correspond to the user table
	 */
	
	private Integer employee_id;
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	private String first_name; 
	private String last_name;
	
	
}
