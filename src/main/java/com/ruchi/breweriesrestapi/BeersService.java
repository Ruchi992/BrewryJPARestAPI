/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruchi.breweriesrestapi;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruchi Devi
 */
@Service
public class BeersService {

    @Autowired
    BeersService Service;
    static List<Beers> BeersList = new ArrayList();
    public static List<Beers> getAllBeers() {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        System.out.println("BreweriesDB Beers");
        String query = "SELECT b FROM Beers b";

        TypedQuery<Beers> typedQuery = em.createQuery(query, Beers.class);

        List<Beers> list = null;
        try {
            list = typedQuery.getResultList();
            for (Beers beers : list) {
                System.out.println(beers);
            }
            if (list == null || list.isEmpty()) {
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        System.out.println("end");
        return list;
    }
    public  static Beers getBeersByID(int beersID) {
        
        EntityManager em = DBUtil.getEMF().createEntityManager();
        

        Beers beers = null;
        try {
           
            beers = em.find(Beers.class, beersID);
            System.out.println("list" + beersID);
            
            if (beers == null)
                return null;
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            
            em.close();
        }
          System.out.println("list1" + beersID);
        return beers;                  
    }
    public static int deleteBeers(int id) {
        System.out.println("PropertyDB DeleteProperty " + id);
        EntityManager em = DBUtil.getEMF().createEntityManager();        
        String query = "DELETE FROM Beers b WHERE b.id = :id";                
        TypedQuery<Beers> tq = em.createQuery(query, Beers.class);
        int result = 0;        
        try {
            
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            result = tq.setParameter("id", id).executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        
        return result;
    }
     public  Beers  InsertBeers(Beers  b){
       EntityManager em = DBUtil.getEMF().createEntityManager();
       try{
       EntityTransaction tx = em.getTransaction();
        tx.begin();
        System.out.println("brewery" + b);
        em.persist(b);       
        tx.commit();
       }catch (Exception ex) {
           ex.printStackTrace();
            System.out.println(ex);
        } finally {
            em.close();
        }
       return b;
    }     
      public  Beers  UpdateBeers( int id, Beers  b){
       EntityManager em = DBUtil.getEMF().createEntityManager();
       try{
       EntityTransaction tx = em.getTransaction();
        tx.begin();
        System.out.println("beer" + b);
        em.merge(b);
        em.merge(id);
        tx.commit();
       }catch (Exception ex) {
           ex.printStackTrace();
            System.out.println(ex);
        } finally {
            em.close();
        }
       return b;
    }
}

