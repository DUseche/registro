package edu.eci.is.registro.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by David Useche on 30/04/2017.
 */
@Entity
@Table(name = "PROGRAM_LINES")
public class Line implements Serializable{

    private String name;

    private Set<Course> courses;

    @Id
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROGRAM_LINES_name", referencedColumnName = "name")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Line(String name) {
        this.name = name;
    }

    public Line() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return name.equals(line.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public void addCourse(Course course){
        if(!courses.contains(course))courses.add(course);
    }

    public Course getCourseByName(String courseName){
        Course toSearch = new Course();
        toSearch.setName(courseName);
        if(courses.contains(toSearch)){
            ArrayList<Course> tmp = new ArrayList<>(courses);
            return tmp.get(tmp.indexOf(toSearch));
        }else return null;
    }

    public void updateCourse(String courseName, Course newCourse){
        courses.remove(new Course(courseName));
        courses.add(newCourse);
    }
}
