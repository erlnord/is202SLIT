/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Delivery;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Erlend
 */
@Stateless
public class DeliveryFacade extends AbstractFacade<Delivery> implements DeliveryFacadeRemote {
    @PersistenceContext(unitName = "SLIT-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeliveryFacade() {
        super(Delivery.class);
    }
    
}
