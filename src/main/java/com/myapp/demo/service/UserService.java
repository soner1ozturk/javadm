package com.myapp.demo.service;

import com.myapp.demo.model.User;
import com.myapp.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User create(String name, String email) {
        User user = new User(name, email);
        return userRepository.save(user);
    }

    public Optional<User> update(Long id, String name, String email) {
        return userRepository.findById(id)
                .map(existing -> {
                    existing.setName(name);
                    existing.setEmail(email);
                    return userRepository.save(existing);
                });
    }

    public boolean delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}