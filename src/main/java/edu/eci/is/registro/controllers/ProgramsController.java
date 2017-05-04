package edu.eci.is.registro.controllers;

import edu.eci.is.registro.entities.Course;
import edu.eci.is.registro.entities.Line;
import edu.eci.is.registro.entities.Person;
import edu.eci.is.registro.entities.Program;
import edu.eci.is.registro.services.PersonServices;
import edu.eci.is.registro.services.ProgramServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by David Useche on 30/04/2017.
 */
@RestController
@RequestMapping("/programs")
public class ProgramsController {

    @Autowired
    ProgramServices programServices;

    @Autowired
    PersonServices personServices;

    public boolean checkPrivileges(Integer toCheck){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        String toCast = ((GrantedAuthority)authorities.toArray()[0]).getAuthority();
        System.out.println("La autoridad del usuario logueado es "+toCast);
        if(Integer.parseInt(toCast)>=toCheck)return true;
        return false;
    }

    public boolean checkCareerAndLine(String program, String line){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String mail = auth.getName();
        Person holder = personServices.findByMail(mail);
        if(line == null){
            if(program == null){
                return true;
            }return holder.getProgram().equals(program);
        }return holder.getProgram().equals(program) && holder.getLine().equals(line);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Program>> getAllPrograms(){
        if(checkPrivileges(1))return ResponseEntity.ok().body(programServices.getAll());
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Program> getProgramByName(@PathVariable String name){
        if(checkPrivileges(1)){
            try{
                Program returned = programServices.getByName(name);
                if(returned==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                return ResponseEntity.ok().body(returned);
            }catch(Exception ex){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(path = "/{program}/{line}", method = RequestMethod.GET)
    public ResponseEntity<Line> getLineByNameAndProgram(@PathVariable String program, @PathVariable String line){
        if(checkPrivileges(1)){
            try{
                Line returned = programServices.getByName(program).getLineByName(line);
                if(returned==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                return ResponseEntity.ok().body(returned);
            }catch(Exception ex){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postProgram(@RequestBody Program program){
        if(checkPrivileges(4) && checkCareerAndLine(null ,null)){
            try{
                programServices.saveProgram(program);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }catch(Exception ex){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(path = "/{programName}",method = RequestMethod.POST)
    public ResponseEntity<?> postLineIntoProgram(@PathVariable String programName, @RequestBody Line line){
        if(checkPrivileges(3) && checkCareerAndLine(programName, null)){
            try{
                programServices.saveLineIntoProgram(programName, line);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }catch(Exception ex){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(path = "/{program}/{line}",method = RequestMethod.POST)
    public ResponseEntity<?> postCourseIntoLineIntoProgram(@PathVariable String program, @PathVariable String line, @RequestBody Course course){
        if (checkPrivileges(2) && checkCareerAndLine(program, line)) {
            try {
                programServices.saveCourseIntoLineIntoProgram(program,line,course);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }catch(Exception ex){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(path = "/{program}/{line}/{course}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCourse(@PathVariable String program, @PathVariable String line, @PathVariable String course, @RequestBody Course newCourse){
        if (checkPrivileges(2) && checkCareerAndLine(program, line)) {
            try {
                System.out.println(newCourse.toString());
                programServices.updateCourse(program,line,course,newCourse);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }catch(Exception ex){
                ex.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
