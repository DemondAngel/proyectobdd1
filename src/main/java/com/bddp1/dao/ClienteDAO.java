package com.bddp1.dao;

public interface ClienteDAO {
    public int proveEmail(String emailActual, String emailNuevo);

    public int updateEmail(String emailActual, String emailNuevo);
}
