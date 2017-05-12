package edu.eci.is.registro.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by David Useche on 30/04/2017.
 */
@Entity
@Table(name = "COURSES")
public class Course implements Serializable{

    private String objective;
    private String name;
    private String studyPlans;
    private String mnemonicCode;
    private Integer numericCode;
    private String justification;
    private String requisites;
    private String methodology;
    private Evaluation evaluation;
    private WeeklyIntensity weeklyIntensity;
    private Bibliography bibliography;
    private Credits credits;
    private PragmaticContent pragmaticContent;
    private Term term;

    public Course(String name) {
        this.name = name;
    }

    public Course(String objective, String name, String studyPlans, String mnemonicCode, Integer numericCode, String justification, String requisites, String methodology, Evaluation evaluation, WeeklyIntensity weeklyIntensity, Bibliography bibliography, Credits credits, PragmaticContent pragmaticContent, Term term) {
        this.objective = objective;
        this.name = name;
        this.studyPlans = studyPlans;
        this.mnemonicCode = mnemonicCode;
        this.numericCode = numericCode;
        this.justification = justification;
        this.requisites = requisites;
        this.methodology = methodology;
        this.evaluation = evaluation;
        this.weeklyIntensity = weeklyIntensity;
        this.bibliography = bibliography;
        this.credits = credits;
        this.pragmaticContent = pragmaticContent;
        this.term = term;
    }

    public Course() {
    }

    @Column(name = "requisites")
    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }
    @Column(name = "objective")
    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "studyPlans")
    public String getStudyPlans() {
        return studyPlans;
    }

    public void setStudyPlans(String studyPlans) {
        this.studyPlans = studyPlans;
    }

    @Column(name = "mnemonic")
    public String getMnemonicCode() {
        return mnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode;
    }

    @Column(name = "code")
    public Integer getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(Integer numericCode) {
        this.numericCode = numericCode;
    }

    @Column(name = "justification")
    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    @Column(name = "methodology")
    public String getMethodology() {
        return methodology;
    }

    public void setMethodology(String methodology) {
        this.methodology = methodology;
    }

    @Embedded
    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    @Embedded
    public WeeklyIntensity getWeeklyIntensity() {
        return weeklyIntensity;
    }

    public void setWeeklyIntensity(WeeklyIntensity weeklyIntensity) {
        this.weeklyIntensity = weeklyIntensity;
    }

    @Embedded
    public Bibliography getBibliography() {
        return bibliography;
    }

    public void setBibliography(Bibliography bibliography) {
        this.bibliography = bibliography;
    }

    @Embedded
    public Credits getCredits() {
        return credits;
    }

    public void setCredits(Credits credits) {
        this.credits = credits;
    }

    @Embedded
    public PragmaticContent getPragmaticContent() {
        return pragmaticContent;
    }

    public void setPragmaticContent(PragmaticContent pragmaticContent) {
        this.pragmaticContent = pragmaticContent;
    }

    @Embedded
    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return name.equals(course.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Course{" +
                "objective='" + objective + '\'' +
                ", name='" + name + '\'' +
                ", studyPlans=" + studyPlans +
                ", mnemonicCode='" + mnemonicCode + '\'' +
                ", numericCode=" + numericCode +
                ", justification='" + justification + '\'' +
                ", requisites=" + requisites +
                ", methodology=" + methodology +
                ", evaluation=" + evaluation +
                ", weeklyIntensity=" + weeklyIntensity +
                ", bibliography=" + bibliography +
                ", credits=" + credits +
                ", pragmaticContent=" + pragmaticContent +
                ", term=" + term +
                '}';
    }
}
