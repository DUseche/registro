package edu.eci.is.registro.entities;

/**
 * Created by David Useche on 28/04/2017.
 */
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERSONS")
public class Person implements Serializable{

    private String mail;
    private String password;
    private String authority;
    private String program;
    private String line;

    protected Person(){}

    public Person(String mail, String password, String authority) {
        this.mail = mail;
        this.password = password;
        this.authority = authority;
    }

    @Id
    @Column(name = "mail", nullable = false)
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column(name = "pass", nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "authority", nullable = false)
    public String getAuthority() { return authority; }
    public void setAuthority(String authority) { this.authority = authority; }

    @Column(name = "program")
    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Column(name = "line")
    public String getLine() {
        return line;
    }

    public void setLine(String line) {
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
