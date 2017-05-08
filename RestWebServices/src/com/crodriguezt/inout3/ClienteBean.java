package com.crodriguezt.inout3;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cliente")
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idcliente;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String direccion;
	private String sexo;
	private int edad;

	public ClienteBean() {
	}

	public ClienteBean(int idcliente, String nombre, String apellido, String fechaNacimiento, String direccion, String sexo,
			int edad) {
		this.idcliente = idcliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.sexo = sexo;
		this.edad = edad;
	}

	public int getIdcliente() {
		return idcliente;
	}

	@XmlElement
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}

	@XmlElement
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	@XmlElement
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	@XmlElement
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	@XmlElement
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getSexo() {
		return sexo;
	}

	@XmlElement
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	@XmlElement
	public void setEdad(int edad) {
		this.edad = edad;
	}

}