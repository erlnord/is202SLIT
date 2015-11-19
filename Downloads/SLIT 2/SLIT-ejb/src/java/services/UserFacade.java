/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author larsmartin
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements services.UserFacadeRemote {

    @PersistenceContext(unitName = "SLIT-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public UserFacade() {
        super(User.class);
    }
    
    
    
    
    @Override
    public Boolean addUrne(Integer userID, Integer userType, String firstName, String lastName, String userName, String passPhrase, String email) {
        User user = new User();
        user.setUserID(userID);
        user.setUserType(userType);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(userName);
        user.setPassPhrase(passPhrase);
        user.setEmail(email);
        try {
            em.persist(user);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
