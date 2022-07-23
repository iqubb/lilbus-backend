package com.qubb.lilbus.services;

import com.qubb.lilbus.models.Person;
import com.qubb.lilbus.repositories.PeopleRepository;
import com.qubb.lilbus.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> personOptional = peopleRepository.findPersonByUsername(username);
        if(personOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return new PersonDetails(personOptional.get());
    }
}
