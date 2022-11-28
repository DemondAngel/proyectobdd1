package com.bddp1.dao.sql;

import java.math.BigDecimal;
import java.util.List;

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
            storedProcedure.execute();
            List<Object[]> result = storedProcedure.getResultList();

            if(!result.isEmpty()){

                productoVendido = new ProductoVendido((int) result.get(0)[2], (String) result.get(0)[1], (BigDecimal) result.get(0)[0]);

            }

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
    
            storedProcedure.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            storedProcedure.setParameter(1, category);
            storedProcedure.execute();
            em.getTransaction().commit();
        }
        catch(Exception e){
            e.getStackTrace();
            System.out.println(e.getLocalizedMessage());
        }

        return update;
    }

}