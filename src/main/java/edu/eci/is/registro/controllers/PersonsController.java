package edu.eci.is.registro.controllers;


import edu.eci.is.registro.entities.Person;
import edu.eci.is.registro.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by David Useche on 18/02/2017.
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

    @RequestMapping(path = "/update/{mail}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable String mail, @RequestBody Person person) {
        Person getted = personsServices.findByMail(mail);
        getted.setAuthority(person.getAuthority());
        getted.setLine(person.getLine());
        getted.setProgram(person.getProgram());
        getted.setPassword(bCryptPasswordEncoder().encode(person.getPassword()));
        personsServices.update(getted);

        return new ResponseEntity<>(getted, HttpStatus.ACCEPTED);
    }

}
