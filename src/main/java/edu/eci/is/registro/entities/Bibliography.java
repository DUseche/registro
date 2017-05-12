package edu.eci.is.registro.entities;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by David Useche on 30/04/2017.
 */
@Embeddable
public class Bibliography implements Serializable{

    private String principalText;
    private String otherTexts;

    public Bibliography(String principalText, String otherTexts) {
        this.principalText = principalText;
        this.otherTexts = otherTexts;
    }

    public Bibliography(String principalText) {
        this.principalText = principalText;
    }

    public Bibliography() {
    }

    @Column(name = "principalText")
    public String getPrincipalText() {
        return principalText;
    }

    public void setPrincipalText(String principalText) {
        this.principalText = principalText;
    }

    @Column(name = "otherTexts")
    public String getOtherTexts() {
        return otherTexts;
    }

    public void setOtherTexts(String otherTexts) {
        this.otherTexts = otherTexts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bibliography that = (Bibliography) o;

        if (!principalText.equals(that.principalText)) return false;
        return otherTexts != null ? otherTexts.equals(that.otherTexts) : that.otherTexts == null;
    }

    @Override
    public int hashCode() {
        int result = principalText.hashCode();
        result = 31 * result + (otherTexts != null ? otherTexts.hashCode() : 0);
        return result;
    }
}
