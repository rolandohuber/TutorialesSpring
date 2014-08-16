package com.rolando.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rolando.entity.Persona;
import com.rolando.persistence.PersonaRepository;

@Service
@Transactional
public class PersonaService {

	@Autowired
	private PersonaRepository repository;

	public Long save(Persona persona) {
		return repository.save(persona);
	}

	public void update(Persona persona) {
		repository.update(persona);
	}

	public void delete(Persona persona) {
		repository.delete(persona);
	}

	public Collection<Persona> list() {
		return repository.list();
	}
}
