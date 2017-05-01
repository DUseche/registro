package edu.eci.is.registro.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by David Useche on 30/04/2017.
 */
@Embeddable
public class Evaluation implements Serializable{

    private Float noteOnePercent;
    private Float noteTwoPercent;
    private Float noteThreePercent;
    private Float noteLabPercent;

    public Evaluation(Float noteOnePercent, Float noteTwoPercent, Float noteThreePercent, Float noteLabPercent) {
        this.noteOnePercent = noteOnePercent;
        this.noteTwoPercent = noteTwoPercent;
        this.noteThreePercent = noteThreePercent;
        this.noteLabPercent = noteLabPercent;
    }

    public Evaluation() {
    }

    @Column(name = "one")
    public Float getNoteOnePercent() {
        return noteOnePercent;
    }

    public void setNoteOnePercent(Float noteOnePercent) {
        this.noteOnePercent = noteOnePercent;
    }

    @Column(name = "two")
    public Float getNoteTwoPercent() {
        return noteTwoPercent;
    }

    public void setNoteTwoPercent(Float noteTwoPercent) {
        this.noteTwoPercent = noteTwoPercent;
    }

    @Column(name = "three")
    public Float getNoteThreePercent() {
        return noteThreePercent;
    }

    public void setNoteThreePercent(Float noteThreePercent) {
        this.noteThreePercent = noteThreePercent;
    }

    @Column(name = "lab")
    public Float getNoteLabPercent() {
        return noteLabPercent;
    }

    public void setNoteLabPercent(Float noteLabPercent) {
        this.noteLabPercent = noteLabPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Evaluation that = (Evaluation) o;

        if (!noteOnePercent.equals(that.noteOnePercent)) return false;
        if (!noteTwoPercent.equals(that.noteTwoPercent)) return false;
        if (!noteThreePercent.equals(that.noteThreePercent)) return false;
        return noteLabPercent.equals(that.noteLabPercent);
    }

    @Override
    public int hashCode() {
        int result = noteOnePercent.hashCode();
        result = 31 * result + noteTwoPercent.hashCode();
        result = 31 * result + noteThreePercent.hashCode();
        result = 31 * result + noteLabPercent.hashCode();
        return result;
    }
}
