package com.pruebas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebas.entitys.Persona;

public interface PersonasDAO extends JpaRepository<Persona, Integer>{
	
}
