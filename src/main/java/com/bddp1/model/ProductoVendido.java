package com.bddp1.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductoVendido{

    private int productID;
    private String nombre;
    private BigDecimal totalVentas;


    public ProductoVendido() {
    }

    public ProductoVendido(int productID, String nombre, BigDecimal totalVentas) {
        this.productID = productID;
        this.nombre = nombre;
        this.totalVentas = totalVentas;
    }

    public int getProductID() {
        return this.productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(o instanceof ProductoVendido)) {
            return false;
        }
        ProductoVendido productoVendido = (ProductoVendido) o;
        return Objects.equals(productID, productoVendido.productID) && Objects.equals(nombre, productoVendido.nombre) && totalVentas == productoVendido.totalVentas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, nombre, totalVentas);
    }

    @Override
    public String toString() {
        return "{" +
            " productID='" + getProductID() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", totalVentas='" + getTotalVentas() + "'" +
            "}";
    }

}