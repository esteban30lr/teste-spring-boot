package com.pruebas.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.dao.PersonasDAO;
import com.pruebas.entitys.Persona;

@RestController
@RequestMapping("persona")
public class ProductsRest {

	@Autowired
	private PersonasDAO personasDao;

	// metodo que devuelve todos las personas
	@GetMapping
	public ResponseEntity<List<Persona>> getPersona() {
		List<Persona> personas = personasDao.findAll();
		return ResponseEntity.ok(personas);
	}

	// metodo que devuelve una persona por id
	@RequestMapping(value = "{id}") // /persona /id
	public ResponseEntity<Persona> getPersonaById(@PathVariable("id") int id) {
		Optional<Persona> optionalPersona = personasDao.findById(id);

		if (optionalPersona.isPresent()) {
			return ResponseEntity.ok(optionalPersona.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//metodo para ingresar una nueva persona desde el body con formato json
	@PostMapping
	public ResponseEntity<Persona> crearPersona(@RequestBody Persona Persona){
		Persona newPersona = personasDao.save(Persona);
		return ResponseEntity.ok(newPersona);
	}
	
	//metodo para eliminar una persona 
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> deltePersona(@PathVariable("id") int id){
		personasDao.deleteById(id);
		return ResponseEntity.ok(null);
	}

}
