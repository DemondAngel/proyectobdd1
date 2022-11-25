package com.bddp1.model;

import java.util.Objects;

public class OrdenTerritorio {
    private int idTerritorioOrden;
    private int idTerritorioCliente;
    private String nameTerritorioOrden;
    private String nameTerritorioCliente;


    public OrdenTerritorio() {
    }


    public OrdenTerritorio(int idTerritorioOrden, int idTerritorioCliente, String nameTerritorioOrden, String nameTerritorioCliente) {
        this.idTerritorioOrden = idTerritorioOrden;
        this.idTerritorioCliente = idTerritorioCliente;
        this.nameTerritorioOrden = nameTerritorioOrden;
        this.nameTerritorioCliente = nameTerritorioCliente;
    }


    public int getIdTerritorioOrden() {
        return this.idTerritorioOrden;
    }

    public void setIdTerritorioOrden(int idTerritorioOrden) {
        this.idTerritorioOrden = idTerritorioOrden;
    }

    public int getIdTerritorioCliente() {
        return this.idTerritorioCliente;
    }

    public void setIdTerritorioCliente(int idTerritorioCliente) {
        this.idTerritorioCliente = idTerritorioCliente;
    }

    public String getNameTerritorioOrden() {
        return this.nameTerritorioOrden;
    }

    public void setNameTerritorioOrden(String nameTerritorioOrden) {
        this.nameTerritorioOrden = nameTerritorioOrden;
    }

    public String getNameTerritorioCliente() {
        return this.nameTerritorioCliente;
    }

    public void setNameTerritorioCliente(String nameTerritorioCliente) {
        this.nameTerritorioCliente = nameTerritorioCliente;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrdenTerritorio)) {
            return false;
        }
        OrdenTerritorio OrdenTerritorio = (OrdenTerritorio) o;
        return Objects.equals(idTerritorioOrden, OrdenTerritorio.idTerritorioOrden) && Objects.equals(idTerritorioCliente, OrdenTerritorio.idTerritorioCliente) && Objects.equals(nameTerritorioOrden, OrdenTerritorio.nameTerritorioOrden) && Objects.equals(nameTerritorioCliente, OrdenTerritorio.nameTerritorioCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTerritorioOrden, idTerritorioCliente, nameTerritorioOrden, nameTerritorioCliente);
    }


    @Override
    public String toString() {
        return "{" +
            " idTerritorioOrden='" + getIdTerritorioOrden() + "'" +
            ", idTerritorioCliente='" + getIdTerritorioCliente() + "'" +
            ", nameTerritorioOrden='" + getNameTerritorioOrden() + "'" +
            ", nameTerritorioCliente='" + getNameTerritorioCliente() + "'" +
            "}";
    }

}
