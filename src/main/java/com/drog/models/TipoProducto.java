package com.drog.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipoproducto")
public class TipoProducto {
	
	@Id
	@Column
	private int id_tipoproducto;
	@Column
	private String nombretipo;
	
	
	public int getId_tipoproducto() {
		return id_tipoproducto;
	}
	public void setId_tipoproducto(int id_tipoproducto) {
		this.id_tipoproducto = id_tipoproducto;
	}
	public String getNombretipo() {
		return nombretipo;
	}
	public void setNombretipo(String nombretipo) {
		this.nombretipo = nombretipo;
	}
	
	

}
