/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.jpa;

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
    @GeneratedValue
    private long id = 0;

    private String email = "";
    private String passwort = "";
    private String art = "";
    private double score = 0;
    private String name = "";

    public Benutzer(){
        
    }
    public Benutzer(String email,String passwort,String art,double score,String name){
        this.email = email;
        this.passwort = passwort;
        this.art = art;
        this.score = score;
        this.name = name;
    }
 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "dhbwka.wwi.web.Benutzer[ id=" + id + " ]";
    }
    
    @OneToMany
    (mappedBy="benutzer")
    List<Bild> bild =new ArrayList<>();
    
    @OneToMany
    (mappedBy="benutzer")
    List<Stern> stern =new ArrayList<>();
    
    @OneToMany
    (mappedBy="benutzer")
    List<Superlike> superLike =new ArrayList<>();
    
    @OneToMany
    (mappedBy="benutzer")
    List<Kommentar> kommentar =new ArrayList<>();

}
