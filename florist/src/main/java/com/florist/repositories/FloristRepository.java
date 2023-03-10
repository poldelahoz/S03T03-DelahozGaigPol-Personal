package com.florist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.florist.models.Florist;

public interface FloristRepository extends JpaRepository<Florist, Integer>, CrudRepository<Florist, Integer>{
	
}
