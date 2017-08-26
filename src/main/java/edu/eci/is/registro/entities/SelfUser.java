package edu.eci.is.registro.entities;

import java.io.Serializable;

/**
 * Created by David Useche on 24/08/2017.
 */
public class SelfUser implements Serializable{

    private String username;
    private String password;

    public SelfUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SelfUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SelfUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
