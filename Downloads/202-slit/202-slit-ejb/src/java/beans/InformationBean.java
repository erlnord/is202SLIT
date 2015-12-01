/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Information;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author larsmartin
 */
@Stateless(name="InformationBean")
public class InformationBean implements InformationBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    EntityManager em;
    
    private EntityManagerFactory emf = null;
    
    @Override
    public void addInfo(String InfoText, Integer UserID, Date InfoDate) {
        Information info = new Information();
        info.setInfoText(InfoText);
        info.setUserID(UserID);
        info.setInfoDate(InfoDate);
        
        em.persist(info);
    }
    
    @Override
    public List<InformationTransfer> findAllInformation() {
        TypedQuery<Information> q = em.createQuery
                ("Select c from Information c order by c.id desc", Information.class);
        List<Information> results = q.getResultList();
            
            ArrayList<InformationTransfer> liste = new ArrayList();
            for (Information i : results) {
                InformationTransfer it = new InformationTransfer(i.getId(),
                i.getInfoText(), i.getUserID(), i.getInfoDate());
                
                liste.add(it);
            }
        return liste;
    }
    
}
