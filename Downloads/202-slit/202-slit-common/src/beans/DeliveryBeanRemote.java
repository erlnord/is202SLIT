/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author lmgr
 */
@Remote
public interface DeliveryBeanRemote {
    void addDelivery(int DeliveryStatus, String feedback, byte[] deliveryfile, 
            int UserID, int ModuleID, String FileName);
    
    DeliveryTransfer findDelivery(int id);
    
    List<DeliveryTransfer> findAllDeliveries();
    
    void updateModule(int DeliveryID, String feedback);

    void setStatus(int DeliveryID, int DeliveryStatus);
}
