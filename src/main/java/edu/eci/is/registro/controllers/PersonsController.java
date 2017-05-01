package edu.eci.is.registro.controllers;


import edu.eci.is.registro.entities.Person;
import edu.eci.is.registro.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Juan Pablo on 18/02/2017.
 */
@RestController
@RequestMapping("/user")
public class PersonsController {

    @Autowired
    PersonServices personsServices;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(path = "/registrer", method = RequestMethod.POST)
    public ResponseEntity<?> registrerUser(@RequestBody Person user) {
        user.setPassword(bCryptPasswordEncoder().encode(user.getPassword()));
        personsServices.save(user);
        Person newUser = user;

        return new ResponseEntity<>(newUser, HttpStatus.ACCEPTED);
    }

}
