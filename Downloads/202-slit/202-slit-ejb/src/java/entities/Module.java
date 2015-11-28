/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author lmgr
 */
@Entity
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ModuleID;
    
    private String ModuleDescription;
    private String ModuleApproval;
    private String ModuleResource;
    private int UserID;

    public int getModuleID() {
        return ModuleID;
    }

    public void setModuleID(int ModuleID) {
        this.ModuleID = ModuleID;
    }

    public String getModuleDescription() {
        return ModuleDescription;
    }

    public void setModuleDescription(String ModuleDescription) {
        this.ModuleDescription = ModuleDescription;
    }

    public String getModuleApproval() {
        return ModuleApproval;
    }

    public void setModuleApproval(String ModuleApproval) {
        this.ModuleApproval = ModuleApproval;
    }

    public String getModuleResource() {
        return ModuleResource;
    }

    public void setModuleResource(String ModuleResource) {
        this.ModuleResource = ModuleResource;
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
        hash = 41 * hash + this.ModuleID;
        hash = 41 * hash + Objects.hashCode(this.ModuleDescription);
        hash = 41 * hash + Objects.hashCode(this.ModuleApproval);
        hash = 41 * hash + Objects.hashCode(this.ModuleResource);
        hash = 41 * hash + this.UserID;
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
        final Module other = (Module) obj;
        if (this.ModuleID != other.ModuleID) {
            return false;
        }
        if (this.UserID != other.UserID) {
            return false;
        }
        if (!Objects.equals(this.ModuleDescription, other.ModuleDescription)) {
            return false;
        }
        if (!Objects.equals(this.ModuleApproval, other.ModuleApproval)) {
            return false;
        }
        if (!Objects.equals(this.ModuleResource, other.ModuleResource)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "entities.Module[ ModuleID=" + ModuleID + " ]";
    }
    
}
