/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import slit.user.UserBeanRemote;
import entities.Users;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import slit.user.UserTransfer;

/**
 *
 * @author larsmartin
 */
@Stateless(mappedName="UserBean")
public class UserBean implements UserBeanRemote {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public void addUser(int UserType, String FirstName, String LastName, String UserName, String PassPhrase, String Email) {
        Users user = new Users();
        user.setUserType(UserType);
        user.setFirstName(FirstName);
        user.setLastName(LastName);
        user.setUserName(UserName);
        user.setPassPhrase(PassPhrase);
        user.setEmail(Email);
        em.persist(user);
    }
    
    /* Finne antall inserts
    SELECT e, COUNT(p), COUNT(Distinct p.type)
    FROM Employee e JOIN e.phones p
    GROUP BY e
    */

    @Override
    public List<UserTransfer> sfindAllUsers() {
        
        TypedQuery<Users> query =
            em.createQuery("SELECT e FROM User e", Users.class);
        
        List<Users> results = query.getResultList();
        
        ArrayList<UserTransfer> liste = new ArrayList();
        for (Users u : results) {
            UserTransfer ut = new UserTransfer(u.getUserID(), u.getUserType(), 
            u.getFirstName(),u.getLastName(), u.getUserName(),
            u.getPassPhrase(),u.getEmail());
            
            liste.add(ut);
        }
        return liste;
        
    }
    
        /*
            List<Users> results = q.getResultList();
            
            ArrayList<UserTransfer> liste = new ArrayList();
            for (Users u : results) {
                UserTransfer ut = new UserTransfer(u.getUserID(), u.getUserType(), u.getFirstName(),
                u.getLastName(), u.getUserName(), u.getPassPhrase(),
                u.getEmail());

                liste.add(ut);
            }*/
    
    @Override
    public UserTransfer findUser(int id) {
        Users user = em.find(Users.class,id);        
        return new UserTransfer(user.getUserID(), user.getUserType(),
            user.getFirstName(), user.getLastName(), user.getUserName(),
            user.getPassPhrase(), user.getEmail());
    }
    
    // Finner en user etter ID og sletter denne raden. Det oppstår et hull i
    // IDene der den som ble fjernet var.
    @Override
    public void removeUser(int id) {
        Users user = em.find(Users.class,id);
        em.remove(user);
    }

    @Override
    public UserTransfer printUser (int userid) {
        Users user = em.find(Users.class, userid);
        if (null == user) {
            System.out.println("found nutting");
            return null;
        }
        else
            return new UserTransfer(user.getUserID(), user.getUserType(),
            user.getFirstName(), user.getLastName(), user.getUserName(),
            user.getPassPhrase(), user.getEmail());
    }
}

    
    
    
