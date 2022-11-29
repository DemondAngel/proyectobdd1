package com.bddp1.dao;

public interface ClienteDAO {
    public int proveEmail(String emailNuevo);

    public int updateEmail(int idEmail, String emailNuevo);
}
