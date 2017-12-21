package com.algaworks.algamoneyapi.security.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoneyapi.model.User;
import com.algaworks.algamoneyapi.repository.UserRepository;

/**
 * Inplmementation of {@link UserDetailsService}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 10/12/2017 17:32:31
 */
@Service
public class AppUserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private transient UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> optional = userRepository.findByEmail(email);
		User user = optional.orElseThrow(() -> new UsernameNotFoundException("username.not.found="));
		UserDetails securityUser = new AppSystemUser(user, getAuthorities(user));
		return securityUser;
	}

	/**
	 * prepara a lista de rules
	 *
	 * @param user
	 * @return
	 */
	private Collection<? extends GrantedAuthority> getAuthorities(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getPermissions()
				.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getDescription().toUpperCase())));
		return authorities;
	}

}
