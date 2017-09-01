package edu.eci.is.registro.security;

import edu.eci.is.registro.entities.Person;
import edu.eci.is.registro.services.IMailService;
import edu.eci.is.registro.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by David Useche on 26/08/2017.
 */
@Service
public class OutlookAuthenticator implements AuthenticationProvider {

    @Autowired
    IMailService mailService;

    @Autowired
    PersonServices personsServices;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            String mail = authentication.getName();
            String password = authentication.getCredentials().toString();
            if(mailService.check(mail,password)){
                ArrayList<GrantedAuthority> authorities = new ArrayList<>();
                Person person = personsServices.findByMail(mail);
                authorities.add(new SimpleGrantedAuthority(person.getAuthority()));
                //authorities.add(new SimpleGrantedAuthority("4"));
                return new UsernamePasswordAuthenticationToken(mail,password,authorities);
            }else{
                System.out.println("El error está en Outlook");
                throw new BadCredentialsException("Error in authentication");
            }

        }catch (Exception ex){
            //ex.printStackTrace();
            throw new BadCredentialsException("Error in authentication");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}
