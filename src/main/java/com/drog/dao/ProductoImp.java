package com.drog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.drog.models.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
@Transactional
public class ProductoImp implements ProductoDAO{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Producto> findAll() {
		String sql = "FROM Producto ORDER BY nombreproducto";
		return entityManager.createQuery(sql,Producto.class).setMaxResults(10).getResultList();		
	}

	@Override
	public List<Producto> findWithStock() {
		String sql = "FROM Producto WHERE stock > 0 ORDER BY nombreproducto";
		return entityManager.createQuery(sql,Producto.class).setMaxResults(10).getResultList();
	}

	@Override
	public Producto findByKey(int key) {
		return entityManager.find(Producto.class, key);
	}
	
	public void edit(Producto producto) {
		entityManager.merge(producto);		
	}
	
	

}
