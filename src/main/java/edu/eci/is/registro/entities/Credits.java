package edu.eci.is.registro.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by David Useche on 30/04/2017.
 */
@Embeddable
public class Credits implements Serializable{

    private Integer magistral;
    private Integer independent;

    public Credits(Integer magistral, Integer independent) {
        this.magistral = magistral;
        this.independent = independent;
    }

    public Credits() {
    }

    @Column(name = "magistralCredits")
    public Integer getMagistral() {
        return magistral;
    }

    public void setMagistral(Integer magistral) {
        this.magistral = magistral;
    }

    @Column(name = "independentCredits")
    public Integer getIndependent() {
        return independent;
    }

    public void setIndependent(Integer independent) {
        this.independent = independent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Credits credits = (Credits) o;

        if (!magistral.equals(credits.magistral)) return false;
        return independent.equals(credits.independent);
    }

    @Override
    public int hashCode() {
        int result = magistral.hashCode();
        result = 31 * result + independent.hashCode();
        return result;
    }
}
