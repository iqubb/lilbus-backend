package com.qubb.lilbus.repository;

import com.qubb.lilbus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository
        extends JpaRepository<User, Integer> {

    User findUserByPhoneNumber(String phoneNumber);
    User findUserById(Long id);
    void deleteUserById(Long id);
}
