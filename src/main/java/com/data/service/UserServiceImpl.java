package com.data.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entity.User;
import com.data.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserRepository userRepository;

    public User createUser(User userResource) {
        User user = userRepository.save(userResource);
        return user;
    }

    public User updateUser(Long id, User userResource) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(userResource.getUsername());
            user.setPassword(userResource.getPassword());
            user.setEmail(userResource.getEmail());
            user.setDob(userResource.getDob());
            user.setUpdatedBy(userResource.getUpdatedBy());
            user.setUpdatedTs(userResource.getUpdatedTs());
            return userRepository.save(user);
        } else {
            return null;
        }
    }
    
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User getUserById(Long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    public Boolean deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return true;
    }
}
