/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.jpa;

import dhbwka.wwi.jpa.Bild;
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
import javax.persistence.TableGenerator;

/**
 *
 * @author DEETMUMI
 */
@Entity
public class Stern implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    /*@GeneratedValue(strategy = GenerationType.TABLE, generator = "stern_ids")
    @TableGenerator(name = "stern_ids", initialValue = 0, allocationSize = 50)*/
    private long id = 0;
    
    private int stern = 0;

    public Stern(int bewertung, Bild bild) {
        this.stern = bewertung;
        this.bild = bild;
    }

    public int getStern() {
        return stern;
    }

    public void setStern(int stern) {
        this.stern = stern;
    }

    public Stern() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "dhbwka.wwi.web.Stern[ id=" + id + " ]";
    }
    @ManyToOne
    Benutzer benutzer = null;

    @ManyToOne
    Bild bild = null;

    @OneToMany(mappedBy = "stern")
    List<Kommentar> comment = new ArrayList<>();
}
