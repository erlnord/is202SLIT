/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Module;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lmgr
 */
@Stateless(name="ModuleBean")
public class ModuleBean implements ModuleBeanRemote {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public ModuleTransfer findModule(int ModuleID) {
        Module module = em.find(Module.class, ModuleID);
        if (null == module) {
            System.out.println("found nutting");
            return null;
        }
        else
        return new ModuleTransfer(module.getModuleID(), 
                module.getModuleDescription(), module.getModuleApproval(), 
                module.getModuleResource(), module.getUserID());
    }
    
    @Override
    public void updateModule(int ModuleID, String ModuleDescription, 
            String ModuleApproval, String ModuleResource, int UserID) {
        Module module = em.find(Module.class,ModuleID);
        
        module.setModuleApproval(ModuleApproval);
        module.setModuleDescription(ModuleDescription);
        module.setModuleID(ModuleID);
        module.setModuleResource(ModuleResource);
        module.setUserID(UserID);
        
        em.merge(module);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    
    
    
}
