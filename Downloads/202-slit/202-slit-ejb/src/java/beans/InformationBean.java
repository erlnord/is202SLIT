/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Information;
import java.util.ArrayList;
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
@Stateless
public class InformationBean implements InformationBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    EntityManager em;
    
    private EntityManagerFactory emf = null;
    
    @Override
    public void addInfo(String InfoText, Integer UserID) {
        Information info = new Information();
        info.setInfoText(InfoText);
        info.setUserID(UserID);
        
        em.persist(info);
        
        System.out.println("User added.");
        //return true;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<InformationTransfer> findInformationEntities() {
        return findInformationEntities(true/*, -1, -1*/);
    }
    

    //public List<InformationTransfer> findInformationEntities(/*int maxResults, int firstResult*/) {
    //    return findInformationEntities(false/*, maxResults, firstResult*/);
    //}
    
    public List<InformationTransfer> findInformationEntities(boolean all/*, int maxResults, int firstResult*/) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Information.class));
            Query q = em.createQuery(cq);
            
            if (!all) {
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
                
                if (rowCnt < 7)
                    count = rowCnt;
                else
                    count = 7 - rowCnt;
                    
                q.setFirstResult(count);
            }
            
            List<Information> results = q.getResultList();
            ArrayList<InformationTransfer> liste = new ArrayList();
            for (Information i : results) {
                InformationTransfer it = new InformationTransfer(i.getId(),
                i.getInfoText(), i.getUserID());
                
                liste.add(it);
            }
            
            return liste;
        } finally {
            em.close();
        }
    }
    
}
