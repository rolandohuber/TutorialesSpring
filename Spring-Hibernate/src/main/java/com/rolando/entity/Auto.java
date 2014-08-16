package com.rolando.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
@javax.persistence.Entity
public class Auto extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2198412868725012346L;
	private String patente;

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

}
