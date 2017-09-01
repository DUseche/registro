package edu.eci.is.registro.services;

import edu.eci.is.registro.entities.Person;
import edu.eci.is.registro.repositories.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by David Useche on 28/04/2017.
 */
@Service
public class PersonServicesImp implements PersonServices {

    @Autowired
    PersonsRepository personsRepository;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public PersonServicesImp(){
        //Person admin = new Person("admin@escuelaing.edu.co",bCryptPasswordEncoder().encode("password"),"4");
        //Person program = new Person("program@escuelaing.edu.co",bCryptPasswordEncoder().encode("password"),"3", "Ingenieria de sistemas","Redes");
        //Person line = new Person("line@escuelaing.edu.co",bCryptPasswordEncoder().encode("password"),"2", "Ingenieria de sistemas","Redes");
        //Person user = new Person("user@escuelaing.edu.co",bCryptPasswordEncoder().encode("password"),"1", "Ingenieria de sistemas","Redes");
    }

    @Override
    public void save(Person toSave) {
        personsRepository.save(toSave);
    }

    @Override
    public Person findByMail(String mail) {
        return personsRepository.findOne(mail);
    }

    @Override
    public void update(Person toUpdate) {
        personsRepository.saveAndFlush(toUpdate);
    }

    /*@Override
    public List<Person> getAll() {
        return personsRepository.findAll();
    }*/

}
