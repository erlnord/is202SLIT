/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Remote;

/**
 *
 * @author lmgr
 */
@Remote
public interface DeliveryBeanRemote {
    void addDelivery(int DeliveryStatus, String feedback, byte[] deliveryfile, 
            int UserID, int ModuleID);
    
    DeliveryTransfer findDelivery(int id);
}
