/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.jpa;

import dhbwka.wwi.jpa.Benutzer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author DEETMUMI
 */
@Entity
public class Bild implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String beschreibung ="";
    private byte[] bild = null;
    
    public Bild(){
        
    }
    
    public Bild(String beschreibung, byte[] bild){
        this.beschreibung = beschreibung;
        this.bild = bild;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public byte[] getBild() {
        return bild;
    }

    public void setBild(byte[] bild) {
        this.bild = bild;
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
        if (!(object instanceof Bild)) {
            return false;
        }
        Bild other = (Bild) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dhbwka.wwi.web.Bild[ id=" + id + " ]";
    }
    /*    /*
    @ManyToOne
    Benutzer benutzer = new Benutzer();
    @OneToMany
    (mappedBy="Bild")
    List<Stern> stern =new ArrayList<>();
    @OneToMany
    (mappedBy="Bild")
    List<Superlike> superLike =new ArrayList<>();
    @OneToMany
    (mappedBy="Bild")
    List<Kommentar> kommentar =new ArrayList<>();*/
}
