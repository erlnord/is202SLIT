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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author larsmartin
 */
@Entity
@Table(name = "Delivery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Delivery.findAll", query = "SELECT d FROM Delivery d"),
    @NamedQuery(name = "Delivery.findByDeliveryID", query = "SELECT d FROM Delivery d WHERE d.deliveryID = :deliveryID"),
    @NamedQuery(name = "Delivery.findByStatus", query = "SELECT d FROM Delivery d WHERE d.status = :status"),
    @NamedQuery(name = "Delivery.findByFeedback", query = "SELECT d FROM Delivery d WHERE d.feedback = :feedback")})
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DeliveryID")
    private Integer deliveryID;
    @Column(name = "Status")
    private Integer status;
    @Size(max = 255)
    @Column(name = "Feedback")
    private String feedback;
    @Lob
    @Column(name = "DeliveryFile")
    private byte[] deliveryFile;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne
    private User userID;

    public Delivery() {
    }

    public Delivery(Integer deliveryID) {
        this.deliveryID = deliveryID;
    }

    public Integer getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(Integer deliveryID) {
        this.deliveryID = deliveryID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliveryID != null ? deliveryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delivery)) {
            return false;
        }
        Delivery other = (Delivery) object;
        if ((this.deliveryID == null && other.deliveryID != null) || (this.deliveryID != null && !this.deliveryID.equals(other.deliveryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Delivery[ deliveryID=" + deliveryID + " ]";
    }
    
}
