package com.crodriguezt.client.bo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.crodriguezt.client.bean.Libro;

public class ClienteWSBO {

	private static final String RUTA_API_REST = "http://localhost:8080/JSONRestWS-002/apis/books";

	public String getLibro(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Llego a CLiente WS BO");

		String titulo = req.getParameter("titulo").toString().trim();
		String autor = req.getParameter("autor").toString().trim();
		String editorial = req.getParameter("editorial").toString().trim();
		String ISBN = req.getParameter("isbn").toString().trim();
		String anio = req.getParameter("anio").toString().trim();

		System.out.println("--->del request: " + titulo);
		System.out.println("--->del request: " + autor);
		System.out.println("--->del request: " + editorial);
		System.out.println("--->del request: " + ISBN);
		System.out.println("--->del request: " + anio);

		// Cliente Web
		Client cliente = ClientBuilder.newClient();
		WebTarget target = cliente.target(RUTA_API_REST).path("/guardarLibro2");

		Form formulario = new Form();
		formulario.param("isbn", ISBN);
		formulario.param("titulo", titulo);
		formulario.param("autor", autor);
		formulario.param("editorial", editorial);
		formulario.param("anio", anio);
		List<Libro> listaLibros=null;
		//Libro libro = null;
		String respuesta=null ;
		try {
				respuesta =  target.request(MediaType.APPLICATION_JSON)
					.post(Entity.entity(formulario, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
//			for(Libro libro: listaLibros){
//			System.out.println("--->" + libro.getISBN());
//			System.out.println("--->" + libro.getTitulo());
//			System.out.println("--->" + libro.getAutor());
//			System.out.println("--->" + libro.getEditorial());
//			System.out.println("--->" + libro.getAnio());
//			 }
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("***********************");
		return respuesta;

	}
}
