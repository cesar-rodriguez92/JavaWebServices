package com.crodriguezt.inout3.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.crodriguezt.inout3.ClienteBean;
import com.crodriguezt.inout3.FoodBean;
import com.crodriguezt.inout3.PrincipalXML;

@Path("/ServiciosCliente")
public class Servicios {
	
	PrincipalXML pxml = new PrincipalXML();
	
	@GET
	@Path("/datosClientes")
	@Produces(MediaType.APPLICATION_XML)
	public List<ClienteBean> getAllClients(){
		return pxml.leerXML();
	}
	
	@GET
	@Path("/menudiario")
	@Produces(MediaType.APPLICATION_XML)
	public List<FoodBean> getmenu(){
		return pxml.leerArchivoXML();
	}
	
	
	

}
