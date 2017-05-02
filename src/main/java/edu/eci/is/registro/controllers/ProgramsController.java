package edu.eci.is.registro.controllers;

import edu.eci.is.registro.entities.Course;
import edu.eci.is.registro.entities.Line;
import edu.eci.is.registro.entities.Program;
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

    public boolean checkPrivileges(Integer toCheck){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        String toCast = ((GrantedAuthority)authorities.toArray()[0]).getAuthority();
        System.out.println("La autoridad del usuario logueado es "+toCast);
        if(Integer.parseInt(toCast)>=toCheck)return true;
        return false;
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
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postProgram(@RequestBody Program program){
        if(checkPrivileges(4)){
            programServices.saveProgram(program);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(path = "/{programName}",method = RequestMethod.POST)
    public ResponseEntity<?> postLineIntoProgram(@PathVariable String programName, @RequestBody Line line){
        if(checkPrivileges(3)){
            programServices.saveLineIntoProgram(programName, line);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(path = "/{program}/{line}")
    public ResponseEntity<?> postCourseIntoLineIntoProgram(@PathVariable String program, @PathVariable String line, Course course){
        if (checkPrivileges(2)) {
            programServices.saveCourseIntoLineIntoProgram(program,line,course);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
