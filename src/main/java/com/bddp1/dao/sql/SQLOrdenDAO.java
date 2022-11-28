package com.bddp1.dao.sql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import com.bddp1.dao.OrdenDAO;
import com.bddp1.model.OrdenTerritorio;

public class SQLOrdenDAO implements OrdenDAO {

    private final EntityManager em;

    public SQLOrdenDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<OrdenTerritorio> getCustomerDiffTerritory() {
        List<OrdenTerritorio> ordenes = null;
        try {

            String stored = "sp_CustomerDiferrentOrder";
            em.getTransaction().begin();

            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);
            List<Object[]> results = storedProcedure.getResultList();

            if (!results.isEmpty()) {
                ordenes = new ArrayList<>();
                for (int i = 0; i < results.size(); i++) {
                    OrdenTerritorio ordenTerritorio = new OrdenTerritorio((int) results.get(i)[1],
                            (int) results.get(i)[0],
                            (String) results.get(i)[2]);
                    ordenes.add(ordenTerritorio);
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
        }

        return ordenes;
    }

    @Override
    public int proveProductsOrder(int idSalesOrder, int quantity) {
        int exists = 0;
        try {

            String stored = "sp_ActualizarCant";
            em.getTransaction().begin();

            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);

            storedProcedure.registerStoredProcedureParameter("SOID", Integer.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("SOCant", Integer.class, ParameterMode.IN);
            storedProcedure.setParameter("SOID", idSalesOrder);
            storedProcedure.setParameter("SOCant", quantity);
            storedProcedure.execute();

            exists = (int) storedProcedure.getOutputParameterValue("EXISTSSOID");
            em.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
        }

        return exists;
    }

    @Override
    public int updateOrdenDeliver(int idSalesOrder, int shipMethodID) {
        int exists = 0;
        try {

            String stored = "sp_ActualizarMetEnvio";
            em.getTransaction().begin();

            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);

            storedProcedure.registerStoredProcedureParameter("SOID", Integer.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("SHIPMTHID", Integer.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("EXISTSID", Integer.class, ParameterMode.IN);
            storedProcedure.setParameter("SOID", idSalesOrder);
            storedProcedure.setParameter("SHIPMTHID", shipMethodID);
            storedProcedure.execute();
            exists = (int) storedProcedure.getOutputParameterValue("EXISTSID");
            em.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
        }

        return exists;
    }

    @Override
    public int updateProductsOrder(int idSalesOrder, int quantity) {
        int update = 0;
        try {

            String stored = "update salesAW.Sales.SalesOrderDetail set OrderQty = "
                    + Integer.toString(quantity) + " where SalesOrderID = " + Integer.toString(idSalesOrder) + ";";
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
