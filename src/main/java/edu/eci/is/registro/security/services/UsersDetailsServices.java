package edu.eci.is.registro.security.services;

import edu.eci.is.registro.entities.Person;
import edu.eci.is.registro.repositories.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by David Useche on 18/02/2017.
 */
@Service
public class UsersDetailsServices implements UserDetailsService {

    @Autowired
    private PersonsRepository personsRepository;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String mail) {
        Person newPerson = personsRepository.findOne(mail);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(newPerson.getAuthority()));

        return new User(newPerson.getMail()
                , /*newPerson.getPassword()*/"Algo"
                , grantedAuthorities);
    }
}