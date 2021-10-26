package com.qubb.lilbus.service.implementation;

import com.qubb.lilbus.model.User;
import com.qubb.lilbus.repository.UserRepository;
import com.qubb.lilbus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        System.out.println("New user: " + user.getPhoneNumber());
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public Collection<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean delete(Long id) {
        userRepository.deleteUserById(id);
        return Boolean.TRUE;
    }
}
