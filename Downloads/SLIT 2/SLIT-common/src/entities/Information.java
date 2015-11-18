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
@Table(name = "Information")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Information.findAll", query = "SELECT i FROM Information i"),
    @NamedQuery(name = "Information.findByInfoID", query = "SELECT i FROM Information i WHERE i.infoID = :infoID")})
public class Information implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "InfoID")
    private Integer infoID;
    @Lob
    @Size(max = 65535)
    @Column(name = "InfoText")
    private String infoText;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne
    private User userID;

    public Information() {
    }

    public Information(Integer infoID) {
        this.infoID = infoID;
    }

    public Integer getInfoID() {
        return infoID;
    }

    public void setInfoID(Integer infoID) {
        this.infoID = infoID;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
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
        hash += (infoID != null ? infoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Information)) {
            return false;
        }
        Information other = (Information) object;
        if ((this.infoID == null && other.infoID != null) || (this.infoID != null && !this.infoID.equals(other.infoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Information[ infoID=" + infoID + " ]";
    }
    
}
