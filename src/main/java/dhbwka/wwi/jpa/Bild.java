/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.jpa;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author DEETMUMI
 */

//Bild-Objekt in der Datenbank
@Entity
public class Bild implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id = 0;
    //Die Beschreibund welche der User setzen kann
    private String beschreibung ="";
    //Das Bild in byte[] abgespeichert
    private byte[] bild = null;
    //ein Timestamp, der anzeigt, wann das Bild in die Datenbank hochgeladen wurde
    //Wird verwendet, um die neusten Bilder zuerst anzuzeigen
    private Timestamp zeitstempel;
    //Genaue Durchschnittsbewertung für das Bild mit allen Nachkommastellen
    private double durchschnittsbewertung;
    //Gerundete Durchschnittsbewertung für das Bild mit 2 Nachkommastellen
    private double bewertunggerundet;
    //Wie viele Bewertungen bereits für das Bild abgegeben wurden
    private int anzahlbewertungen = 0;
 
    public Bild(){
        
    }
    //Konstruktor
    public Bild(String beschreibung, byte[] bild,User user){
        this.anzahlbewertungen = 0;
        this.durchschnittsbewertung = 0;
        this.bewertunggerundet = 0;
        this.beschreibung = beschreibung;
        this.bild = bild;
        this.user = user;
        //setzen des Zeitstempels
        java.util.Date date= new java.util.Date(); 
        long time = date.getTime();
        zeitstempel = new Timestamp(time);
    }
    //Getter und Setter
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

    public int getAnzahlbewertungen() {
        return anzahlbewertungen;
    }

    public void setAnzahlbewertungen(int anzahlbewertungen) {
        this.anzahlbewertungen = anzahlbewertungen;
    }

    public Timestamp getZeitstempel() {
        return zeitstempel;
    }

    public void setZeitstempel(Timestamp zeitstempel) {
        this.zeitstempel = zeitstempel;
    }
        

    public double getDurchschnittsbewertung() {
        return durchschnittsbewertung;
    }

    public void setDurchschnittsbewertung(double durchschnittsbewertung) {
        this.durchschnittsbewertung = durchschnittsbewertung;
    }

    public double getBewertunggerundet() {
        return bewertunggerundet;
    }

    public void setBewertunggerundet(double bewertunggerundet) {
        this.bewertunggerundet = bewertunggerundet;
    }
    
    
    
    

    public List<Kommentar> getKommentar() {
        return kommentar;
    }

    public void setKommentar(List<Kommentar> kommentar) {
        this.kommentar = kommentar;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Stern> getStern() {
        return stern;
    }

    public void setStern(List<Stern> stern) {
        this.stern = stern;
    }
    
    
    
   

    @Override
    public String toString() {
        return "dhbwka.wwi.web.Bild[ id=" + id + " ]";
    }
    
    //Fremdbeziehungen
    //Mehrere Bilder können einen User haben, aber ein Bild kann nicht mehrere User haben
    @ManyToOne
    User user = null;
    //Ein Bild kann mehrere Bewertungen haben
    @OneToMany
    (mappedBy="bild", fetch = FetchType.EAGER)
    List<Stern> stern =new ArrayList<>();
    //Ein Bild kann mehrere Kommentare haben
    @OneToMany
    (mappedBy="bild", fetch = FetchType.EAGER)
    List<Kommentar> kommentar =new ArrayList<>();

    
}
