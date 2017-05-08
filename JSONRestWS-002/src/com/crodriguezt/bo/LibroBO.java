package com.crodriguezt.bo;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import com.crodriguezt.bean.Libro;

public class LibroBO {

	public List<Libro> agregarLibro(String titulo, String autor, String editorial, String iSBN, String anio) {
		List<Libro> listaLibros = new ArrayList<Libro>();
		Libro l1 = new Libro(titulo, autor, editorial, iSBN, anio);
		System.out.println(l1.toString());
		listaLibros.add(l1);
		grabarXML(listaLibros);
		return listaLibros;
	}

	public boolean grabarXML(List<Libro> listaLibros) {
		Libro l1 = new Libro();
		l1 = listaLibros.get(0);
		File archivo = new File("C:/soft/nuevaBiblioteca.xml");
		// Parsear XML para grabar
		try {
			Element biblioteca = new Element("biblioteca");
			Document documento = new Document(biblioteca);
			documento.setRootElement(biblioteca);
			
			Element libro = new Element("libro");
			libro.addContent(new Element("isbn").setText(l1.getISBN()));
			libro.addContent(new Element("titulo").setText(l1.getTitulo()));
			libro.addContent(new Element("autor").setText(l1.getAutor()));
			libro.addContent(new Element("editorial").setText(l1.getEditorial()));
			libro.addContent(new Element("anio").setText(l1.getAnio()));
			
			documento.getRootElement().addContent(libro);
			
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.output(documento, new FileWriter(archivo));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("******************************");
		System.out.println(l1.getAutor());

		return true;
	}

}
