package com.crodriguezt.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.crodriguezt.bean.Libro;
import com.crodriguezt.bo.LibroBO;

@Path("/books")
public class BookService {

	@POST
	@Path("/guardarLibro")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public List<Libro> agregarLibro(@FormParam("titulo") String titulo, @FormParam("autor") String autor, 
			@FormParam("editorial") String editorial, @FormParam("isbn") String iSBN, 
			@FormParam("anio") String anio, @Context HttpServletResponse servletResponse){
		System.out.println("---->Llego al ws ahora invoca BO");
		LibroBO libroBO = new LibroBO();
		return libroBO.agregarLibro(titulo, autor, editorial, iSBN, anio);
	}
}
