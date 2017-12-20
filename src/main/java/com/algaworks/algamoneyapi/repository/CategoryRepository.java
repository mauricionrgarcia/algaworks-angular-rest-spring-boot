package com.algaworks.algamoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algamoneyapi.model.Category;

/**
 * Repositorio que atende a entidade {@link Category}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 15/09/2017 22:21:50
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
