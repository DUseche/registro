package edu.eci.is.registro.entities;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by David Useche on 30/04/2017.
 */
@Embeddable
public class PragmaticContent implements Serializable{

    private String summary;
    private String detailedThemes;

    public PragmaticContent(String summary, String detailedThemes) {
        this.summary = summary;
        this.detailedThemes = detailedThemes;
    }

    public PragmaticContent() {
    }

    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Column(name = "detailedThemes")
    public String getDetailedThemes() {
        return detailedThemes;
    }

    public void setDetailedThemes(String detailedThemes) {
        this.detailedThemes = detailedThemes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PragmaticContent that = (PragmaticContent) o;

        if (!summary.equals(that.summary)) return false;
        return detailedThemes.equals(that.detailedThemes);
    }

    @Override
    public int hashCode() {
        int result = summary.hashCode();
        result = 31 * result + detailedThemes.hashCode();
        return result;
    }
}
