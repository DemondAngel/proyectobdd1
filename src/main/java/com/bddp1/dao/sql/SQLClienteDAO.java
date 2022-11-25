package com.bddp1.dao.sql;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import com.bddp1.dao.ClienteDAO;

public class SQLClienteDAO implements ClienteDAO{

    private final EntityManager em;

    public SQLClienteDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean updateEmail(String emailActual, String emailNuevo) {
        boolean update = false;
        try{
            
            String stored = "sp_ActualizarCant";
            em.getTransaction().begin();
    
            StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery(stored);
    
            storedProcedure.registerStoredProcedureParameter("EmailActual", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("EmailNuevo", String.class, ParameterMode.IN);
            storedProcedure.setParameter("EmailActual", emailActual);
            storedProcedure.setParameter("EmailNuevo", emailNuevo);
            update = storedProcedure.execute();
            em. getTransaction().commit();
        }
        catch(Exception e){
            e.getStackTrace();
        }

        return update;
    }
    
}
