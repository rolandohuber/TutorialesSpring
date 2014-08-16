package com.rolando.persistence;

import org.springframework.stereotype.Repository;

import com.rolando.entity.Auto;
@Repository
public class AutoRepository extends EntityRepository<Auto>{

	public AutoRepository() {
		super(Auto.class);
	}

}
