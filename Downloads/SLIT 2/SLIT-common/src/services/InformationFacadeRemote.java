/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Information;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author larsmartin
 */
@Remote
public interface InformationFacadeRemote {

    void create(Information information);

    void edit(Information information);

    void remove(Information information);

    Information find(Object id);

    List<Information> findAll();

    List<Information> findRange(int[] range);

    int count();
    
}
