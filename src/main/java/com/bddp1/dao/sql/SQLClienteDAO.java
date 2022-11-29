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
    public int proveEmail(String emailActual) {
        int update = 0;
        try {

            String stored = "sp_ActualizarEmail";
            em.getTransaction().begin();

            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);

            storedProcedure.registerStoredProcedureParameter("EmailActual", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("EXISTSID", Integer.class, ParameterMode.OUT);
            storedProcedure.setParameter("EmailActual", emailActual);
            storedProcedure.execute();
            update = (int) storedProcedure.getOutputParameterValue("EXISTSID");
            em.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
        }

        return update;
    }

    @Override
    public int updateEmail(int idEmail, String emailNuevo) {
        int update = 0;
        try {

            String stored = "UPDATE SalesAW.Person.EmailAddress set EmailAddress = '" + emailNuevo
                    + "' WHERE EmailAddressID = '" + idEmail + "';";
            em.getTransaction().begin();

            Query q = em.createNativeQuery(stored);
            update = q.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
        }

        return update;
    }

}
