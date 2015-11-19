/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Information;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Erlend
 */
@Stateless
public class InformationFacade extends AbstractFacade<Information> implements services.InformationFacadeRemote {
    @PersistenceContext(unitName = "SLIT-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InformationFacade() {
        super(Information.class);
    }
    
}
