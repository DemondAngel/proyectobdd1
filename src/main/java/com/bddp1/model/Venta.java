package com.bddp1.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Venta{

    private int territoryID;
    private BigDecimal totalVentas;
    private String nameTerritory;
    



    public Venta() {
    }


    public Venta(int territoryID,  BigDecimal totalVentas, String nameTerritory) {
        this.territoryID = territoryID;
        this.nameTerritory = nameTerritory;
        this.totalVentas = totalVentas;
    }


    public int getTerritoryID() {
        return this.territoryID;
    }

    public void setTerritoryID(int territoryID) {
        this.territoryID = territoryID;
    }

    public String getNameTerritory() {
        return this.nameTerritory;
    }

    public void setNameTerritory(String nameTerritory) {
        this.nameTerritory = nameTerritory;
    }

    public BigDecimal getTotalVentas() {
        return this.totalVentas;
    }

    public void setTotalVentas(BigDecimal totalVentas) {
        this.totalVentas = totalVentas;
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Venta)) {
            return false;
        }
        Venta venta = (Venta) o;
        return Objects.equals(territoryID, venta.territoryID) && Objects.equals(nameTerritory, venta.nameTerritory) && totalVentas == venta.totalVentas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(territoryID, nameTerritory, totalVentas);
    }


    @Override
    public String toString() {
        return "{" +
            " territoryID='" + getTerritoryID() + "'" +
            ", nameTerritory='" + getNameTerritory() + "'" +
            ", totalVentas='" + getTotalVentas() + "'" +
            "}";
    }
    
}