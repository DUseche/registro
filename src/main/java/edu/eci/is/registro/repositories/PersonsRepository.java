package edu.eci.is.registro.repositories;

import edu.eci.is.registro.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by David Useche on 28/04/2017.
 */
@Service
public interface PersonsRepository extends JpaRepository<Person,String>{
}
