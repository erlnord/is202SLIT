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
@Table(name = "Module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m"),
    @NamedQuery(name = "Module.findByModuleID", query = "SELECT m FROM Module m WHERE m.moduleID = :moduleID"),
    @NamedQuery(name = "Module.findByModuleName", query = "SELECT m FROM Module m WHERE m.moduleName = :moduleName")})
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ModuleID")
    private Integer moduleID;
    @Size(max = 65)
    @Column(name = "ModuleName")
    private String moduleName;
    @Lob
    @Column(name = "ModuleFile")
    private byte[] moduleFile;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne
    private User userID;

    public Module() {
    }

    public Module(Integer moduleID) {
        this.moduleID = moduleID;
    }

    public Integer getModuleID() {
        return moduleID;
    }

    public void setModuleID(Integer moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public byte[] getModuleFile() {
        return moduleFile;
    }

    public void setModuleFile(byte[] moduleFile) {
        this.moduleFile = moduleFile;
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
        hash += (moduleID != null ? moduleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.moduleID == null && other.moduleID != null) || (this.moduleID != null && !this.moduleID.equals(other.moduleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Module[ moduleID=" + moduleID + " ]";
    }
    
}
