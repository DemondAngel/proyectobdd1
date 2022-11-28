package com.bddp1.dao.sql;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import com.bddp1.dao.ProductoDAO;
import com.bddp1.model.ProductoVendido;

public class SQLProductoDAO implements ProductoDAO {

    private final EntityManager em;

    public SQLProductoDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public ProductoVendido getProdMoreRequested(String territory) {
        ProductoVendido productoVendido = null;
        try {

            String stored = "sp_ProdMasSolicitado";
            em.getTransaction().begin();

            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);

            storedProcedure.registerStoredProcedureParameter("Territory", String.class, ParameterMode.IN);
            storedProcedure.setParameter("Territory", territory);
            storedProcedure.execute();
            List<Object[]> result = storedProcedure.getResultList();

            if (!result.isEmpty()) {

                productoVendido = new ProductoVendido((int) result.get(0)[2], (String) result.get(0)[1],
                        (BigDecimal) result.get(0)[0]);

            }

            em.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
        }

        return productoVendido;
    }

    @Override
    public int getProductIdtoUpdate(int category) {
        int pId = 0;
        try {

            String stored = "sp_ActualizarStock";
            em.getTransaction().begin();

            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);

            storedProcedure.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
            storedProcedure.setParameter(1, category);
            storedProcedure.execute();
            pId = (int) storedProcedure.getOutputParameterValue(2);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getLocalizedMessage());
        }

        return pId;
    }

    @Override
    public int updateStock(int pId) {

        int update = 0;
        try {

            String stored = "update productionAW.Production.ProductInventory set Quantity = Quantity*1.05 WHERE ProductID ="
                    + Integer.toString(pId) + ";";
            em.getTransaction().begin();

            Query q = em.createNativeQuery(stored);
            update = q.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getLocalizedMessage());
        }

        return update;
    }

}