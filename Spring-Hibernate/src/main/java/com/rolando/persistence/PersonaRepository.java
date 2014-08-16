package com.rolando.persistence;

import org.springframework.stereotype.Repository;

import com.rolando.entity.Persona;
@Repository
public class PersonaRepository extends EntityRepository<Persona>{

	public PersonaRepository() {
		super(Persona.class);
	}

}
