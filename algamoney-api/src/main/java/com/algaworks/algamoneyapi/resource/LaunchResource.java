package com.algaworks.algamoneyapi.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.algamoneyapi.model.Launch;
import com.algaworks.algamoneyapi.repository.filter.LaunchFilter;
import com.algaworks.algamoneyapi.repository.projection.SimpleLaunch;
import com.algaworks.algamoneyapi.service.LaunchService;

/**
 * Classe que atende ao recurso Lançamento
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 22/09/2017 21:29:22
 */
@RestController
@RequestMapping("/launches")
public class LaunchResource {

	/**
	 * Service que atende os lançamentos
	 */
	@Autowired
	private transient LaunchService launchService;

	/**
	 * @return todos os lançamentos
	 */
	// @GetMapping
	// @ResponseStatus(code = HttpStatus.OK)
	@Deprecated
	public ResponseEntity<List<Launch>> findAll() {
		List<Launch> launches = launchService.findAll();
		return ResponseEntity.ok().body(launches);
	}

	/**
	 * Lançamento de codigo
	 *
	 * @param code codigo
	 * @return lançamento
	 */
	@GetMapping
	public ResponseEntity<Page<Launch>> searchLanches(LaunchFilter filter, Pageable page) {
		Page<Launch> launches = launchService.findByFilter(filter, page);
		return ResponseEntity.ok().body(launches);
	}

	/**
	 * Lançamento de codigo - projection simple
	 *
	 * @param code codigo
	 * @return lançamento
	 */
	@GetMapping(params = "summary")
	public ResponseEntity<Page<SimpleLaunch>> searchSimpleLanches(LaunchFilter filter, Pageable page) {
		Page<SimpleLaunch> launches = launchService.searchSimpeLaunchByFilter(filter, page);
		return ResponseEntity.ok().body(launches);
	}

	/**
	 * Lançamento de codigo
	 *
	 * @param code codigo
	 * @return lançamento
	 */
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Launch> find(@PathVariable("id") Long code) {
		Launch launch = launchService.find(code);
		return ResponseEntity.ok(launch);
	}

	/**
	 * Lançamento de de uma pessoa
	 *
	 * @param code codigo da pessoa
	 * @return lançamento de uma pessoa
	 */
	@GetMapping("/person/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<Launch>> findLaunchesByPerson(@PathVariable("id") Long code) {
		List<Launch> launches = launchService.findPersonLaunch(code);
		return ResponseEntity.ok(launches);
	}

	/**
	 * Salva um lançamento
	 *
	 * @param launch
	 * @return launch
	 */
	@PostMapping
	public ResponseEntity<Launch> saveLaunch(@Valid @RequestBody Launch launch) {
		Launch returnLaunch = launchService.save(launch);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(returnLaunch.getCode()).toUri();
		return ResponseEntity.created(uri).body(returnLaunch);
	}

	/**
	 * Deletear um lançamento
	 *
	 * @param code
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long code) {
		launchService.delete(code);
		return ResponseEntity.noContent().build();
	}

}
