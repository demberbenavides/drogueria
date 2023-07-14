package com.drog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.drog.models.FacturaVenta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class FacturaVentaImp implements FacturaVentaDAO{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void insert(FacturaVenta venta) {
		// TODO Auto-generated method stub
		entityManager.merge(venta);
	}
	
	@Override
	public List<FacturaVenta> findAll() {
		String sql = "FROM FacturaVenta ORDER BY id_venta";
		List<FacturaVenta> list = entityManager.createQuery(sql,FacturaVenta.class).setMaxResults(10).getResultList();		
		return list;
	}
	
	//@Query(value = "select idproducto, sum(cantidad) as cantidad  from venta group by idproducto order by cantidad desc ")
	@Override
	public int maxProductoId() {
		String sql = "select idproducto, sum(cantidad) as cantidad  from venta group by idproducto order by cantidad desc ";
		List<Object[]> list =  entityManager.createNativeQuery(sql).setMaxResults(10).getResultList();
		return list.isEmpty() ? 0 : (int)list.get(0)[0];
	}
	
	@Override
	public int minProductoId() {
		String sql = "select idproducto, sum(cantidad) as cantidad  from venta group by idproducto order by cantidad asc ";
		List<Object[]> list =  entityManager.createNativeQuery(sql).setMaxResults(10).getResultList();
		return list.isEmpty() ? 0 : (int)list.get(0)[0];
	}
	
	
	
}
