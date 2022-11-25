package com.bddp1.dao;

import com.bddp1.model.Venta;
import java.util.List;

public interface VentaDAO {
    public List<Venta> getTotalVentasProducto(int category);
}
