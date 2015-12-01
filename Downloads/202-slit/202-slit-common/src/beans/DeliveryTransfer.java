/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author lmgr
 */
public class DeliveryTransfer implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int DeliveryID;
    private int DeliveryStatus;
    private String feedback;
    private byte[] deliveryFile;
    private int UserID;
    private int ModuleID;
    private String FileName;
    
    public DeliveryTransfer(int DeliveryID, int DeliveryStatus,
            String feedback, byte[] deliveryFile, int UserID, int ModuleID, 
            String FileName) {
        this.DeliveryID = DeliveryID;
        this.DeliveryStatus = DeliveryStatus;
        this.feedback = feedback;
        this.deliveryFile = deliveryFile;
        this.UserID = UserID;
        this.ModuleID = ModuleID;
        this.FileName = FileName;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }
    
    public int getDeliveryID() {
        return DeliveryID;
    }

    public void setDeliveryID(int DeliveryID) {
        this.DeliveryID = DeliveryID;
    }

    public int getDeliveryStatus() {
        return DeliveryStatus;
    }

    public void setDeliveryStatus(int DeliveryStatus) {
        this.DeliveryStatus = DeliveryStatus;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public byte[] getDeliveryFile() {
        return deliveryFile;
    }

    public void setDeliveryFile(byte[] deliveryFile) {
        this.deliveryFile = deliveryFile;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getModuleID() {
        return ModuleID;
    }

    public void setModuleID(int ModuleID) {
        this.ModuleID = ModuleID;
    } 
    
}
