package com.drog.dao;

import java.util.List;

import com.drog.models.Producto;

public interface ProductoDAO {

	List<Producto> findAll();
	List<Producto> findWithStock();
	Producto findByKey(int key);
	void edit(Producto producto);
}
 