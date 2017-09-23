package com.algaworks.algamoneyapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algamoneyapi.model.Launch;
import com.algaworks.algamoneyapi.model.Person;

/**
 * Repositorio que atende a entidade {@link Launch}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 22/09/2017 21:30:18
 */
public interface LaunchRepository extends JpaRepository<Launch, Long> {

	/**
	 * Recupera a lista de lançamentos dada uma pessoa
	 *
	 * @param person {@link Person}
	 * @return lista de lançamentos de uma pessoa
	 */
	List<Launch> findByPerson(Person person);

}
