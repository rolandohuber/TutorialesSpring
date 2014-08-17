package com.rolando.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rolando.entity.Auto;
import com.rolando.persistence.AutoRepository;
/**
 *	@Service  con este tag le indicamos a Spring que este objeto va a funcionar en la capa de servicios
 *  @Transactional 
 */
@Service
@Transactional
public class AutoService {
	
	/**
	 *  @Autowired se utiliza para que Spring inyecte el objeto cuando se crea la clase
	 *  funciona si solo se instancia esta clase atravez del applicationContext
	 */
	@Autowired
	private AutoRepository repository;

	public Long save(Auto auto) {
		return repository.save(auto);
	}

	public void update(Auto auto) {
		repository.update(auto);
	}

	public void delete(Auto auto) {
		repository.delete(auto);
	}

	public Collection<Auto> list() {
		return repository.list();
	}
}
