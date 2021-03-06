package edu.eci.is.registro.entities;

/**
 * Created by David Useche on 28/04/2017.
 */
import org.owasp.esapi.ESAPI;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERSONS_AUTH")
public class Person implements Serializable{

    private String mail;
    //private String password;
    private String authority;
    private String program;
    private String line;

    protected Person(){}

    public Person(String mail/*, String password*/, String authority) {
        if(ESAPI.validator().isValidInput("Set email",mail, "Email", 500, false)) this.mail = mail;
        //this.password = password;
        if(ESAPI.validator().isValidNumber("Set auth",authority,2,4,false))this.authority = authority;
    }

    public Person(String mail/*, String password*/, String authority, String program, String line) {
        if(ESAPI.validator().isValidInput("Set email",mail, "Email", 500, false))this.mail = mail;
        //this.password = password;
        if(ESAPI.validator().isValidNumber("Set auth",authority,2,4,false))this.authority = authority;
        if(ESAPI.validator().isValidInput("Set program",program, "SafeString", 500, true))this.program = program;
        if(ESAPI.validator().isValidInput("Set line",line, "SafeString", 500, true))this.line = line;
    }

    @Id
    @Column(name = "mail", nullable = false)
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        if(ESAPI.validator().isValidInput("Set email",mail, "Email", 500, false))
            this.mail = mail;
    }

    /*@Column(name = "pass", nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }*/

    @Column(name = "authority", nullable = false)
    public String getAuthority() { return authority; }
    public void setAuthority(String authority) {
        if(ESAPI.validator().isValidNumber("Set auth",authority,2,4,false))
            this.authority = authority;
    }

    @Column(name = "program")
    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        if(ESAPI.validator().isValidInput("Set program",program, "SafeString", 500, true))
            this.program = program;
    }

    @Column(name = "line")
    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        if(ESAPI.validator().isValidInput("Set line",line, "SafeString", 500, true))
            this.line = line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return mail.equals(person.mail);
    }

    @Override
    public int hashCode() {
        return mail.hashCode();
    }
}
