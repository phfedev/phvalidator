package br.com.phfedev.phvalidator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Required;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	private Integer requestCounter;
	
	public User() {
		
	}
	
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Integer getRequestCounter() {
		return requestCounter;
	}

	public void setRequestCounter(Integer requestCounter) {
		this.requestCounter = requestCounter;
	}

	public void addCounter() {
		if (requestCounter == null) {
			setRequestCounter(1);
		} else {
			requestCounter++;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
