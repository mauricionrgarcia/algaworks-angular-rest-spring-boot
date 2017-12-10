package com.algaworks.algamoneyapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algamoneyapi.model.User;

/**
 * Repositorio que atende a entidade {@link User}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 10/12/2017 17:25:53
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * @param email e-mail
	 * @return {@link User}
	 */
	Optional<User> findByEmail(String email);

}
