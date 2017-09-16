package com.algaworks.algamoneyapi.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.algamoneyapi.model.Category;
import com.algaworks.algamoneyapi.service.CategoryService;

/**
 * Classe que atende ao recurso Category
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 15/09/2017 22:25:50
 */
@RestController
@RequestMapping("/categories")
public class CategoryResource {

	/**
	 * Serviço que atende categoria
	 */
	@Autowired
	private transient CategoryService categoryService;

	/**
	 * @return todas as categorias cadastradas
	 */
	@GetMapping // @RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Category>> findAll() {
		List<Category> categories = categoryService.findAll();
		return ResponseEntity.ok().body(categories);
	}

	/**
	 * Salvar uma nova categoria
	 *
	 * @param category {@link Category}
	 * @return location
	 */
	@PostMapping
	public ResponseEntity<Category> createCateogry(@RequestBody Category category) {
		Category returnCategory = categoryService.save(category);

		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(returnCategory.getCode()).toUri();
		return ResponseEntity.created(location).body(returnCategory);

	}

	/**
	 * Recuperar uma categoria dado um codigo
	 *
	 * @param code codigo da categoria
	 * @return categoria
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Category> findCategory(@PathVariable("id") Long code) {
		Category category = categoryService.find(code);
		return category == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(category);
	}

}