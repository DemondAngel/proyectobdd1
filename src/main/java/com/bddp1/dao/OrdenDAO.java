package com.bddp1.dao;

import java.util.List;
import com.bddp1.model.OrdenTerritorio;

public interface OrdenDAO {
    public List<OrdenTerritorio> getCustomerDiffTerritory();

    public int proveProductsOrder(int idSalesOrder, int quantity);

    public int updateProductsOrder(int idSalesOrder, int quantity);

    public int updateOrdenDeliver(int idSalesOrder, int shipMethodID);
}
