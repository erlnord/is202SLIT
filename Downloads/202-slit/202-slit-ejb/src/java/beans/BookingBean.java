/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import entities.Booking;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Trygve Åse Lunde
 */
@Stateless(name="BookingBean")
public class BookingBean implements BookingBeanRemote {
    @PersistenceContext
    private EntityManager em;

     @Override
    public BookingTransfer findBooking(int BookingID) {
        Booking booking = em.find(Booking.class, BookingID);
    return new BookingTransfer (booking.getId(), 
                booking.getDag(), booking.getInfo(), 
                booking.getStudenter());
    }

    @Override
    public void addDag(int id, String Dag, String Info, String Studenter) {
        Booking dag = new Booking();
        dag.setId(id);
        dag.setDag(Dag);
        dag.setInfo(Info);
        dag.setStudenter(Studenter);
        em.merge(dag);
      
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

   
    
}
