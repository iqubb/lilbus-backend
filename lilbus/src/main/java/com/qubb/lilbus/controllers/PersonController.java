package com.qubb.lilbus.controllers;

import com.qubb.lilbus.dto.PersonDTO;
import com.qubb.lilbus.models.Person;
import com.qubb.lilbus.services.PersonService;
import com.qubb.lilbus.util.PersonErrorResponse;
import com.qubb.lilbus.util.PersonNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private final PersonService personService;
    private final ModelMapper modelMapper;

    @Autowired
    public PersonController(PersonService personService, ModelMapper modelMapper) {
        this.personService = personService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }


    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException exception) {
        PersonErrorResponse response = new PersonErrorResponse("Person with id not found");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    private Person convertToPerson(PersonDTO personDTO) {
        return modelMapper.map(personDTO, Person.class);
    }
}
