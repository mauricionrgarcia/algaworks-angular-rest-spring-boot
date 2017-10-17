package com.algaworks.algamoneyapi.repository.launch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.algamoneyapi.model.Launch;
import com.algaworks.algamoneyapi.repository.filter.LaunchFilter;

/**
 * Repositorio que atende a entidade {@link Launch}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 23/09/2017 14:29:17
 */
public interface LaunchRepositoryQuery {

	/**
	 * buscar todos os lançamentos por filto
	 *
	 * @param filter
	 * @param page
	 * @return
	 */
	public Page<Launch> searchByFilter(LaunchFilter filter, Pageable page);

}
