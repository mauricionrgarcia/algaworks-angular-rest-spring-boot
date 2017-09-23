package com.algaworks.algamoneyapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoneyapi.model.Launch;
import com.algaworks.algamoneyapi.model.Person;
import com.algaworks.algamoneyapi.repository.LaunchRepository;

/**
 * Classe de serviço que centraliza as regras de negocio para lançamentos
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 22/09/2017 21:30:46
 */
@Service
public class LaunchService {

	/**
	 * Atende a comunicação com bando de dados
	 */
	@Autowired
	private transient LaunchRepository launchRepository;

	/**
	 * Serviços que atende pessoa
	 */
	@Autowired
	private transient PersonService personService;

	/**
	 * Recupera todas os lançamentos
	 *
	 * @return {@link List} {@link Launch}
	 */
	public List<Launch> findAll() {
		return launchRepository.findAll();
	}

	/**
	 * @param code codigo
	 * @return recupera um lançamento pelo codigo
	 */
	public Launch find(Long code) {
		Launch Launch = launchRepository.findOne(code);
		if (Launch == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return Launch;
	}

	/**
	 * @param code codigo
	 * @return recupera um lançamento pelo codigo de uma pessoa
	 */
	public List<Launch> findPersonLaunch(Long code) {
		Person person = personService.find(code);
		return launchRepository.findByPerson(person);
	}

	/**
	 * Salva uma nova pessoa
	 *
	 * @param Launch {@link Launch}
	 * @return {@link Launch}
	 */
	public Launch save(Launch Launch) {
		return launchRepository.save(Launch);
	}

	/**
	 * Deleta uma pessoa
	 *
	 * @param code
	 */
	public void delete(Long code) {
		launchRepository.delete(code);
	}

}
