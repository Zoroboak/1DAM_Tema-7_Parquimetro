package parquimetro;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class fichero {
	

	/*
	 * Programa Parquimetro
	 * 
	 * Autores: 
	 * 
	 * David Garcia Berbejo
	 * Andres Valdearcos
	 * Elias Prieto Parrilla
	 * Pedro Daniel Pérez Sánchez
	 * 
	 * Programa que simula el funcionamiento de X parquimetros
	 * 
	 * 
	 * 
	 * */

	public static void main(String[] args) {
	
		
	try {
		escribirFichero(22, 500, 200);
		
		System.out.println("Parece que no ha fallado");
	}catch(Exception e) {
		System.out.println("La clase fichero a fallado");
		e.printStackTrace();
	}
	
	
	}
	
	public static void escribirFichero(long ID,double totalrecaudado,double totalalquilado) {
		
		//obtener la fecha a través de Gregorian calendar
		Calendar c1 = GregorianCalendar.getInstance();
		//obtengo un conversor que permite pasar calendar a String
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//le formateo para obtener un String a través de la fecha
		String fecha =sdf.format(c1.getTime());
		// esto es simplemente para comprobar que la saca bien
		System.out.println("fecha actual: "+fecha);
	
		//nombre del fichero
		String  nombrefichero ="reporte_"+fecha+".txt";
		
		FileWriter fw = null;
		PrintWriter pw = null;
		File file = new File (nombrefichero);
		
		
		// si el fichero existe escribira el ID el total recaudado y el total alquilado y si no existe añade la cabecera
		if(file.exists()){
			try {
				fw=new FileWriter(nombrefichero, true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw=new PrintWriter (fw);
			pw.println(ID+","+totalrecaudado+","+totalalquilado);
			
		
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			try {
				fw=new FileWriter(nombrefichero);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw=new PrintWriter(fw);
			pw.println("ID,total recaudado,horas \n");
			pw.println(ID+","+totalrecaudado+","+totalalquilado);
			
		
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
		
		}
		
	}
