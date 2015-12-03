/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Remote;


/**
 *
 * @author Trygve Åse Lunde
 */
@Remote
public interface BookingBeanRemote {
    
    BookingTransfer findBooking(int BookingID);

 void addDag(int id, String Dag, 
            String Info, String Studenter);

    
   
   
    
    
}
