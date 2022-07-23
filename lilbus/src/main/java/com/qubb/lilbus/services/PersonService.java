package com.qubb.lilbus.services;

import com.qubb.lilbus.models.Person;
import com.qubb.lilbus.repositories.PeopleRepository;
import com.qubb.lilbus.util.PersonErrorResponse;
import com.qubb.lilbus.util.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {
    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PersonService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Person> getPersonOptional(String username) {
        return peopleRepository.findPersonByUsername(username);
    }

    public Person getPerson(Integer id) {
        Optional<Person> personOptional = peopleRepository.findById(id);
        return personOptional.orElseThrow(PersonNotFoundException::new);
    }


    @Transactional
    public void addNewPerson(Person person) {
        if(peopleRepository.findPersonByUsername(person.getUsername()).isPresent()) {
            //TODO exception
        }
        person.setCreatedAt(new Date());
        person.setRole("ROLE_USER");
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        peopleRepository.save(person);
    }
}
