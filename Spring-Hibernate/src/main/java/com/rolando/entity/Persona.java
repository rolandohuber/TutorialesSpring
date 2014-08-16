package com.rolando.entity;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@javax.persistence.Entity
public class Persona extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6272219083560822820L;
	private String apellido;
	private Auto auto;

	@OneToOne(fetch = FetchType.LAZY)
	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
