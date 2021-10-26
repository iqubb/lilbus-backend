package com.qubb.lilbus.service;

import com.qubb.lilbus.model.User;
import org.springframework.stereotype.Service;
import java.util.Collection;


@Service
public interface UserService {

    User create(User user);
    User get(Long id);
    Collection<User> list();
    User update(User user);
    Boolean delete(Long id);
}
