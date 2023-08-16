package io.fam.sqlsecure;

public interface UserService {

	void saveUser(UserDto userDto);

	User findUserByEmail(String email);
    
}
