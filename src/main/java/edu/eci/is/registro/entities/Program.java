package edu.eci.is.registro.entities;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.ValidationException;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Useche on 30/04/2017.
 */
@Entity
@Table(name = "PROGRAMS")
public class Program implements Serializable{

    private List<Line> lines;

    private String name;

    @Id
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name){
        if(ESAPI.validator().isValidInput("Set name", name, "SafeString", 100, false))this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROGRAMS_name", referencedColumnName = "name", nullable = false)
    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public Program(String name) {
        this.name = name;
    }

    public Program() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Program program = (Program) o;

        return name.equals(program.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public void addLine(Line line){
        if(!lines.contains(line))lines.add(line);
    }

    public Line getLineByName(String lineName){
        if(lines.contains(new Line(lineName))){
            return lines.get(lines.indexOf(new Line(lineName)));
        }else return null;
    }

    public void updateLine(String lineName, String newName){
        if(lines.contains(new Line((lineName)))){
            lines.get(lines.indexOf(new Line(lineName))).setName(newName);
        }
    }

    @Override
    public String toString() {
        return "Program{" +
                "lines=" + lines +
                ", name='" + name + '\'' +
                '}';
    }
}
