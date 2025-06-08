package com.ssnce.taskapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void userService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        Optional<User> foundUser = userRepository.findByUserName(user.getUsername());
        if (foundUser.isPresent()) {
            throw new RuntimeException("User Already registered");
        }
        Long id = (long) (Math.random() * 100000);
        user.setId(id);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getAll();
    }
}
