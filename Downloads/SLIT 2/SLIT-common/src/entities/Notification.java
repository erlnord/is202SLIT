/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Erlend
 */
@Entity
@Table(name = "Notification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n"),
    @NamedQuery(name = "Notification.findByNotifID", query = "SELECT n FROM Notification n WHERE n.notifID = :notifID"),
    @NamedQuery(name = "Notification.findByMessage", query = "SELECT n FROM Notification n WHERE n.message = :message")})
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NotifID")
    private Integer notifID;
    @Size(max = 255)
    @Column(name = "Message")
    private String message;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private User userID;

    public Notification() {
    }

    public Notification(Integer notifID) {
        this.notifID = notifID;
    }

    public Integer getNotifID() {
        return notifID;
    }

    public void setNotifID(Integer notifID) {
        this.notifID = notifID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notifID != null ? notifID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.notifID == null && other.notifID != null) || (this.notifID != null && !this.notifID.equals(other.notifID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Notification[ notifID=" + notifID + " ]";
    }
    
}
