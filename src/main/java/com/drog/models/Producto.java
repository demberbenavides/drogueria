package com.drog.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_producto;
	
	@Column
	private String nombreproducto;
	@Column
	private int valor;
	@Column
	private int stock;
	@Column
	private int stockminimo;
	@Column
	private int tipoproducto;
	
	
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombreproducto() {
		return nombreproducto;
	}
	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getStockminimo() {
		return stockminimo;
	}
	public void setStockminimo(int stockminimo) {
		this.stockminimo = stockminimo;
	}
	public int getTipoproducto() {
		return tipoproducto;
	}
	public void setTipoproducto(int tipoproducto) {
		this.tipoproducto = tipoproducto;
	}
	
	

}
