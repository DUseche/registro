package edu.eci.is.registro.services;

import edu.eci.is.registro.entities.Person;

import java.util.List;

/**
 * Created by David Useche on 28/04/2017.
 */
public interface PersonServices {
    void save(Person toSave);
    Person findByMail(String mail);
    void update(Person toUpdate);
    //List<Person> getAll();
}
