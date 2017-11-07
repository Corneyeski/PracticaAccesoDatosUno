package Ejemplos.CargarAlumnos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CargarAlumnosDesdeFichero {

	static final String fichero = "alumnos.txt";
	static List<Alumno> alumnos = new ArrayList<>();	
	
	public static void main(String[] args) {
		alumnos = cargarAlumnos();
		alumnos.forEach(e->System.out.println(e));
		//alumnos.forEach(System.out::println);		
	}

	private static List<Alumno> cargarAlumnos() {
		List<Alumno> alumnosTmp = new ArrayList<>();
		FileReader fr = null;
		BufferedReader bfr = null;
		try {
			fr = new FileReader(fichero);
			bfr = new BufferedReader(fr);
			String linea = "";		
			
			while ( (linea = bfr.readLine()) != null) {
				Alumno al = procesarLinea(linea);
				alumnosTmp.add(al);
			};
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bfr != null)
				try {
					bfr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}		
		
		return alumnosTmp.isEmpty() ? 
				Collections.<Alumno>emptyList() : alumnosTmp;
	}

	private static Alumno procesarLinea(String linea) {
		String[] campos = linea.split("#");
		String apellidos = campos[0];
		String nombre = campos[1];
		int edad = Integer.parseInt(campos[2]);
		return new Alumno(apellidos, nombre, edad);
	}
}