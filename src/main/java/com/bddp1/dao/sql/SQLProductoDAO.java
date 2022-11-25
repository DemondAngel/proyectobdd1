package com.bddp1.dao.sql;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import com.bddp1.dao.ProductoDAO;
import com.bddp1.model.ProductoVendido;

public class SQLProductoDAO implements ProductoDAO{

    private final EntityManager em;

    public SQLProductoDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public ProductoVendido getProdMoreRequested(String territory) {
        ProductoVendido productoVendido = null;
        try{
            
            String stored = "sp_ProdMasSolicitado";
            em.getTransaction().begin();
    
            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);
    
            storedProcedure.registerStoredProcedureParameter("Territory", String.class, ParameterMode.IN);
            storedProcedure.setParameter("Territory", territory);
            productoVendido = (ProductoVendido) storedProcedure.getSingleResult();
            em. getTransaction().commit();
        }
        catch(Exception e){
            e.getStackTrace();
        }

        return productoVendido;
    }

    @Override
    public boolean updateStock(int category) {
        boolean update = false;
        try{
            
            String stored = "sp_ActualizarStock";
            em.getTransaction().begin();
    
            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);
    
            storedProcedure.registerStoredProcedureParameter("Categ", Integer.class, ParameterMode.IN);
            storedProcedure.setParameter("Categ", category);
            update = storedProcedure.execute();
            em. getTransaction().commit();
        }
        catch(Exception e){
            e.getStackTrace();
        }

        return update;
    }

}