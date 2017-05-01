package edu.eci.is.registro.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by David Useche on 30/04/2017.
 */
@Embeddable
public class Term implements Serializable{

    private Boolean approved;
    private Date validFrom;
    private Date validTo;
    private Date lastModified;
    private Date preLastModified;

    public Term(Boolean approved, Date validFrom, Date validTo, Date lastModified, Date preLastModified) {
        this.approved = approved;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.lastModified = lastModified;
        this.preLastModified = preLastModified;
    }

    public Term() {
    }

    @Column(name = "approved")
    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    @Column(name = "validFrom")
    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    @Column(name = "validTo")
    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    @Column(name = "lastMod")
    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Column(name = "preLastMod")
    public Date getPreLastModified() {
        return preLastModified;
    }

    public void setPreLastModified(Date preLastModified) {
        this.preLastModified = preLastModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Term term = (Term) o;

        if (!approved.equals(term.approved)) return false;
        if (!validFrom.equals(term.validFrom)) return false;
        if (!validTo.equals(term.validTo)) return false;
        if (!lastModified.equals(term.lastModified)) return false;
        return preLastModified.equals(term.preLastModified);
    }

    @Override
    public int hashCode() {
        int result = approved.hashCode();
        result = 31 * result + validFrom.hashCode();
        result = 31 * result + validTo.hashCode();
        result = 31 * result + lastModified.hashCode();
        result = 31 * result + preLastModified.hashCode();
        return result;
    }
}
