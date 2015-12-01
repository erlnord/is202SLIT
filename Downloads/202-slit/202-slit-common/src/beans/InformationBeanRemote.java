/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author larsmartin
 */
@Remote
public interface InformationBeanRemote {
    
    void addInfo(String InfoText, Integer UserID, Date InfoDate);

    List<InformationTransfer> findAllInformation();
}
