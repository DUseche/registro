package edu.eci.is.registro.services;

import edu.eci.is.registro.entities.Course;
import edu.eci.is.registro.entities.Line;
import edu.eci.is.registro.entities.Program;
import edu.eci.is.registro.repositories.ProgramsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by David Useche on 30/04/2017.
 */
@Service
public class ProgramServicesImp implements ProgramServices{

    @Autowired
    private ProgramsRepository programsRepository;

    @Override
    public Program getByName(String name) {
        return programsRepository.findOne(name);
    }

    @Override
    public List<Program> getAll() {
        return programsRepository.findAll();
    }

    @Override
    public void saveProgram(Program program) {
        programsRepository.save(program);
    }

    @Override
    public void saveLineIntoProgram(String programName, Line toAdd) {
        Program obtained = getByName(programName);
        obtained.addLine(toAdd);
        programsRepository.delete(programName);
        programsRepository.save(obtained);
    }

    @Override
    public void saveCourseIntoLineIntoProgram(String programName, String lineName, Course toAdd) {
        Program obtained = getByName(programName);
        obtained.getLineByName(lineName).addCourse(toAdd);
        programsRepository.delete(programName);
        programsRepository.save(obtained);
    }

}
