/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author lmgr
 */
@Entity
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DeliveryID")
    private int DeliveryID;
    @Column(name="DeliveryStatus")
    private int DeliveryStatus;
    
    private String Feedback;
    private byte[] DeliveryFile;
    private int UserID;
    private int ModuleID;
    @Column(name="DeliveryFileName")
    private String FileName;

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
        return Feedback;
    }

    public void setFeedback(String Feedback) {
        this.Feedback = Feedback;
    }

    public byte[] getDeliveryFile() {
        return DeliveryFile;
    }

    public void setDeliveryFile(byte[] DeliveryFile) {
        this.DeliveryFile = DeliveryFile;
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
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.DeliveryID;
        hash = 97 * hash + this.DeliveryStatus;
        hash = 97 * hash + Objects.hashCode(this.Feedback);
        hash = 97 * hash + Arrays.hashCode(this.DeliveryFile);
        hash = 97 * hash + this.UserID;
        hash = 97 * hash + this.ModuleID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Delivery other = (Delivery) obj;
        if (this.DeliveryID != other.DeliveryID) {
            return false;
        }
        if (this.DeliveryStatus != other.DeliveryStatus) {
            return false;
        }
        if (this.UserID != other.UserID) {
            return false;
        }
        if (this.ModuleID != other.ModuleID) {
            return false;
        }
        if (!Objects.equals(this.Feedback, other.Feedback)) {
            return false;
        }
        if (!Arrays.equals(this.DeliveryFile, other.DeliveryFile)) {
            return false;
        }
        return true;
    }

    
    

    @Override
    public String toString() {
        return "entities.Delivery[ id=" + DeliveryID + " ]";
    }
    
}
