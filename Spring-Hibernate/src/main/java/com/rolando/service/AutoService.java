package com.rolando.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rolando.entity.Auto;
import com.rolando.persistence.AutoRepository;

@Service
@Transactional
public class AutoService {
	
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
