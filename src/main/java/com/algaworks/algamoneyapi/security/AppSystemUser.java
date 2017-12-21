package com.algaworks.algamoneyapi.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.algaworks.algamoneyapi.model.User;

/**
 * System user
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 20/12/2017 23:14:43
 */
public class AppSystemUser extends org.springframework.security.core.userdetails.User {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3344351231190088311L;

	private User user;

	public AppSystemUser(User user, Collection<? extends GrantedAuthority> authorities) {
		super(user.getEmail(), user.getPassword(), authorities);
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

}
