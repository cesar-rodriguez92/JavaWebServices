package com.crodriguezt.inout2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Principal {

	public static void main(String[] args) {
		Principal p = new Principal();
		p.escribirArchivo();
		p.leerArchivo();

	}
	
	public void escribirArchivo(){
		File archivo = new File("C:/Soft/test2.txt");
		try {
			FileWriter fw = new FileWriter(archivo);
			PrintWriter pw = new PrintWriter(fw);
			pw.print("Pagina de prueba \n");
			pw.println("{\n\t'username': 'cesar1@mail.com', \n\t'name': 'Cesar 1', \n\t'lastName': 'RT 1', \n\t'lastLogin': '10:31:27 AM - 07/05/2017'\n},");
			pw.println("{\n\t'username': 'cesar2@mail.com', \n\t'name': 'Cesar 2', \n\t'lastName': 'RT 2', \n\t'lastLogin': '10:51:27 AM - 07/05/2017'\n},");
			pw.println("{\n\t'username': 'cesar3@mail.com', \n\t'name': 'Cesar 3', \n\t'lastName': 'RT 3', \n\t'lastLogin': '11:01:27 AM - 07/05/2017'\n},");
			pw.println("{\n\t'username': 'cesar4@mail.com', \n\t'name': 'Cesar 4', \n\t'lastName': 'RT 4', \n\t'lastLogin': '11:11:27 AM - 07/05/2017'\n}");
			pw.close();
			fw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void leerArchivo(){
		File archivo = new File("C:/Soft/test2.txt");
		try {
			if(archivo.exists()){
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				System.out.println("Data de archivo empieza aca \n**********************************************************");
				while((linea = br.readLine()) != null){
					System.out.println(linea);
				}
				br.close();
				fr.close();
			}else{
				System.out.println("-----> Archivo no existe");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
