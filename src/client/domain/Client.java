package client.domain;

/**
 * User object
 * 
 * @author Mitchell Misayah
 * 
 */
public class Client {
	/*
	 * Correspond to the user table
	 */
	
	private Integer client_id;
	private Integer trainer_id; 
	private String first_name;
	private String last_name;
	
	private Integer age;
	private Double weight;
	private Double body_fat;
	
	
	public Integer getClient_id() {
		return client_id;
	}
	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}
	public Integer getTrainer_id() {
		return trainer_id;
	}
	public void setTrainer_id(Integer trainer_id) {
		this.trainer_id = trainer_id;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getBody_fat() {
		return body_fat;
	}
	public void setBody_fat(Double body_fat) {
		this.body_fat = body_fat;
	}
	
	
	
}
