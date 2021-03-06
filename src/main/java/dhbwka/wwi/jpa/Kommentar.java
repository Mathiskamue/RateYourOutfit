/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.jpa;

import dhbwka.wwi.jpa.Bild;
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
    @GeneratedValue
    private long id = 0;

    private String text = "";

    public Kommentar() {

    }

    public Kommentar(String text,Bild bild, User user) {
        this.text = text;
        this.bild =bild;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    

    @Override
    public String toString() {
        return "dhbwka.wwi.web.Kommentar[ id=" + id + " ]";
    }


    @ManyToOne
    Bild bild = null;

    @ManyToOne
    User user = null;
    
}