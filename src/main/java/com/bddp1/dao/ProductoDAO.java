package com.bddp1.dao;

import com.bddp1.model.ProductoVendido;

public interface ProductoDAO {
    public ProductoVendido getProdMoreRequested(String territory);

    public int getProductIdtoUpdate(int category);

    public int updateStock(int productID);
}
