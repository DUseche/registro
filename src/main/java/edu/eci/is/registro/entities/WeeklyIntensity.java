package edu.eci.is.registro.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by David Useche on 30/04/2017.
 */
@Embeddable
public class WeeklyIntensity implements Serializable{

    private String magistral;
    private String monitor;
    private String lab;

    public WeeklyIntensity(String magistral, String monitor, String lab) {
        this.magistral = magistral;
        this.monitor = monitor;
        this.lab = lab;
    }

    public WeeklyIntensity() {
    }

    @Column(name = "magistralIntensity")
    public String getMagistral() {
        return magistral;
    }

    public void setMagistral(String magistral) {
        this.magistral = magistral;
    }

    @Column(name = "monitorIntensity")
    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    @Column(name = "labIntensity")
    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeeklyIntensity that = (WeeklyIntensity) o;

        if (!magistral.equals(that.magistral)) return false;
        if (!monitor.equals(that.monitor)) return false;
        return lab.equals(that.lab);
    }

    @Override
    public int hashCode() {
        int result = magistral.hashCode();
        result = 31 * result + monitor.hashCode();
        result = 31 * result + lab.hashCode();
        return result;
    }
}
