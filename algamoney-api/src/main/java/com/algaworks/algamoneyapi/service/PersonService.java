package com.algaworks.algamoneyapi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoneyapi.exception.NonExistentActivePersonException;
import com.algaworks.algamoneyapi.model.Address;
import com.algaworks.algamoneyapi.model.Person;
import com.algaworks.algamoneyapi.repository.PersonRepository;

/**
 * Classe de serviço que centraliza as regras de negocio para pessoas
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 16/09/2017 13:16:43
 */
@Service
public class PersonService {

	/**
	 * Atende a comunicação com bando de dados
	 */
	@Autowired
	private transient PersonRepository personRepository;

	/**
	 * Recupera todas as pessoas cadastradas
	 *
	 * @return {@link List} {@link Person}
	 */
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	/**
	 * @param code codigo
	 * @return recupera uma pessoa pelo codigo
	 */
	public Person find(Long code) {
		Person person = personRepository.findOne(code);
		if (person == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return person;
	}

	/**
	 * @param code codigo
	 * @return recupera uma pessoa pelo codigo
	 */
	public Person findActivePerson(Long code) {
		Person person = personRepository.findByCodeAndActiveTrue(code);
		if (person == null) {
			throw new NonExistentActivePersonException();
		}
		return person;
	}

	/**
	 * Salva uma nova pessoa
	 *
	 * @param person {@link Person}
	 * @return {@link Person}
	 */
	public Person save(Person person) {
		return personRepository.save(person);
	}

	/**
	 * Deleta uma pessoa
	 *
	 * @param code
	 */
	public void delete(Long code) {
		personRepository.delete(code);
	}

	/**
	 * Atualizar uma pessoa
	 *
	 * @param code
	 * @param person
	 * @return pessoa
	 */
	public Person update(Long code, Person person) {
		Person currentPerson = find(code);
		BeanUtils.copyProperties(person, currentPerson, "code");
		return personRepository.save(person);
	}

	/**
	 * Atualiza o active de pessoa
	 *
	 * @param code
	 * @param active
	 * @return
	 */
	public Person updateActive(Long code, Boolean active) {
		Person person = find(code);
		person.setActive(active);
		return personRepository.save(person);
	}

	/**
	 * Atualizar o endereço da pessoa
	 *
	 * @param code
	 * @param address
	 * @return
	 */
	public Person updateAddress(Long code, Address address) {
		Person person = find(code);
		BeanUtils.copyProperties(address, person.getAddress());
		return personRepository.save(person);
	}

}
