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
 * @author larsmartin
 */
public class InformationTransfer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int id;
    private String InfoText;
    private int UserID;
    private Date InfoDate;
    
    public InformationTransfer (int id, String InfoText, int UserID, Date InfoDate) {
        this.id = id;
        this.InfoText = InfoText;
        this.UserID = UserID;
        this.InfoDate = InfoDate;
    }
    
    public Date getInfoDate() {
        return InfoDate;
    }

    public void setInfoDate(Date InfoDate) {
        this.InfoDate = InfoDate;
    }
    
    public String getInfoText() {
        return InfoText;
    }

    public void setInfoText(String InfoText) {
        this.InfoText = InfoText;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "InformationTransfer{" + "id=" + id + ", InfoText=" + 
                InfoText + ", UserID=" + UserID + '}';
    }

    
    
}

