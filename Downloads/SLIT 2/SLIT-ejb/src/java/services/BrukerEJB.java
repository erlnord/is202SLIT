/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Erlend
 */
@Stateless
public class BrukerEJB implements BrukerEJBRemote {

    @PersistenceContext(unitName = "SLIT-ejbPU")
    private EntityManager em;
    

    protected EntityManager getEntityManager() {
        return em;  
    }
    
    public BrukerEJB() {
        
    }
    public void SjekkNavn() {
        
        try {
            Query q = em.createQuery("SELECT FirstName FROM User WHERE UserID = 1");
        System.out.println(q);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Life is rip");
        }
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
