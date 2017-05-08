package edu.eci.is.registro.services;

import edu.eci.is.registro.entities.Course;
import edu.eci.is.registro.entities.Line;
import edu.eci.is.registro.entities.Program;

import java.util.List;

/**
 * Created by David Useche on 30/04/2017.
 */
public interface ProgramServices{

    Program getByName(String name);

    List<Program> getAll();

    void saveProgram(Program program);

    void saveLineIntoProgram(String programName, Line toAdd);

    void saveCourseIntoLineIntoProgram(String programName, String lineName, Course toAdd);

    void updateCourse(String programName, String lineName, String courseName, Course toUpdate);

    void updateProgram(String programName, String toUpdate);

    void updateLine(String programName, String lineName, String newLine);
}
