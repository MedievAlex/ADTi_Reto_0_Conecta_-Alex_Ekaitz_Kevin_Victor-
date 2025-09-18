package utilidades;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Utilidades {
	/*********************************************************************************************************/	
	public static int calculoFichero(File fich){
		int cont = 0;

		if (fich.exists()){
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			try{
				fis = new FileInputStream(fich);
				ois = new ObjectInputStream(fis);
				Object aux = ois.readObject();
				while (aux != null){
					cont++;
					aux = ois.readObject();
				}
			}catch(EOFException e1){
				//	System.out.println("Has acabado de leer, tienes "+cont+" objetos");
			}catch (Exception e2){
				e2.printStackTrace();
			}
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar los flujos");
			}
		}
		return cont;
	}
	/*********************************************************************************************************/
	//Convierte la fecha introducida en un String y la devuelve
	public static String fechaToString(LocalDate fecha) { 
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String wfecha;

		wfecha = fecha.format(formateador);
		return wfecha;
	}
	/*********************************************************************************************************/
	//Lee la fecha en formato Dia/Mes/Año y la devuelve
	public static LocalDate leerFechaDMA() { 
		boolean error;
		LocalDate date = null;
		String dateString;
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		do{
			error = false;
			dateString = introducirCadena();
			try{
				date = LocalDate.parse(dateString, formateador);
			}catch(DateTimeParseException e){
				System.err.println("[ERROR] Formato de fecha incorrecto.");
	            System.out.print("Introduce una fecha en formato DD/MM/AAAA: ");
				error = true;
			}
		}while (error);
		return date;
	}
	/*********************************************************************************************************/
	//Lee la fecha en formato Año/Mes/Dia y la devuelve
	public static LocalDate leerFechaAMD() { 
		boolean error;
		LocalDate date = null;
		String dateString;
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		do{
			error = false;
			dateString = introducirCadena();
			try{
				date = LocalDate.parse(dateString, formateador);
			}catch(DateTimeParseException e){
				System.err.println("[ERROR] Formato de fecha incorrecto.");
	            System.out.print("Introduce una fecha en formato AAAA/MM/DD: ");
				error = true;
			}
		}while (error);
		return date;
	}
	/*********************************************************************************************************/
	//Lee la fecha en formato Dia/Mes/Año y comprueba si es posterior
	public static LocalDate leerFechaDMAAnterior(LocalDate fecha) {
	    boolean error;
	    LocalDate date = null;
	    String dateString;
	    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    
	    do {
	        error = false;
	        dateString = introducirCadena();	        
	        try {
	            date = LocalDate.parse(dateString, formateador);	            
	            if (date.isAfter(fecha)) {
	            	System.err.println("[ERROR] La fecha no puede ser posterior a "+fecha.format(formateador)+".");
	                System.out.print("Introduce una fecha valida: ");
	                error = true;
	            }	            
	        } catch (DateTimeParseException e) {
	        	System.err.println("[ERROR] Formato de fecha incorrecto.");
	            System.out.print("Introduce una fecha en formato DD/MM/AAAA: ");
	            error = true;
	        }
	    } while (error);	    
	    return date;
	}
	/*********************************************************************************************************/	
	//Lee la fecha en formato Dia/Mes/Año y comprueba si es anterior
	public static LocalDate leerFechaDMAPosterior(LocalDate fecha) {
	    boolean error;
	    LocalDate date = null;
	    String dateString;
	    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    
	    do {
	        error = false;
	        dateString = introducirCadena();    
	        try {
	            date = LocalDate.parse(dateString, formateador);	            
	            if (date.isBefore(fecha)) {
	                System.err.println("[ERROR] La fecha no puede ser anterior a "+fecha.format(formateador)+".");
	                System.out.print("Introduce una fecha valida: ");
	                error = true;
	            }
	        } catch (DateTimeParseException e) {
	            System.err.println("[ERROR] Formato de fecha incorrecto.");
	            System.out.print("Introduce una fecha en formato DD/MM/AAAA: ");
	            error = true;
	        }
	    } while (error);
	    return date;
	}
	/*********************************************************************************************************/
	//Lee la fecha en formato Año/Mes/Dia y comprueba si es posterior
	public static LocalDate leerFechaAMDPosterior(LocalDate fecha) {
		boolean error;
		LocalDate date = null;
		String dateString;
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		do{
			error = false;
			dateString = introducirCadena();			
			try {
				date = LocalDate.parse(dateString, formateador);				
				if (date.isBefore(fecha)) {
	            	System.err.println("[ERROR] La fecha no puede ser posterior a "+fecha.format(formateador)+".");
	                System.out.print("Introduce una fecha valida: ");
	                error = true;
	            }
			} catch (DateTimeParseException e) {
	            System.err.println("[ERROR] Formato de fecha incorrecto.");
	            System.out.print("Introduce una fecha en formato AAAA/MM/DD: ");
				error = true;
			}
		} while (error);		
		return date;
	}
	/*********************************************************************************************************/
	//Lee la fecha en formato Año/Mes/Dia y comprueba si es anterior
	public static LocalDate leerFechaAMDAnterior(LocalDate fecha) {
		boolean error;
		LocalDate date = null;
		String dateString;
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		do{
			error = false;
			dateString = introducirCadena();
			
			try {
				date = LocalDate.parse(dateString, formateador);
				
				if (date.isAfter(fecha)) {
	                System.err.println("[ERROR] La fecha no puede ser anterior a "+fecha.format(formateador)+".");
	                System.out.print("Introduce una fecha valida: ");
	                error = true;
	            }

			} catch (DateTimeParseException e) {
	            System.err.println("[ERROR] Formato de fecha incorrecto.");
	            System.out.print("Introduce una fecha en formato AAAA/MM/DD: ");
				error = true;
			}
		} while (error);
		
		return date;
	}
	/*********************************************************************************************************/
	//Lee un caracter(char) y lo devuelbe
	public static char leerChar() { 
		char letra = ' ';
		String cadena;
		boolean error;

		do{
			error = false;
			cadena = introducirCadena();
			if (cadena.length() != 1){
				System.err.println("[ERROR] Valor no valido.");
				System.out.print("Introduce un único caracter: ");
				error = true;
			}
		}while (error);
		letra = cadena.charAt(0);
		return letra;
	}
	/*********************************************************************************************************/
	//Lee un caracter(char) y controla que lo introducido sea una de los opciones
	public static char leerChar(char opt1, char opt2) { 
		char letra = ' ';
		String cadena;
		boolean error;

		do{
			error = false;
			cadena = introducirCadena();
			if (cadena.length() != 1){
				System.err.println("[ERROR] Valor no valido.");
				System.out.print("Introduce un único caracter: ");
				error=true;
			}
			else{
				letra=cadena.charAt(0);
				letra=Character.toUpperCase(letra);
				if (letra != opt1 && letra != opt2){
					System.err.println("[ERROR] La opcion introducida no es correcta.");
					System.out.print("Introduce "+opt1+" o "+opt2+": ");
					error = true;
				}
			}
		}while (error);
		return letra;
	}
	/*********************************************************************************************************/
	//Lee un numero(float) y lo devuelve
	public static float leerFloat() { 
		float num = 0;
		boolean error;

		do{
			error = false;
			try{
				num = Float.parseFloat(introducirCadena());
			}catch (NumberFormatException e){
				System.err.println("[ERROR] Valor no numerico.");
				System.out.print("Introduce de nuevo: ");
				error = true;
			}
		}while (error);
		return num;
	}
	/*********************************************************************************************************/
	//Lee un numero(float) entre el rango dado y lo devuelve
	public static float leerFloat(float min, float max) { //
		float num = 0;
		boolean error;

		do{
			error = false;
			try{
				num = Float.parseFloat(introducirCadena());
			}catch (NumberFormatException e){
				System.err.println("[ERROR] Valor no numerico.");
				System.out.print("Introduce de nuevo: ");
				error = true;
				num = min;
			}
			if(num<min || num>max){
				System.err.println("[ERROR] Numero fuera de rango.");
				System.out.print("Introduce numero entre "+ min+" y "+max+": ");
				error = true;
			}
		}while (error);
		return num;
	}
	/*********************************************************************************************************/
	//Muestra el mensaje y luego lee el numero(float) introducido si es entre los valores
	public static float leerFloat(String message, float min, float max) { 
		float num = 0;
		boolean error;

		System.out.println(message);
		do{
			error = false;
			try{
				num = Float.parseFloat(introducirCadena());
			}catch (NumberFormatException e){
				System.err.println("[ERROR] Valor no numerico.");
				System.out.print("Introduce de nuevo: ");
				error = true;
				num = min;
			}
			if(num<min || num>max){
				System.err.println("[ERROR] Numero fuera de rango.");
				System.out.print("Introduce numero entre "+min+" y "+max+": ");
				error = true;
			}
		}while (error);
		return num;
	}	
	/*********************************************************************************************************/
	//Muestra el mensaje y luego lee el numero(int) introducido si es entre los valores y lo devuelve
	public static int leerInt(String message, int min, int max) { 
		int num = 0;
		boolean error;

		System.out.println(message);
		do{
			error = false;
			try{
				num = Integer.parseInt(introducirCadena());
			}catch (NumberFormatException e){
				System.err.println("[ERROR] Valor no numerico.");
				System.out.print("Introduce de nuevo: ");
				error = true;
				num = min;
			}
			if(num<min || num>max){
				System.err.println("[ERROR] Numero fuera de rango.");
				System.out.print("Introduce un numero entre "+ min+" y "+max+": ");
				error = true;
			}
		}while (error);
		return num;
	}
	/*********************************************************************************************************/
	//Lee un numero(int) entre el rango dado y lo devuelve
	public static int leerInt(int min, int max) { 
		int num = 0;
		boolean error;

		do{
			error = false;
			try{
				num = Integer.parseInt(introducirCadena());
			}catch (NumberFormatException e){
				System.err.println("[ERROR] Valor no numerico.");
				System.out.print("Introduce de nuevo: ");
				error = true;
				num = min;
			}
			if(num<min || num>max){
				System.err.println("[ERROR] Numero fuera de rango.");
				System.out.print("Introduce un numero entre "+min+" y "+max+": ");
				error = true;
			}
		}while (error);
		return num;
	}
	/*********************************************************************************************************/
	//Lee un numero(int)y lo devuelve
	public static int leerInt() { 
		int num = 0;
		boolean error;

		do{
			error = false;
			try{
				num = Integer.parseInt(introducirCadena());
			}catch (NumberFormatException e){
				System.err.println("[ERROR] Valor no numerico.");
				System.out.print("Introduce de nuevo: ");
				error = true;
			}
		}while (error);
		return num;
	}
	/*********************************************************************************************************/
	//Lee una cadena(String) y la devuelve
	public static String introducirCadena() { 
		String cadena = "";
		boolean error;
		InputStreamReader entrada = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(entrada);

		do{
			error = false;
			try {
				cadena = teclado.readLine();
			} catch (IOException e) {
				System.err.println("[ERROR] Error en la entrada de datos.");
				error = true;
			}
		}while (error);
		return cadena;
	}
	/*********************************************************************************************************/
	//Lee una cadena(String) y controla que lo introducido sea una de los opciones
	public static String introducirCadena(String palabra1,String palabra2) {
		String cadena = "";
		boolean error;
		InputStreamReader entrada = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(entrada);
		
		do{
			error = false;
			try {
				System.out.println("Introduce una opción ("+palabra1+" o "+palabra2+"):");
				cadena = teclado.readLine();
				cadena = cadena.trim().toUpperCase();
				if (!cadena.equalsIgnoreCase(palabra1) && !cadena.equalsIgnoreCase(palabra2)){
					System.err.println("[ERROR] La opcion introducida no es correcta");
					System.out.print("Introduce "+palabra1+" o "+palabra2+": ");
					error = true;
				}
			} catch (IOException e) {
				System.err.println("[ERROR] Error en la entrada de datos.");
				error = true;
			}
		}while (error);
		return cadena;
	}
	/*********************************************************************************************************/
	//Lee un numero(double) y lo devuelve
	public static double leerDouble() { 
		double num = 0;
		boolean error;

		do{
			error = false;
			try{
				num = Double.parseDouble(introducirCadena());
			}catch (NumberFormatException e){
				System.err.println("[ERROR] Valor no numerico.");
				System.out.print("Introduce de nuevo: ");
				error = true;
			}
		}while (error);
		return num;
	}
	/*********************************************************************************************************/
	//Lee un numero(double) entre el rango dado y lo devuelve
	public static double leerDouble(double min, double max) { //
		double num = 0;
		boolean error;

		do{
			error = false;
			try{
				num = Double.parseDouble(introducirCadena());
			}catch (NumberFormatException e){
				System.err.println("[ERROR] Valor no numerico.");
				System.out.print("Introduce de nuevo: ");
				error = true;
				num = min;
			}
			if(num<min || num>max){
				System.err.println("[ERROR] Numero fuera de rango.");
				System.out.print("Introduce uno entre "+min+" y "+max+": ");
				error = true;
			}
		}while (error);
		return num;
	}
	/*********************************************************************************************************/
	//Muestra el mensaje y luego lee el numero(double) introducido si es entre los valores y lo devuelve
	public static double leerDouble(String message, double min, double max) { 
		double num = 0;
		boolean error;

		System.out.println(message);
		do{
			error = false;
			try{
				num = Double.parseDouble(introducirCadena());
			}catch (NumberFormatException e){
				System.err.println("[ERROR] Valor no numerico.");
				System.out.print("Introduce de nuevo: ");
				error = true;
				num = min;
			}
			if(num<min || num>max){
				System.err.println("[ERROR] Numero fuera de rango.\nIntroduce numero entre "+min+" y "+max+": ");
				System.out.print("Introduce numero entre "+min+" y "+max+": ");
				error = true;
			}
		}while (error);
		return num;
	}
	/*********************************************************************************************************/
}