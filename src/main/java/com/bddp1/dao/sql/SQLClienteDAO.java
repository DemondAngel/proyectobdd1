package com.bddp1.dao.sql;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import com.bddp1.dao.ClienteDAO;

public class SQLClienteDAO implements ClienteDAO {

    private final EntityManager em;

    public SQLClienteDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void updateEmail(String emailActual, String emailNuevo) {

            String stored = "sp_ActualizarEmail";
            em.getTransaction().begin();

            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);

            storedProcedure.registerStoredProcedureParameter("EmailActual", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("EmailNuevo", Integer.class, ParameterMode.IN);
            storedProcedure.setParameter("EmailActual", emailActual);
            storedProcedure.execute();
            em.getTransaction().commit();

    }

}
