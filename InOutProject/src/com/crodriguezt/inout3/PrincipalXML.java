package com.crodriguezt.inout3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class PrincipalXML {

	public static void main(String args[]) {
		System.out.println("Lectura y escritura de XML's");
		PrincipalXML pxml = new PrincipalXML();
		pxml.grabarXML();
		System.out.println("***************************************************");
		pxml.imprimirXML(pxml.leerXML());

	}

	public void grabarXML() {
		System.out.println("Grabando archivo XML");
		List<Cliente> clientList = new ArrayList<Cliente>();

		Cliente c1 = new Cliente(1, "Cesar 1", "RT 1", "05/11/1992", "Jr. Orejuelas 1", "Masculino", 24);
		Cliente c2 = new Cliente(2, "Cesar 2", "RT 2", "05/11/1992", "Jr. Orejuelas 2", "Masculino", 25);
		Cliente c3 = new Cliente(3, "Cesar 3", "RT 3", "05/11/1992", "Jr. Orejuelas 3", "Masculino", 26);
		Cliente c4 = new Cliente(4, "Cesar 4", "RT 4", "05/11/1992", "Jr. Orejuelas 4", "Masculino", 27);
		Cliente c5 = new Cliente(5, "Cesar 5", "RT 5", "05/11/1992", "Jr. Orejuelas 5", "Masculino", 28);
		Cliente c6 = new Cliente(6, "Cesar 6", "RT 6", "05/11/1992", "Jr. Orejuelas 6", "Masculino", 29);
		Cliente c7 = new Cliente(7, "Cesar 7", "RT 7", "05/11/1992", "Jr. Orejuelas 7", "Masculino", 30);
		Cliente c8 = new Cliente(8, "Cesar 8", "RT 8", "05/11/1992", "Jr. Orejuelas 8", "Masculino", 31);
		Cliente c9 = new Cliente(9, "Cesar 9", "RT 9", "05/11/1992", "Jr. Orejuelas 9", "Masculino", 32);
		Cliente c10 = new Cliente(10, "Cesar 10", "T 10", "05/11/1992", "Jr. Orejuelas 10", "Masculino", 33);
		Cliente c11 = new Cliente(11, "Cesar 11", "RT 11", "05/11/1992", "Jr. Orejuelas 11", "Masculino", 34);

		clientList.add(c1);
		clientList.add(c2);
		clientList.add(c3);
		clientList.add(c4);
		clientList.add(c5);
		clientList.add(c6);
		clientList.add(c7);
		clientList.add(c8);
		clientList.add(c9);
		clientList.add(c10);
		clientList.add(c11);

		File archivo = new File("C:/Soft/clientes.dat");
		try {
			FileOutputStream fos = new FileOutputStream(archivo);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(clientList);
			oos.close();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Cliente> leerXML() {
		System.out.println("Leyendo archivo XML");
		File archivo = new File("C:/Soft/clientes.dat");
		if (archivo.exists()) {
			try {
				FileInputStream fis = new FileInputStream(archivo);
				ObjectInputStream ois = new ObjectInputStream(fis);
				List<Cliente> listaClientes = new ArrayList<Cliente>();
				listaClientes = (List<Cliente>) ois.readObject();
				System.out.println(listaClientes);
				/*
				 * for(Cliente cliente : listaClientes){ System.out.println(); }
				 */
				return listaClientes;

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Error archivo no existe, imposible recuperar data");
		}
		return null;
	}

	public void imprimirXML(List<Cliente> clientList) {

		try {
			JAXBContext jaxbcontent = JAXBContext.newInstance(Cliente.class);
			Marshaller jaxbmarshaller = jaxbcontent.createMarshaller();
			jaxbmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw = new StringWriter();
			for(Cliente cliente : clientList){
				jaxbmarshaller.marshal(cliente, sw);
				String xmlString = sw.toString();
				System.out.println(xmlString);				
			}


		} catch (JAXBException e) {
			e.printStackTrace();
		}

		
		/*
		 * TransformerFactory tf = TransformerFactory.newInstance(); Document
		 * doc; OutputStream out;
		 * 
		 * try { Transformer transformer = tf.newTransformer();
		 * transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		 * transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		 * transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		 * transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		 * transformer.setOutputProperty(
		 * "{http://xml.apache.org/xslt}indent-amount", "4");
		 * 
		 * transformer.transform(new DOMSource(doc), new StreamResult(new
		 * OutputStreamWriter(out, "UTF-8")));
		 * 
		 * 
		 * } catch (TransformerConfigurationException e) { e.printStackTrace();
		 * } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
		 * catch (TransformerException e) { e.printStackTrace(); }
		 * 
		 */

	}

}
