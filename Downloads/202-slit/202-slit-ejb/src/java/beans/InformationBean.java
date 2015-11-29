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
    public List<InformationTransfer> findInformationEntities() {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Information.class));
            Query q = em.createQuery(cq);
                q.setMaxResults(7);
                
                /*
                TypedQuery<Information> query = 
                        /*em.createQuery("SELECT e, COUNT(p), COUNT(Distinct "
                                + "p.type)\n FROM Information e JOIN e.phones "
                                + "p\n GROUP BY e", Information.class);*
                        
                        em.createQuery("Select count(*) from Information e", 
                                Information.class);
                        */
                
                int rowCnt = (Integer) em.createNativeQuery
                    ("SELECT count(*) FROM Information").getSingleResult();  
              
                int count;
                
                if (rowCnt < 1)
                    count = 1;
                else
                    count = rowCnt - 7;
                    
                q.setFirstResult(count);
            
            
            List<Information> results = q.getResultList();
            ArrayList<InformationTransfer> liste = new ArrayList();
            for (Information i : results) {
                InformationTransfer it = new InformationTransfer(i.getId(),
                i.getInfoText(), i.getUserID(), i.getInfoDate());
                
                liste.add(it);
            }
            
            return liste;
        } finally {
            em.close();
        }
    }
    
}
