package edu.eci.is.registro.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Useche on 30/04/2017.
 */
@Entity
@Table(name = "PROGRAM_LINES")
public class Line implements Serializable{

    private String name;

    private List<Course> courses;

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
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
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
        if(courses.contains(new Course(courseName))){
            Course geted = courses.get(courses.indexOf(newCourse));
            geted.setBibliography(newCourse.getBibliography());
            geted.setCredits(newCourse.getCredits());
            geted.setEvaluation(newCourse.getEvaluation());
            geted.setJustification(newCourse.getJustification());
            geted.setMethodology(newCourse.getMethodology());
            geted.setMnemonicCode(newCourse.getMnemonicCode());
            geted.setNumericCode(newCourse.getNumericCode());
            geted.setObjective(newCourse.getObjective());
            geted.setPragmaticContent(newCourse.getPragmaticContent());
            geted.setRequisites(newCourse.getRequisites());
            geted.setStudyPlans(newCourse.getStudyPlans());
            geted.setTerm(newCourse.getTerm());
            geted.setWeeklyIntensity(newCourse.getWeeklyIntensity());
        }
    }
}
