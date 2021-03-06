/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Notification;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Erlend
 */
@Stateless(name="NotificationBean")
public class NotificationBean implements NotificationBeanRemote {
@PersistenceContext
    EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addNotification(String Message, int UserID, Date NoteDate) {
        Notification n = new Notification(); 
        n.setMessage(Message);
        n.setUserID(UserID);
        n.setNoteDate(NoteDate);
        em.persist(n);
    }

    @Override
    public NotificationTransfer viewNotification(int NotificationID) {
        Notification n = em.find(Notification.class, NotificationID);
        //if (null == n) {
          //  System.out.println("found nothing");
           // return null;
        
   // } else
    return new NotificationTransfer(n.getNotificationID(), n.getMessage(), n.getUserID(), n.getNoteDate());
    }
    
    @Override
    public List<NotificationTransfer> findAllNotifications() {
        TypedQuery<Notification> q = em.createQuery("Select c from Notification c ORDER BY c.NotificationID DESC", Notification.class);
        
        List<Notification> result = q.getResultList();
        
        ArrayList<NotificationTransfer> list = new ArrayList();
        for (Notification n : result) {
           NotificationTransfer nt = new NotificationTransfer(n.getNotificationID(), n.getMessage(), n.getUserID(), n.getNoteDate());
            
            list.add(nt);
        }
        
        return list;
    }
}
