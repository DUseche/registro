package edu.eci.is.registro.repositories;

import edu.eci.is.registro.entities.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by David Useche on 30/04/2017.
 */
@Service
public interface ProgramsRepository extends JpaRepository<Program,String>{
}
