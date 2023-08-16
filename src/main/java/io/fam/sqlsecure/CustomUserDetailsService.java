package io.fam.sqlsecure;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
	    User user = userRepository.findByEmail(usernameOrEmail);
	    if (user != null) { // user found
		return new org
		    .springframework
		    .security
		    .core
		    .userdetails
		    .User(
			  user.getEmail(),
			  user.getPassword(),
			  user.getRoles().stream()
			  .map((role) -> new SimpleGrantedAuthority(role.getName()))
			  .collect(Collectors.toList()));
	    } else {
		throw new UsernameNotFoundException("Invalid email or password.");
	    }
	}

}
