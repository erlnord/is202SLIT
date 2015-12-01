/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author larsmartin
 */
@Entity
public class Information implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="InfoID")
    private int id;
    
    private String InfoText;
    private Integer UserID;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date InfoDate;

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

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer UserID) {
        this.UserID = UserID;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.InfoText);
        hash = 97 * hash + Objects.hashCode(this.UserID);
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
        final Information other = (Information) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.InfoText, other.InfoText)) {
            return false;
        }
        if (!Objects.equals(this.UserID, other.UserID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Information{" + "id=" + id + ", InfoText=" + InfoText + ", "
                + "UserID=" + UserID + '}';
    }
    
}
