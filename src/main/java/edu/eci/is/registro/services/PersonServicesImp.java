package edu.eci.is.registro.services;

import edu.eci.is.registro.entities.Person;
import edu.eci.is.registro.repositories.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by David Useche on 28/04/2017.
 */
@Service
public class PersonServicesImp implements PersonServices {

    @Autowired
    PersonsRepository personsRepository;

    @Override
    public void save(Person toSave) {
        personsRepository.save(toSave);
    }

    @Override
    public Person findByMail(String mail) {
        return personsRepository.findOne(mail);
    }
}
