package com.algaworks.algamoneyapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algamoneyapi.model.Category;
import com.algaworks.algamoneyapi.repository.CategoryRepository;

/**
 * Classe de serviço que centraliza as regras de negocio para categorias
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 15/09/2017 22:30:41
 */
@Service
public class CategoryService {

	@Autowired
	private transient CategoryRepository categoryRepository;

	/**
	 * Recupera todas as categorias cadastradas
	 *
	 * @return todas as {@link Category}
	 */
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	/**
	 * Persiste uma nova categoria
	 *
	 * @param category {@link Category}
	 * @return {@link Category}
	 */
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	/**
	 * @param code codigo da categoria
	 * @return categoria que atende o parametro
	 */
	public Category find(Long code) {
		return categoryRepository.findOne(code);
	}

}
