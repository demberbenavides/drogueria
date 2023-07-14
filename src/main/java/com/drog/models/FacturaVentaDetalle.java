package com.drog.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventaitem")
public class FacturaVentaDetalle {
	
	@Id
	@Column
	private int idventa;
	
	@Id
	@Column
	private int idproducto;
	
	@Column
	private int cantidad;

	@Column
	private int valorventa;
	
	
	public int getIdventa() {
		return idventa;
	}
	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getValorventa() {
		return valorventa;
	}
	public void setValorventa(int valorventa) {
		this.valorventa = valorventa;
	}


	
}
