package io.fam.sqlsecure;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User findUserByEmail(String email) {
	    return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(UserDto userDto) {
	    Role role = roleRepository.findByName(TbConstants.Roles.USER);

	    if (role == null) {
		role = roleRepository.save(new Role(TbConstants.Roles.USER));
	    }

	    User user = new User(
				 userDto.getName(),
				 userDto.getEmail(),
				 passwordEncoder.encode(userDto.getPassword()),
				 Arrays.asList(role)
				 );
	    userRepository.save(user);

	}

}
