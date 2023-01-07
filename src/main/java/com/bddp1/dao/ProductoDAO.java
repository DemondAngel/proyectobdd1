package com.bddp1.dao;

import com.bddp1.model.ProductoVendido;

public interface ProductoDAO {
    public ProductoVendido getProdMoreRequested(String territory);

    public void getProductIdtoUpdate(int category);

}
