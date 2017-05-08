package com.crodriguezt.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.crodriguezt.bean.Persona;

@Path("/Generales")
public class AuthorService {
	
	@GET
	@Path("/autores")
	@Produces(MediaType.APPLICATION_JSON)
	public List getTrackInJSON(){
		List list = new ArrayList();
		Persona p1 = new  Persona(1,"Juan");
		Persona p2 = new  Persona(2,"Francisco");
		Persona p3 = new  Persona(3,"Pedro");
		Persona p4 = new  Persona(4,"Lucas");
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
		return list;
		
	}
	
	@POST
	@Path("/guardar")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public List<Persona> guardarNombres(@FormParam("id") String id, @FormParam("name") String name, 
			@FormParam("lastName") String lastName, @FormParam("age") int age, @Context HttpServletResponse servletRes){
		
		System.out.println("---> id:\t" + id);
		System.out.println("---> name:\t" + name);
		System.out.println("---> lastName:\t" + lastName);
		System.out.println("---> age:\t" + age);
		
		List<Persona> list = new ArrayList<Persona>();
		Persona p1 = new  Persona(1, id);
		Persona p2 = new  Persona(2, name);
		Persona p3 = new  Persona(3, lastName);
		Persona p4 = new  Persona(4, String.valueOf(age));
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
		return list;
	}
	
	@POST
	@Path("/guardarJSON")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> guardarNombresJSON(@FormParam("id") String id, @FormParam("name") String name, 
			@FormParam("lastName") String lastName, @FormParam("age") int age, @Context HttpServletResponse servletRes){
		
		System.out.println("---> id:\t" + id);
		System.out.println("---> name:\t" + name);
		System.out.println("---> lastName:\t" + lastName);
		System.out.println("---> age:\t" + age);
		
		List<Persona> list = new ArrayList<Persona>();
		Persona p1 = new  Persona(1, id);
		Persona p2 = new  Persona(2, name);
		Persona p3 = new  Persona(3, lastName);
		Persona p4 = new  Persona(4, String.valueOf(age));
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
		return list;
	}
	
	
	
	
	

}

