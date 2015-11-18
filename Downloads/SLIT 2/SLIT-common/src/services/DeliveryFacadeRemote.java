/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Delivery;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author larsmartin
 */
@Remote
public interface DeliveryFacadeRemote {

    void create(Delivery delivery);

    void edit(Delivery delivery);

    void remove(Delivery delivery);

    Delivery find(Object id);

    List<Delivery> findAll();

    List<Delivery> findRange(int[] range);

    int count();
    
}
