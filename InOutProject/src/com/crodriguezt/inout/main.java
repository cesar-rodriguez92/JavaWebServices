package com.crodriguezt.inout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class main {

	public static void main(String[] args) {
		//grabarArchivo();
		leerArchivo();

	}
	
	public static boolean grabarArchivo(){
		System.out.println("Grabando archivo");
		try {
			Alumno alumno = new Alumno("0973","Cesar","RT", 24);
			/**Forma 1**/
			File archivo = new File("c://Soft/Alumnos.txt");
			FileOutputStream fos;
			fos =  new FileOutputStream(archivo);
			ObjectOutputStream oos =  new ObjectOutputStream(fos);
			oos.writeObject("guardar este string y un objeto\n");
			oos.writeObject(alumno);
			oos.close();
			
			/**Forma 2**/
			FileWriter nuevoarchivo = new FileWriter("c://Soft/AlumnosNEW.txt");
			PrintWriter pw = new PrintWriter(nuevoarchivo);
			pw.print(alumno);
			nuevoarchivo.close();
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}
	
	public static void leerArchivo(){
		System.out.println("Leyendo archivo");
		try {
			FileReader archivo = new FileReader("c://Soft/AlumnosNEW.txt");
			BufferedReader bufferedreader = new BufferedReader(archivo);
			System.out.println("ReadLine");
			System.out.println("--->" + bufferedreader.readLine());
			System.out.println("Read");
			String linea;
			while ( (linea = bufferedreader.readLine()) !=null  ) {
				System.out.println("--->" + linea);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
