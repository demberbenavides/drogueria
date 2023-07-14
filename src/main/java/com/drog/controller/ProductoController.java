package com.drog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drog.dao.FacturaVentaDAO;
import com.drog.dao.ProductoDAO;
import com.drog.models.FacturaVenta;
import com.drog.models.Pedido;
import com.drog.models.Producto;

@RestController
public class ProductoController {

	@Autowired
	private ProductoDAO prodDao;
	@Autowired
	private FacturaVentaDAO ventaDao;
	
	private static Logger LOG = LoggerFactory.getLogger(ProductoController.class);
	
	@RequestMapping(value = "listproductos")
	public List<Producto> findAll(){
		return prodDao.findAll();
	}
	
	@RequestMapping(value = "productomax" , method = RequestMethod.GET)
	public Producto max(){		
		int idprod = ventaDao.maxProductoId();
		Producto prd = prodDao.findByKey(idprod);
		return prd;
	}
	
	@RequestMapping(value = "productomin" , method = RequestMethod.GET)
	public Producto min(){		
		int idprod = ventaDao.minProductoId();
		Producto prd = prodDao.findByKey(idprod);
		return prd;
	}
	
	@RequestMapping(value = "realizarpedido" , method = RequestMethod.POST)
	public void pedido(@RequestBody Pedido pedido){		
		Producto prd = prodDao.findByKey(pedido.getIdproducto());
		prd.setStock(prd.getStock() + pedido.getCantidad());
		prodDao.edit(prd);
	}
	
}
