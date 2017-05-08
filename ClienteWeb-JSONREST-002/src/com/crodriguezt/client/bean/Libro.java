package com.crodriguezt.client.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "libro")
public class Libro {

	private String titulo;
	private String autor;
	private String editorial;
	private String ISBN;
	private String anio;

	public Libro(String titulo, String autor, String editorial, String iSBN, String anio) {
		super();
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

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

}
