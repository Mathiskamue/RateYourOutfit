/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.jpa;

import dhbwka.wwi.jpa.Bild;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    
    private double sterne = 0;

    public Stern(double bewertung, Bild bild,User user) {
        this.sterne = bewertung;
        this.bild = bild;
        this.user = user;
    }

    public double getSterne() {
        return sterne;
    }

    public void setSterne(double sterne) {
        this.sterne = sterne;
    }

    public Stern() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bild getBild() {
        return bild;
    }

    public void setBild(Bild bild) {
        this.bild = bild;
    }
    

    @Override
    public String toString() {
        return "dhbwka.wwi.web.Stern[ id=" + id + " ]";
    }
    @ManyToOne
    User user =null;

    @ManyToOne
    Bild bild = null;

    
}
