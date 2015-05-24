package com.rolando.persistence;

import org.springframework.stereotype.Repository;

import com.rolando.entity.Persona;

/**
 * @Repository con este tag le indicamos a Spring que este objeto va a tener
 *             interaccion con la base de datos
 */
@Repository
public class PersonaRepository extends EntityRepository<Persona> {
	public PersonaRepository() {
		super(Persona.class);
	}
}
