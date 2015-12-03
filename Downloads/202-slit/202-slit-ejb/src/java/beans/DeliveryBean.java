/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Delivery;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author lmgr
 */
@Stateless
public class DeliveryBean implements DeliveryBeanRemote {
    
    @PersistenceContext
    EntityManager em;
    
    @Override
    public void addDelivery(int DeliveryStatus, 
            String feedback, byte[] deliveryfile, int UserID, int ModuleID,
            String FileName) {
        Delivery delivery = new Delivery();
        delivery.setDeliveryStatus(DeliveryStatus);
        delivery.setFeedback(feedback);
        delivery.setDeliveryFile(deliveryfile);
        delivery.setUserID(UserID);
        delivery.setModuleID(ModuleID);
        delivery.setFileName(FileName);
        em.persist(delivery);
    }
    
    @Override
    public void updateModule(int DeliveryID, String feedback) {
        
        Delivery delivery = em.find(Delivery.class, DeliveryID);
        
        delivery.setFeedback(feedback);
        
        em.merge(delivery);
    }
    
    @Override
    public void setStatus(int DeliveryID, int DeliveryStatus) {
        Delivery delivery = em.find(Delivery.class, DeliveryID);
        
        delivery.setDeliveryStatus(DeliveryStatus);
    }
    
    
    @Override
    public List<DeliveryTransfer> findAllDeliveries() {
        TypedQuery<Delivery> q = em.createQuery("Select c from Delivery c", 
                Delivery.class);
        
        List<Delivery> result = q.getResultList();
        
        ArrayList<DeliveryTransfer> list = new ArrayList();
        for (Delivery u : result) {
            DeliveryTransfer ut = new DeliveryTransfer(u.getDeliveryID(), 
                    u.getDeliveryStatus(), u.getFeedback(), u.getDeliveryFile(), 
                    u.getUserID(), u.getModuleID(), u.getFileName());
            
            list.add(ut);
        }
        return list;
    }
    
    @Override
    public DeliveryTransfer findDelivery(int id) {
        Delivery delivery = em.find(Delivery.class,id);        
        return new DeliveryTransfer(delivery.getDeliveryID(), 
                delivery.getDeliveryStatus(), delivery.getFeedback(), 
                delivery.getDeliveryFile(), delivery.getUserID(), 
                delivery.getModuleID(), delivery.getFileName());
    }

    
}
