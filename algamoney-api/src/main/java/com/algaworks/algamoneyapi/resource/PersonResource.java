package com.algaworks.algamoneyapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.algaworks.algamoneyapi.event.ResourceSaveEvent;
import com.algaworks.algamoneyapi.model.Address;
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
	 * Controle dos eventos
	 */
	@Autowired
	private ApplicationEventPublisher publisher;

	/**
	 * @return retorna todos os registros
	 */
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEE_PERSON') and #oauth2.hasScope('read')")
	public ResponseEntity<List<Person>> findAll() {
		List<Person> people = personService.findAll();
		return ResponseEntity.ok(people);
	}

	/**
	 * @param code codigo da pessoa
	 * @return Person
	 */
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEE_PERSON') and #oauth2.hasScope('read')")
	public ResponseEntity<Person> find(@PathVariable("id") Long code) {
		Person person = personService.find(code);
		return person == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(person);
	}

	/**
	 * @param code codigo da pessoa
	 * @return Person
	 */
	@PostMapping()
	@PreAuthorize("hasAuthority('ROLE_CREATE_PERSON') and #oauth2.hasScope('write')")
	public ResponseEntity<Person> save(@Valid @RequestBody Person person, HttpServletResponse response) {

		Person returnPerson = personService.save(person);
		publisher.publishEvent(new ResourceSaveEvent(this, response, returnPerson.getCode()));

		return ResponseEntity.status(HttpStatus.CREATED).body(returnPerson);
	}

	/**
	 * Deletar uma pessoa
	 *
	 * @param code
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVE_PERSON') and #oauth2.hasScope('write')")
	public void delete(@PathVariable("id") Long code) {
		personService.delete(code);
	}

	/**
	 * Atualizar uma pessoa
	 *
	 * @param code
	 * @param person
	 */
	@PutMapping("{id}")
	@PreAuthorize("hasAuthority('ROLE_CREATE_PERSON') and #oauth2.hasScope('write')")
	public ResponseEntity<Person> update(@PathVariable("id") Long code, @Valid @RequestBody Person person) {
		person = personService.update(code, person);
		return ResponseEntity.ok(person);
	}

	/**
	 * Atualizar o status de uma pessoa
	 *
	 */
	@PutMapping("{id}/active")
	@PreAuthorize("hasAuthority('ROLE_CREATE_PERSON') and #oauth2.hasScope('write')")
	public ResponseEntity<Person> updateActive(@PathVariable("id") Long code, @RequestBody Boolean active) {
		Person person = personService.updateActive(code, active);
		return ResponseEntity.ok(person);
	}

	/**
	 * Atualizar o enderesso de uma pessoa
	 *
	 */
	@PutMapping("{id}/address")
	@PreAuthorize("hasAuthority('ROLE_CREATE_PERSON') and #oauth2.hasScope('write')")
	public ResponseEntity<Person> updateAddress(@PathVariable("id") Long code, @Valid @RequestBody Address address) {
		Person person = personService.updateAddress(code, address);
		return ResponseEntity.ok(person);
	}

}
