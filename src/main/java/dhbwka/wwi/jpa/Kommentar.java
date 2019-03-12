/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.jpa;

import dhbwka.wwi.jpa.Bild;
import dhbwka.wwi.jpa.Benutzer;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author DEETMUMI
 */
@Entity
public class Kommentar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text = "";
    private String h = "Hallo";
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kommentar)) {
            return false;
        }
        Kommentar other = (Kommentar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dhbwka.wwi.web.Kommentar[ id=" + id + " ]";
    }
    
    /* @ManyToOne
    Benutzer benutzer = new Benutzer();
    @ManyToOne
    Bild bild = new Bild();*/
}
