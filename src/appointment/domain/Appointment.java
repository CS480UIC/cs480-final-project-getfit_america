package appointment.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Melville Misayah
 * 
 */
public class Appointment {
	/*
	 * Correspond to the user table
	 */
	
	private Integer selected_prog;
	private Date appointment_date; 
	private String location;
	private Integer program_app_num;
	/**
	 * @return the selected_prog
	 */
	public Integer getSelected_prog() {
		return selected_prog;
	}
	/**
	 * @param selected_prog the selected_prog to set
	 */
	public void setSelected_prog(Integer selected_prog) {
		this.selected_prog = selected_prog;
	}
	/**
	 * @return the appointment_date
	 */
	public Date getAppointment_date() {
		return appointment_date;
	}
	/**
	 * @param appointment_date the appointment_date to set
	 */
	public void setAppointment_date(Date appointment_date) {
		this.appointment_date = appointment_date;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the program_app_num
	 */
	public Integer getProgram_app_num() {
		return program_app_num;
	}
	/**
	 * @param program_app_num the program_app_num to set
	 */
	public void setProgram_app_num(Integer program_app_num) {
		this.program_app_num = program_app_num;
	}
	
	

}
