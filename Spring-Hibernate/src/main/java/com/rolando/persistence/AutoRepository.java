package com.rolando.persistence;

import org.springframework.stereotype.Repository;

import com.rolando.entity.Auto;
/**
 *	@Repository  con este tag le indicamos a Spring que este objeto va a tener interaccion 
 *con la base de datos 
 */
@Repository
public class AutoRepository extends EntityRepository<Auto>{

	public AutoRepository() {
		super(Auto.class);
	}

}
