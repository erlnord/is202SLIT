/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Notification;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Erlend
 */
@Stateless
public class NotificationBean implements NotificationBeanRemote {
@PersistenceContext
    EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addNotification(String Message, int UserID) {
        Notification n = new Notification(); 
        n.setMessage(Message);
        n.setUserID(UserID);
        em.persist(n);
    }

    @Override
    public NotificationTransfer viewNotification(int NotificationID) {
        Notification n = em.find(Notification.class, NotificationID);
        //if (null == n) {
          //  System.out.println("found nutting");
           // return null;
        
   // } else
    return new NotificationTransfer(n.getNotificationID(), n.getMessage(), n.getUserID());
    }
    
}
