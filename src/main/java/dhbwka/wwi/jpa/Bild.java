/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.jpa;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    @GeneratedValue
    private long id = 0;

    private String beschreibung ="";
    private byte[] bild = null;
    private String timestamp;
    
    public Bild(){
        
    }
    
    public Bild(String beschreibung, byte[] bild){
        this.beschreibung = beschreibung;
        this.bild = bild;
        LocalDateTime zeit = LocalDateTime.now();
        DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 

        timestamp = zeit.format(newFormat);
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
    public String getTimestamp(){
        return timestamp;
    }
    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
    }
   

    @Override
    public String toString() {
        return "dhbwka.wwi.web.Bild[ id=" + id + " ]";
    }
    

    
    @OneToMany
    (mappedBy="bild")
    List<Stern> stern =new ArrayList<>();
    
    @OneToMany
    (mappedBy="bild")
    List<Superlike> superLike =new ArrayList<>();
    
    @OneToMany
    (mappedBy="bild")
    List<Kommentar> kommentar =new ArrayList<>();
}
