package com.algaworks.algamoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algamoneyapi.model.Person;

/**
 * Repositorio que atende a entidade {@link Person}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 16/09/2017 13:15:16
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
