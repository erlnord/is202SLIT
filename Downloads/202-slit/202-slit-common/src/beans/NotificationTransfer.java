/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Erlend
 */
public class NotificationTransfer {
     private static final long serialVersionUID = 1L;
     private int NotificationID;
     private String Message;
     private int UserID; 
     
      public NotificationTransfer(int NotificationID, String Message, int UserID) {
        this.NotificationID = NotificationID;
        this.Message = Message;
        this.UserID = UserID;
    }

    public int getNotificationID() {
        return NotificationID;
    }

    public void setNotificationID(int NotificationID) {
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

}
