/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.ejb;


import dhbwka.wwi.jpa.Stern;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thoma
 */
@Stateless
public class SternBean {
    
                            /*extends EntityBean<Stern, Long> {
        
        public SternBean() {
        super(Stern.class);
        }*/
    
    @PersistenceContext
    EntityManager em;
    
    public Stern saveStern (Stern stern){
        System.out.println(stern.getStern());
        em.persist(stern);
        return em.merge(stern);
    
    }

}
