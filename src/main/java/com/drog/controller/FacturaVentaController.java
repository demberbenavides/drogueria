package com.drog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drog.dao.FacturaVentaDAO;
import com.drog.dao.ProductoDAO;
import com.drog.models.FacturaVenta;
import com.drog.models.Producto;


@RestController
public class FacturaVentaController {

	@Autowired
	private FacturaVentaDAO ventaDao;
	
	@Autowired
	private ProductoDAO productoDao;
	
	@Autowired
	private FacturaVentaDAO facturaVentaDAO;
	
	private static Logger LOG = LoggerFactory.getLogger(FacturaVentaController.class);
	
	@PostMapping("/registrarventa")
	public String insert(@RequestBody FacturaVenta venta) {
		LOG.info(venta.getNombrecliente());
		
		Producto producto = productoDao.findByKey(venta.getIdproducto());
		if(producto.getStock() < venta.getCantidad()) {
			return "Cantidad Mayor a Stock:" + producto.getStock();
		}
		
		producto.setStock(producto.getStock() - venta.getCantidad());
		venta.setProducto(producto);
		ventaDao.insert(venta);
		
		return "Ok";
	}

	@RequestMapping(value = "ventas" , method = RequestMethod.GET)
	public List<FacturaVenta> findAll(){
		return facturaVentaDAO.findAll();
	}
	

	
}
