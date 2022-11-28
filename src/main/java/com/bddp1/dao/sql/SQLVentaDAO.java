package com.bddp1.dao.sql;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    public List<Venta> getTotalVentasProducto(int category) {
        List<Venta> ventas = null;
        try{
            
            String stored = "sp_TotVentas";
            em.getTransaction().begin();
    
            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);
            
            storedProcedure.registerStoredProcedureParameter("categoryID", Integer.class, ParameterMode.IN);
            storedProcedure.setParameter("categoryID", category);
            storedProcedure.execute();
            
            List<Object[]> results =storedProcedure.getResultList();
            
            if(!results.isEmpty()){
                ventas = new ArrayList<>();
                for(int i = 0; i < results.size();i++){
                    Venta venta = new Venta((int) results.get(i)[0], (BigDecimal) results.get(i)[1], (String) results.get(i)[2]);
                    ventas.add(venta);
                }
            }
            
            em. getTransaction().commit();
        }
        catch(Exception e){
            e.getStackTrace();
            System.out.println(e.getLocalizedMessage());
        }

        return ventas;
    }
    
}
