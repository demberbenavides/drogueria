package com.drog.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pedido;
	
	@Column
	private int idproducto;


	@Column
	private int cantidad;


	public int getId_pedido() {
		return id_pedido;
	}


	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
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
	
	
}
