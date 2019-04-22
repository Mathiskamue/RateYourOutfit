/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.ejb;

import dhbwka.wwi.jpa.Bild;
import dhbwka.wwi.jpa.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mathi
 */
//BildBean mit verschiedenen Funktionen zur Ausgabe von Daten aus der Datenbank
@Stateless
public class BildBean {
    @PersistenceContext
    EntityManager em;
    
    
    //Speichern eines neuen Eintrags in die Datenbank
    public Bild createNewBild2(byte[] picture,User user){
        Bild bild = new Bild("", picture,user);
        em.persist(bild);
        return em.merge(bild);
    }
    //Heraussuchen eines Bild-Objektes anhand der eindeutigen ID
    public Bild findBildById(long id) {
        return em.find(Bild.class, id);
    }
    
    //In Liste Herausgabe aller IDs der Bild-Objekte
    public List<Integer> findAllIds(){
        return em.createQuery("SELECT w.id FROM Bild w").getResultList();
    }
    
    //Da erst ein Bild hochgeladen wird, wird die Beschreibung erst durch diese Funktion später ergänzt
    public void setBeschreibung(String beschreibung, long id){
            Query query;
            query = em.createQuery("Update Bild w SET w.beschreibung = :beschreibung WHERE w.id = :id");
            query.setParameter("beschreibung", beschreibung);
            query.setParameter("id", id);
            query.executeUpdate();
    }
    
    //Alle Bild-Objekte der Datenbank herausgeben
    public List<Bild> findAllPictures() {
        return em.createQuery("Select w From Bild w WHERE w.beschreibung <> '' order by w.zeitstempel desc").getResultList();
        
    }
    
    //Der Benutzer kann sich umentscheiden, ein anderes Bild hochzuladen. In dieser Klasse wird nur das Bild geupdatet, nicht das restliche Objekt
    public void updateBild(byte[] bild, long id){
        Query query;
        query = em.createQuery("Update Bild w SET w.bild= :bild WHERE w.id = :id");
        query.setParameter("bild", bild);
        query.setParameter("id", id);
        query.executeUpdate();
    }
    //Hiermit wird die Bewertung der einzelnen Bilder errechnet und in der Datenbank gespeichert
    public void updateBewertung(Bild bild, double bewertung){
        int bewertungsanzahl = bild.getAnzahlbewertungen() + 1;
        double anzahlbewertungen = (double) bewertungsanzahl;
        double durchschnittsbewertung = (((bild.getDurchschnittsbewertung() * (anzahlbewertungen-1)) + bewertung)/anzahlbewertungen);
        double bewertunggerundet = round(durchschnittsbewertung, 2);
        Query query = em.createQuery("Update Bild w SET w.anzahlbewertungen = :bewertungsanzahl, w.durchschnittsbewertung = :durchschnittsbewertung, w.bewertunggerundet = :bewertunggerundet WHERE w.id = :id");
        query.setParameter("id", bild.getId());
        query.setParameter("bewertungsanzahl", bewertungsanzahl);
        query.setParameter("durchschnittsbewertung", durchschnittsbewertung);
        query.setParameter("bewertunggerundet", bewertunggerundet);
        query.executeUpdate();
        
    }
    //Hiermit wird die Bewertung eines Bildes neu berechnet, falls ein Nutzer, welcher bereits 
    //bewertet hatte, seine Bewertung verändern möchte
    public void updateBewertung2(Bild bild, double bewertung, double altezahl) {
        int bewertungsanzahl = bild.getAnzahlbewertungen();
        double anzahlbewertungen = (double) bewertungsanzahl;
        double durchschnittsbewertung = (((bild.getDurchschnittsbewertung() * (anzahlbewertungen)) - altezahl + bewertung)/anzahlbewertungen);
        double bewertunggerundet = round(durchschnittsbewertung, 2);
        Query query = em.createQuery("Update Bild w SET w.anzahlbewertungen = :bewertungsanzahl, w.durchschnittsbewertung = :durchschnittsbewertung, w.bewertunggerundet = :bewertunggerundet WHERE w.id = :id");
        query.setParameter("id", bild.getId());
        query.setParameter("bewertungsanzahl", bewertungsanzahl);
        query.setParameter("durchschnittsbewertung", durchschnittsbewertung);
        query.setParameter("bewertunggerundet", bewertunggerundet);
        query.executeUpdate();
    }
    
    //Funktion, mit der auf beliebige Nachkommastellen gerundet werden kann
    //In unserem Fall wird immer auf 2 Nachkommastellen bei Anwenden der Funktion gerundet
    private static double round(double value, int decimalPoints) {
      double d = Math.pow(10, decimalPoints);
      return Math.round(value * d) / d;
   }
    
    
    
    
}
