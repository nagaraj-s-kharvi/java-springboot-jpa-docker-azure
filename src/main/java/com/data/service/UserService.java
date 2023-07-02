package com.data.service;
import java.util.List;
import java.util.Optional;

import com.data.entity.User;

public interface UserService {
	
	User createUser(User userResource);
	
	User updateUser(Long id, User userResource);
	
	User getUserById(Long id);
	
	List<User> getAllUsers();
	
	Boolean deleteUser(Long id);
}
