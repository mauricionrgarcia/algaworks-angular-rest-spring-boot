package com.algaworks.algamoneyapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return personRepository.findOne(code);
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
}
