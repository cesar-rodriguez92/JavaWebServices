package com.crodriguezt.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Libro {
	
	private String titulo;
	private String autor;
	private String editorial;
	private String ISBN;
	private String anio;
	
	
	public Libro(String titulo, String autor, String editorial, String iSBN, String anio) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		ISBN = iSBN;
		this.anio = anio;
	}

	public Libro() {
	}
	
	public String getTitulo() {
		return titulo;
	}
	@XmlElement
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	@XmlElement
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	@XmlElement
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getISBN() {
		return ISBN;
	}
	@XmlElement
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getAnio() {
		return anio;
	}
	@XmlElement
	public void setAnio(String anio) {
		this.anio = anio;
	}
	
	

}
