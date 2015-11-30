/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Delivery;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
            String feedback, byte[] deliveryfile, int UserID, int ModuleID) {
        Delivery deliver = new Delivery();
        deliver.setDeliveryStatus(DeliveryStatus);
        deliver.setFeedback(feedback);
        deliver.setDeliveryFile(deliveryfile);
        deliver.setUserID(UserID);
        deliver.setModuleID(ModuleID);
        em.persist(deliver);
    }
    
    @Override
    public DeliveryTransfer findDelivery(int id) {
        Delivery delivery = em.find(Delivery.class,id);        
        return new DeliveryTransfer(delivery.getDeliveryID(), 
                delivery.getDeliveryStatus(), delivery.getFeedback(), 
                delivery.getDeliveryFile(), delivery.getUserID(), 
                delivery.getModuleID());
    }
    
}
