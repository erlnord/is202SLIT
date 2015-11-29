/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author lmgr
 */
public class ModuleTransfer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int ModuleID;
    private String ModuleDescription;
    private String ModuleApproval;
    private String ModuleResource;
    private int UserID;
    
    public ModuleTransfer (int ModuleID, String ModuleDescription, 
            String ModuleApproval, String ModuleResource, int UserID) {
        
        this.ModuleID = ModuleID;
        this.ModuleDescription = ModuleDescription;
        this.ModuleApproval = ModuleApproval;
        this.ModuleResource = ModuleResource;
        this.UserID = UserID;
    }
    

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
    public String toString() {
        return "Module{" + "ModuleID=" + ModuleID + ", ModuleDescription=" + 
            ModuleDescription + ", ModuleApproval=" + ModuleApproval + ", "
            + "ModuleResource=" + ModuleResource + ", UserID=" + UserID + '}';
    }

    
    
}
