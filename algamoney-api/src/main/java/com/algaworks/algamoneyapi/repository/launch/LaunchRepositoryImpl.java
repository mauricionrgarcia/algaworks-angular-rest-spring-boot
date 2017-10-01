package com.algaworks.algamoneyapi.repository.launch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.algamoneyapi.model.Launch;
import com.algaworks.algamoneyapi.repository.filter.LaunchFilter;

/**
 * Implementação do respository {@link LaunchRepositoryQuery}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 23/09/2017 14:37:28
 */
public class LaunchRepositoryImpl implements LaunchRepositoryQuery {

	/**
	 * {@link EntityManager}
	 */
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Launch> searchByFilter(LaunchFilter filter) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Launch> criteria = builder.createQuery(Launch.class);
		Root<Launch> root = criteria.from(Launch.class);

		Predicate[] predicates = createPredicate(filter, builder, root);
		// criar restrições
		criteria.where(predicates);

		TypedQuery<Launch> query = manager.createQuery(criteria);
		return query.getResultList();

	}

	/**
	 * Prepara as restrições
	 *
	 * @param filter
	 * @param builder
	 * @param root
	 * @return Predicate
	 */
	private Predicate[] createPredicate(LaunchFilter filter, CriteriaBuilder builder, Root<Launch> root) {

		List<Predicate> preditates = new ArrayList<>();
		if (!StringUtils.isEmpty(filter.getDescription())) {
			preditates.add(builder.like(builder.lower(root.get("description")),
					"%" + filter.getDescription().toLowerCase() + "%"));
		}
		if (filter.getEndDtDue() != null) {
			preditates.add(builder.lessThanOrEqualTo(root.get("dtDue"), filter.getEndDtDue()));
		}

		if (filter.getStartDtDue() != null) {
			preditates.add(builder.greaterThanOrEqualTo(root.get("dtDue"), filter.getStartDtDue()));
		}

		return preditates.toArray(new Predicate[preditates.size()]);
	}

}
