package program.domain;

/**
 * User object
 * 
 * @author Melville Misayah
 * 
 */
public class Program {
	/*
	 * Correspond to the user table
	 */
	
	private Integer enrollment_number;
	private Integer program_id;
	private String program_name;
	private String description;
	
	
	public Integer getEnrollment_number() {
		return enrollment_number;
	}
	public void setEnrollment_number(Integer enrollment_number) {
		this.enrollment_number = enrollment_number;
	}
	public Integer getProgram_id() {
		return program_id;
	}
	public void setProgram_id(Integer program_id) {
		this.program_id = program_id;
	}
	public String getProgram_name() {
		return program_name;
	}
	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}
