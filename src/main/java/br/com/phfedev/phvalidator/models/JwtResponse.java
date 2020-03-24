package br.com.phfedev.phvalidator.models;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8948131621195574892L;

	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
