/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Erlend
 */
public class NotificationTransfer implements Serializable{
     private static final long serialVersionUID = 1L;
     private int NotificationID;
     private String Message;
     private int UserID; 
     private Date NoteDate;
     
      public NotificationTransfer(int NotificationID, String Message, int UserID, Date NoteDate) {
        this.NotificationID = NotificationID;
        this.Message = Message;
        this.UserID = UserID;
        this.NoteDate = NoteDate;
    }

    public Date getNoteDate() {
        return NoteDate;
    }

    public void setNoteDate(Date NoteDate) {
        this.NoteDate = NoteDate;
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
