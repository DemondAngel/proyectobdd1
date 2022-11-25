package com.bddp1.model;

import java.util.Objects;

class ProductoVendido{

    private Long productID;
    private String nombre;
    private float totalVentas;


    public ProductoVendido() {
    }

    public ProductoVendido(Long productID, String nombre, float totalVentas) {
        this.productID = productID;
        this.nombre = nombre;
        this.totalVentas = totalVentas;
    }

    public Long getProductID() {
        return this.productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTotalVentas() {
        return this.totalVentas;
    }

    public void setTotalVentas(float totalVentas) {
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