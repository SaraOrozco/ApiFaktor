package com.asofi.servrest.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="empleado")
public class Empleado {
	private Long id;
	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
