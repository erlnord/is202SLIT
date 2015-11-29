/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Remote;

/**
 *
 * @author lmgr
 */
@Remote
public interface ModuleBeanRemote {

    ModuleTransfer findModule(int ModuleID);

    void updateModule(int ModuleID, String ModuleDescription, 
            String ModuleApproval, String ModuleResource, int UserID);
    
}
