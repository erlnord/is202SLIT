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
import javax.persistence.TypedQuery;

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
            //CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            //cq.select(cq.from(Information.class));
            //TypedQuery<Users> q = em.createQuery("Select c from Users c", Users.class);
            //TypedQuery<Information> q = 
            //        em.createQuery("Select c from Information c", Information.class);
                /**
                q.setMaxResults(7);
                System.out.println(q.getMaxResults());
                
                /*
                TypedQuery<Information> query = 
                        /*em.createQuery("SELECT e, COUNT(p), COUNT(Distinct "
                                + "p.type)\n FROM Information e JOIN e.phones "
                                + "p\n GROUP BY e", Information.class);*
                        
                        em.createQuery("Select count(*) from Information e", 
                                Information.class);
                        */
                
                //TypedQuery<Information> qvery = em.createQuery("SELECT count(s) FROM Information s", Information.class);
                /*
                Query query = em.createNativeQuery("Select count(s) FROM Information s");
                List<Number> counts = (List<Number>) query.getResultList();
                long count = counts.get(0).intValue();
                */
                //Number fuck = (Number) qvery.getSingleResult();
                // lol = fuck.intValue();
                
                /*
                int rowCnt = (Integer) em.createNativeQuery
                    ("SELECT count(*) FROM Information e").getSingleResult().intValue();  
                */
                //int count;
                
                //count = 1;
                  /*  
                q.setFirstResult(1);
                System.out.println(q.getFirstResult());
            */
            
            TypedQuery<Information> q = 
                    em.createQuery("Select c from Information c", Information.class);
                  
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
