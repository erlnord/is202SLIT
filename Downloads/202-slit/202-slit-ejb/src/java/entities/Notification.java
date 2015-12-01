/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author erlnord
 */
@Entity
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="NotificationID")
    private int NotificationID;
    
    private String Message;
    private int UserID;

    public int getNotificationID() {
        return NotificationID;
    }

    public void setDeliveryID(int NotificationID) {
        this.NotificationID = NotificationID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.NotificationID;
        hash = 37 * hash + Objects.hashCode(this.Message);
        hash = 37 * hash + this.UserID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Notification other = (Notification) obj;
        if (this.NotificationID != other.NotificationID) {
            return false;
        }
        if (!Objects.equals(this.Message, other.Message)) {
            return false;
        }
        if (this.UserID != other.UserID) {
            return false;
        }
        return true;
    }
    


    @Override
    public String toString() {
        return "Notification{" + "NotificationID=" + NotificationID + ", Message=" + Message + ", UserID=" + UserID + '}';
    }

    
    
}
