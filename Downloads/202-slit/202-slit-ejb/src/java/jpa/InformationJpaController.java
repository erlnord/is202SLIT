/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import beans.InformationTransfer;
import entities.Information;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import jpa.exceptions.NonexistentEntityException;
import jpa.exceptions.RollbackFailureException;

/**
 *
 * @author lmgr
 */
public class InformationJpaController implements Serializable {

    public InformationJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Information information) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(information);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Information information) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            information = em.merge(information);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = information.getId();
                if (findInformation(id) == null) {
                    throw new NonexistentEntityException("The information with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Information information;
            try {
                information = em.getReference(Information.class, id);
                information.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The information with id " + id + " no longer exists.", enfe);
            }
            em.remove(information);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InformationTransfer> findInformationEntities() {
        return findInformationEntities(true, -1/*, -1*/);
    }

    public List<InformationTransfer> findInformationEntities(int maxResults/*, int firstResult*/) {
        return findInformationEntities(false, maxResults/*, firstResult*/);
    }

    private List<InformationTransfer> findInformationEntities(boolean all, int maxResults/*, int firstResult*/) {
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

    public Information findInformation(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Information.class, id);
        } finally {
            em.close();
        }
    }

    public int getInformationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Information> rt = cq.from(Information.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
