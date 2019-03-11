/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author DEETMUMI
 */
@Entity
public class Benutzer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    private String email = "";
    private String passwort = "";
    private String art = "";
    private double score = 0;
    private String name = "";
    
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
        if (!(object instanceof Benutzer)) {
            return false;
        }
        Benutzer other = (Benutzer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dhbwka.wwi.web.Benutzer[ id=" + id + " ]";
    }
    @OneToMany
    (mappedBy="Benutzer")
    List<Bild> bild =new ArrayList<>();
    @OneToMany
    (mappedBy="Benutzer")
    List<Stern> stern =new ArrayList<>();
    @OneToMany
    (mappedBy="Benutzer")
    List<Superlike> superLike =new ArrayList<>();
    @OneToMany
    (mappedBy="Benutzer")
    List<Kommentar> kommentar =new ArrayList<>();
}
