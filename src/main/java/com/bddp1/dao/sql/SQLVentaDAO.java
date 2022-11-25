package com.bddp1.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import com.bddp1.dao.VentaDAO;
import com.bddp1.model.Venta;

public class SQLVentaDAO implements VentaDAO{
    
    private final EntityManager em;

    public SQLVentaDAO(EntityManager em) {
        this.em = em;
    }
    


    @Override
    public List<Venta> getTotalVentasProducto(Long category) {
        List<Venta> ventas = null;
        try{
            
            String stored = "sp_TotVentas";
            em.getTransaction().begin();
    
            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);
    
            storedProcedure.registerStoredProcedureParameter("categoryID", Long.class, ParameterMode.IN);
            storedProcedure.setParameter("categoryID", category);
            ventas = storedProcedure.getResultList();
            em. getTransaction().commit();
        }
        catch(Exception e){
            e.getStackTrace();
        }

        return ventas;
    }
    
}
