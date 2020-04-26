/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruchi.breweriesrestapi;

import java.util.ArrayList;
import java.util.Iterator;
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
public class BreweriesService {
     @Autowired
    BreweriesService Service;
     
     static List<Breweries> breweriestList = new ArrayList();

    public static List<Breweries> getAllBreweries() {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        System.out.println("BreweriesDB Breweries");
        String query = "SELECT b FROM Breweries b";

        TypedQuery<Breweries> typedQuery = em.createQuery(query, Breweries.class);

        List<Breweries> list = null;

        try {
            list = typedQuery.getResultList();
            for (Breweries brewery : list) {
                System.out.println(brewery);

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
        public static List<Breweries> getAllBreweriesPagination(int start,int size) {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        System.out.println("BreweriesDB Breweries");
        String query = "SELECT b FROM Breweries b";
        TypedQuery<Breweries> typedQuery = em.createQuery(query, Breweries.class);
        List<Breweries> list = null;

        try {
            list = typedQuery.getResultList();
            for (Breweries brewery : list) {
                System.out.println(brewery); 
            }

            if (start + size > list.size()) {
                return list;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        System.out.println("end");
        return null;
    } 

    
     
    /**
     *
     * @param breweriesID
     * @return
     */
    public  static Breweries getBreweriesByID(int breweriesID) {
        
        EntityManager em = DBUtil.getEMF().createEntityManager();
        

        Breweries breweries = null;
        try {
           
            breweries = em.find(Breweries.class, breweriesID);
            System.out.println("list" + breweriesID);
            
            if (breweries == null)
                return null;
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            
            em.close();
        }
          System.out.println("list1" + breweriesID);
        return breweries;
                   
    }
    public static int deleteBreweries(int id) {
        System.out.println("PropertyDB DeleteProperty " + id);
        EntityManager em = DBUtil.getEMF().createEntityManager();        
        String query = "DELETE FROM Breweries b WHERE b.id = :id";
                
        TypedQuery<Breweries> tq = em.createQuery(query, Breweries.class);
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
    public  Breweries  InsertBreweries(Breweries b){
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
    
    public void updateBreweries(int id, Breweries b){
       EntityManager em = DBUtil.getEMF().createEntityManager();
       try{
       EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        em.merge(b);
        em.merge(id);        
        tx.commit();

       }catch (Exception ex) {
           ex.printStackTrace();
            System.out.println(ex);
        } finally {
            em.close();
        }
       
    } 

    
}

  

    

