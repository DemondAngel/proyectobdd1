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

        return ordenes;
    }

    @Override
    public void updateProductsOrder(int idSalesOrder, int quantity) {

            String stored = "sp_ActualizarCant";
            em.getTransaction().begin();

            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);

            storedProcedure.registerStoredProcedureParameter("SOID", Integer.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("SOCant", Integer.class, ParameterMode.IN);
            storedProcedure.setParameter("SOID", idSalesOrder);
            storedProcedure.setParameter("SOCant", quantity);
            storedProcedure.execute();
            em.getTransaction().commit();
    }

    @Override
    public void updateOrdenDeliver(int idSalesOrder, int shipMethodID) {

            String stored = "sp_ActualizarMetEnvio";
            em.getTransaction().begin();

            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);

            storedProcedure.registerStoredProcedureParameter("SOID", Integer.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("SHIPMTHID", Integer.class, ParameterMode.IN);
            storedProcedure.setParameter("SOID", idSalesOrder);
            storedProcedure.setParameter("SHIPMTHID", shipMethodID);
            storedProcedure.execute();
            em.getTransaction().commit();
    }

}
