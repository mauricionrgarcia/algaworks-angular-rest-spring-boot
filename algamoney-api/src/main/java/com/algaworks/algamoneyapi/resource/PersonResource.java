package com.algaworks.algamoneyapi.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.algamoneyapi.model.Person;
import com.algaworks.algamoneyapi.service.PersonService;

/**
 * Classe que atende ao recurso Person
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 16/09/2017 13:19:00
 */
@RestController
@RequestMapping("/people")
public class PersonResource {

	/**
	 * Serviço que atende a entidade person
	 */
	@Autowired
	private transient PersonService personService;

	/**
	 * @return retorna todos os registros
	 */
	@GetMapping
	public ResponseEntity<List<Person>> findAll() {
		List<Person> people = personService.findAll();
		return ResponseEntity.ok(people);
	}

	/**
	 * @param code codigo da pessoa
	 * @return Person
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Person> find(@PathVariable("id") Long code) {
		Person person = personService.find(code);
		return person == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(person);
	}

	/**
	 * @param code codigo da pessoa
	 * @return Person
	 */
	@PostMapping()
	public ResponseEntity<Person> save(@Valid @RequestBody Person person) {
		Person returnPerson = personService.save(person);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(returnPerson.getCode()).toUri();
		return ResponseEntity.created(location).build();
	}

}
