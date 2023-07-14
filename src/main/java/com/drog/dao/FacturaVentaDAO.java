package com.drog.dao;

import java.util.List;

import com.drog.models.FacturaVenta;

public interface FacturaVentaDAO {

	void insert(FacturaVenta venta);
	List<FacturaVenta> findAll();
	int maxProductoId();
	int minProductoId();
}
