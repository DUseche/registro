package edu.eci.is.registro.controllers;

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

import java.time.Clock;
import java.util.Arrays;
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
        if(checkPrivileges(4))return ResponseEntity.ok().body(programServices.getAll());
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Program> getProgramByName(@PathVariable String name){
        try{
            Program returned = programServices.getByName(name);
            if(returned==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.ok().body(returned);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/{program}/{line}", method = RequestMethod.GET)
    public ResponseEntity<Line> getLineByNameAndProgram(@PathVariable String program, @PathVariable String line){
        try{
            Line returned = programServices.getByName(program).getLineByName(line);
            if(returned==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.ok().body(returned);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postProgram(@RequestBody Program program){
        programServices.saveProgram(program);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
