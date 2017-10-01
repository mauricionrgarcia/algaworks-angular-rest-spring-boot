package com.algaworks.algamoneyapi.repository.launch;

import java.util.List;

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
	 * @return
	 */
	public List<Launch> searchByFilter(LaunchFilter filter);

}
