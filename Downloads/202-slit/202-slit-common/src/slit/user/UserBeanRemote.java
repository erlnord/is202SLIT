/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.user;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author larsmartin
 */
@Remote
public interface UserBeanRemote {
   
    void addUser(int UserType, String FirstName, String LastName, String UserName, String PassPhrase, String Email);
    
    UserTransfer findUser(int id);
    
    void removeUser(int id);
    
    UserTransfer printUser (int UserID);

    List<UserTransfer> findAllUsers();
    
    List<UserTransfer> findAllUsersbyID(int ID);
    
    boolean changePassword(int bruker_id, String nyttPassord, String gammeltPassord);
    
    void changeEmail(int bruker_id, String nyEmail);
    
    public boolean searchForUser(String userName);
    
}
