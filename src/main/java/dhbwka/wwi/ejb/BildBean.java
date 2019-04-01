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
@Stateless
public class BildBean {
    @PersistenceContext
    EntityManager em;
    
    
    /**public Bild createNewBild(String beschreibung, byte[] picture){
        Bild bild = new Bild(beschreibung, picture);
        em.persist(bild);
        return em.merge(bild);
    }**/
    public Bild createNewBild2(byte[] picture,User user){
        Bild bild = new Bild("", picture,user);
        em.persist(bild);
        return em.merge(bild);
    }
    public List<Bild> findAllKommentare(){
        return em.createQuery("SELECT w FROM BILD w").getResultList();
    }
    
    public Bild findBildById(long id) {
        return em.find(Bild.class, id);
    }
    public List<Integer> findAllIds(){
        return em.createQuery("SELECT w.id FROM Bild w").getResultList();
    }
    public void setBeschreibung(String beschreibung, long id){
            Query query;
            query = em.createQuery("Update Bild w SET w.beschreibung = :beschreibung WHERE w.id = :id");
            query.setParameter("beschreibung", beschreibung);
            query.setParameter("id", id);
            query.executeUpdate();
    }

    public List<String> findAllDescriptions() {
        return em.createQuery("Select w.beschreibung From Bild w").getResultList();
    }

    public List<Bild> findAllPictures() {
        return em.createQuery("Select w From Bild w WHERE w.beschreibung <> ''").getResultList();
        
    }
    public void updateBild(byte[] bild, long id){
        Query query;
        query = em.createQuery("Update Bild w SET w.bild= :bild WHERE w.id = :id");
        query.setParameter("bild", bild);
        query.setParameter("id", id);
        query.executeUpdate();
    }
    public void updateBewertung(Bild bild, double bewertung){
        int bewertungsanzahl = bild.getAnzahlbewertungen() + 1;
        double anzahlbewertungen = (double) bewertungsanzahl;
        double durchschnittsbewertung = (((bild.getDurchschnittsbewertung() * (anzahlbewertungen-1)) + bewertung)/anzahlbewertungen);
        Query query = em.createQuery("Update Bild w SET w.anzahlbewertungen = :bewertungsanzahl, w.durchschnittsbewertung = :durchschnittsbewertung WHERE w.id = :id");
        query.setParameter("id", bild.getId());
        query.setParameter("bewertungsanzahl", bewertungsanzahl);
        query.setParameter("durchschnittsbewertung", durchschnittsbewertung);
        query.executeUpdate();
        
    }

    public void updateBewertung2(Bild bild, double bewertung, double altezahl) {
        int bewertungsanzahl = bild.getAnzahlbewertungen();
        double anzahlbewertungen = (double) bewertungsanzahl;
        double durchschnittsbewertung = (((bild.getDurchschnittsbewertung() * (anzahlbewertungen)) - altezahl + bewertung)/anzahlbewertungen);
        Query query = em.createQuery("Update Bild w SET w.anzahlbewertungen = :bewertungsanzahl, w.durchschnittsbewertung = :durchschnittsbewertung WHERE w.id = :id");
        query.setParameter("id", bild.getId());
        query.setParameter("bewertungsanzahl", bewertungsanzahl);
        query.setParameter("durchschnittsbewertung", durchschnittsbewertung);
        query.executeUpdate();
    }
    
    
    
    
}
