package com.bddp1.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import com.bddp1.dao.OrdenDAO;
import com.bddp1.model.OrdenTerritorio;

public class SQLOrdenDAO implements OrdenDAO{

    private final EntityManager em;

    public SQLOrdenDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<OrdenTerritorio> getCustomerDiffTerritory() {
        List<OrdenTerritorio> ordenes = null;
        try{
            
            String stored = "sp_CustomerDiferrentOrder";
            em.getTransaction().begin();
    
            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);
    
            ordenes = storedProcedure.getResultList();
            em. getTransaction().commit();
        }
        catch(Exception e){
            e.getStackTrace();
        }

        return ordenes;
    }

    @Override
    public boolean updateProductsOrder(int idSalesOrder, int quantity) {
        boolean update = false;
        try{
            
            String stored = "sp_ActualizarCant";
            em.getTransaction().begin();
    
            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);
    
            storedProcedure.registerStoredProcedureParameter("SOID", Integer.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("SOCant", Integer.class, ParameterMode.IN);
            storedProcedure.setParameter("SOID", idSalesOrder);
            storedProcedure.setParameter("SOCant", quantity);
            update = storedProcedure.execute();
            em. getTransaction().commit();
        }
        catch(Exception e){
            e.getStackTrace();
        }

        return update;
    }

    @Override
    public boolean updateOrdenDeliver(int idSalesOrder, int shipMethodID) {
        boolean update = false;
        try{
            
            String stored = "sp_ActualizarMetEnvio";
            em.getTransaction().begin();
    
            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);
    
            storedProcedure.registerStoredProcedureParameter("SOID", Integer.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("SHIPMTHID", Integer.class, ParameterMode.IN);
            storedProcedure.setParameter("SOID", idSalesOrder);
            storedProcedure.setParameter("SHIPMTHID", shipMethodID);
            update = storedProcedure.execute();
            em. getTransaction().commit();
        }
        catch(Exception e){
            e.getStackTrace();
        }

        return update;
    }
    
}
