package com.crodriguezt.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
		Persona p3 = new  Persona(2,"Pedro");
		Persona p4 = new  Persona(2,"Lucas");
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
		return list;
		
	}

}
