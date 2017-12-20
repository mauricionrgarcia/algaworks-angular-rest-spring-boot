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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.algaworks.algamoneyapi.model.Launch;
import com.algaworks.algamoneyapi.repository.filter.LaunchFilter;
import com.algaworks.algamoneyapi.repository.projection.SimpleLaunch;

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
	public Page<Launch> searchByFilter(LaunchFilter filter, Pageable page) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Launch> criteria = builder.createQuery(Launch.class);
		Root<Launch> root = criteria.from(Launch.class);

		Predicate[] predicates = createPredicate(filter, builder, root);
		// criar restrições
		criteria.where(predicates);

		TypedQuery<Launch> query = manager.createQuery(criteria);
		pageableQuery(query, page);

		List<Launch> listReturn = query.getResultList();

		return new PageImpl<>(listReturn, page, countByFilter(filter));
	}

	@Override
	public Page<SimpleLaunch> searchSimpeLaunchByFilter(LaunchFilter filter, Pageable page) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<SimpleLaunch> criteria = builder.createQuery(SimpleLaunch.class);

		Root<Launch>root = criteria.from(Launch.class);
		criteria.select(builder.construct(SimpleLaunch.class,
				 root.get("code"),
				 root.get("description"),
				 root.get("dtDue"),
				 root.get("dtPayment"),
				 root.get("totalAmount"),
				 root.get("type"),
				 root.get("category").get("name"),
				 root.get("person").get("name")
				));
		Predicate[] predicates = createPredicate(filter, builder, root);
		// criar restrições
		criteria.where(predicates);

		TypedQuery<SimpleLaunch> query = manager.createQuery(criteria);
		pageableQuery(query, page);

		List<SimpleLaunch> listReturn = query.getResultList();

		return new PageImpl<>(listReturn, page, countByFilter(filter));	
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

	/**
	 * Adiciona a paginação na consulta
	 *
	 * @param query
	 * @param page
	 */
	private void pageableQuery(TypedQuery<?> query, Pageable pageable) {
		int page = pageable.getPageNumber();
		int size = pageable.getPageSize();
		int first = page * size;

		query.setFirstResult(first);
		query.setMaxResults(size);

	}

	/**
	 * Retorna total de registros
	 *
	 * @param filter
	 * @return total de registros
	 */
	private Long countByFilter(LaunchFilter filter) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Launch> root = criteria.from(Launch.class);

		Predicate[] predicates = createPredicate(filter, builder, root);
		// criar restrições
		criteria.where(predicates);

		criteria.select(builder.count(root));

		return manager.createQuery(criteria).getSingleResult();
	}

}
