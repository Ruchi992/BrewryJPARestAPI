/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruchi.breweriesrestapi;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruchi Devi
 */
@Service
public class BreweriesGeocodeService {
    
     BreweriesGeocodeService Service;
     
    static List<BreweriesGeocode> BreweriesGeocodeList = new ArrayList();
    
    public static List<BreweriesGeocode> getAllBreweriesGeocode() {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        System.out.println("BreweriesGeocodeDB BreweriesGeocode");
        String query = "SELECT b FROM BreweriesGeocode b";

        TypedQuery<BreweriesGeocode> typedQuery = em.createQuery(query, BreweriesGeocode.class);

        List<BreweriesGeocode> list = null;
        try {
            list = typedQuery.getResultList();
            for (BreweriesGeocode breweriesGeocode : list) {
                System.out.println(breweriesGeocode);
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
    
    public  static BreweriesGeocode getBreweriesGeocodeByID(int id) {
        
        EntityManager em = DBUtil.getEMF().createEntityManager();
        

        BreweriesGeocode  breweriesGeocode  = null;
        try {
           
           breweriesGeocode = em.find(BreweriesGeocode.class, id);
            System.out.println("list" + id);
            
            if (breweriesGeocode== null)
                return null;
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            
            em.close();
        }
          System.out.println("list1" + id);
        return breweriesGeocode;                  
    } 
    
     public static List<BreweriesGeocode> getBreweriesGeocodBylatitude(float latitude) {
        System.out.println("getBreweriesGeocodBylatitude " + latitude);
        EntityManager em = DBUtil.getEMF().createEntityManager();
        String query = "SELECT b FROM BreweriesGeocode b WHERE b.latitude = :latitude";
        
        
        TypedQuery<BreweriesGeocode> tq = em.createQuery(query, BreweriesGeocode.class);
        
        List<BreweriesGeocode> list = null;
        
        try {
            list = tq.setParameter("latitude", latitude).getResultList();
            for(BreweriesGeocode b : list){
                System.out.println(b);
            
            }

            if (list == null || list.size() == 0) {
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        return list;
     }
}



