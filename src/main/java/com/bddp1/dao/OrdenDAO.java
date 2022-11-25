package com.bddp1.dao;

import java.util.List;
import com.bddp1.model.OrdenTerritorio;
public interface OrdenDAO {
    public List<OrdenTerritorio> getCustomerDiffTerritory();
    public boolean updateProductsOrder(int idSalesOrder, int quantity);
    public boolean updateOrdenDeliver(int idSalesOrder, int shipMethodID);
}
