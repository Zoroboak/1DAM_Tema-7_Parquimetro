package parquimetro;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class parquimetro {
	
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
	
	
	//Atributos Globales
	
		//De Clase
	public long idcount = 0; 
	
		//De instancia
	public long id = 0;
	public double dineroTotal = 0; 
	public double tiempoTotal = 0;
	

	//Metodo: pedirle datos al usuario
	public static String getDato(String text,int parametro) {
			/*
			 * Parametro 1: Metodo devuelve un numero dado por el usuario
			 * en el rango [0-5] 
			 * 
			 * Parametro 2: Devuelve la siguiente palabra introducida por el usuario
			 * 
			 * Parametro 3: Metodo devuelve un numero dado por el usuario
			 * en el rango [0-9]
			 * 
			 * Parametro 4: Devuelve varias palabras en un String
			 * 
			 * Parametro 5: Devuelve un valor numerico dado por el usuario en un string
			 * 
			 * El metodo muestra por pantalla el texto que le pasemos 
			 * devuelve un string con la salida validada según el parametro pasado
			 * 
			 * */
			
			
			//Variables locales del metodo
			String auxs = "-"; //Variable auxiliar que almacena un strings
			char auxc = '0'; //Variable auxiliar que almacena un caracter
			int aux = 0; //Variable auxiliar que almacena un valor entero
			boolean v = false; //Flag que marca si el valor es valido o no
			
			//Declaro el objeto Scanner
			Scanner t = new Scanner(System.in);
			
			switch(parametro) {
			case 1: //Valor a solicitar: Entero positivo del 1 al 5
				do {
					
					try {
						//Doy por supuesto que el valor introducido es correcto
						v = true; 
						
						//Mostrar texto pasado por pantalla
						System.out.print(text);
						//Pido un numero entero
						aux = t.nextInt();
						
						
						//Si el rango no es correcto, repetimos el while
						if((aux<0)||(aux>5)) {
							System.out.println("Debes introducir un numero en el rango [0-9]");
							v=false;
						}
					}
					catch(Exception e){
						System.out.println("¡El caracter introducido no es valido!");
						t.next();
						v=false;
					}
				}while(!v);
				
				auxs = Integer.toString(aux);
				break;
			case 2: //Valor a solicitar: Palabra introducida por el usuario
				do {
					
					try {
						//Doy por supuesto que el valor introducido es correcto
						v = true; 
						
						//Mostrar texto pasado por pantalla
						System.out.println(text);
						//Pido una Palabra entre 3 y 15 caracteres
						auxs = t.next();
						
						//Si el rango no es correcto, repetimos el while
						if(auxs.length()<3||auxs.length()>15) {
							System.out.println("Debes introducir una palabra entre 3 y 15 caracteres");
							v=false;
						}
						//Si hay un numero, lo volvemos a pedir
						for (int i = 0; i < auxs.length(); i++) {
							if((auxs.charAt(i)>=48)&&(auxs.charAt(i)<=57)) {
								i=auxs.length();
								System.out.println("Debes introducir una palabra entre 3 y 15 caracteres, no numeros");
								v=false;
								
							}
						}
						
						
					}
					catch(Exception e){
						System.out.println("¡La palabra introducida no es valida!");
						t.next();
						v=false;
					}
				}while(!v);
				
				break;
			case 3: //Devuelve un Caracter del 0 al 9 en String 
				do {
					
					try {
						//Doy por supuesto que el valor introducido es correcto
						v = true; 
						
						//Mostrar texto pasado por pantalla
						System.out.println(text);
						//Pido una Palabra y me quedo con la primera letra
						auxs = t.next();
						
						auxc = auxs.charAt(0);
						
						//Si el rango no es correcto, repetimos el while
						//if((auxc<49||auxc>57)||((auxc!='c')&&(auxc!='v'))) {
						if(auxc<48||auxc>57) {
							System.out.println("Debes introducir una moneda (1-8), '9'=(Validar) o '0'=(Cancelar)");
							v=false;
						}
						
						//Nos aseguramos que el valor de auxs sea solo un caracter
						auxs = ""+auxc;
						
						
					}
					catch(Exception e){
						System.out.println("¡El numero introducido no es valido!!");
						t.next();
						v=false;
					}
				}while(!v);
				break;
			case 4: //Parametro 4: Devuelve varias palabras en un String 
				do {
					
					try {
						//Doy por supuesto que el valor introducido es correcto
						v = true; 
						
						//Mostrar texto pasado por pantalla
						System.out.println(text);
						//Guardo la siguiente linea completa
						auxs = t.nextLine();
						
						//Si el rango no es correcto, repetimos el while
						if(auxs.length()<2) {
							System.out.println("Debes introducir un minimo de 2 caracteres para este elemento");
							v=false;
						}
						
					}
					catch(Exception e){
						System.out.println("¡El texto introducida no es valido!");
						t.next();
						v=false;
					}
				}while(!v);
				
				break;
				
			case 5: //Parametro 5: Devuelve un valor numerico dado por el usuario en un string
				do {
					
					try {
						//Doy por supuesto que el valor introducido es correcto
						v = true; 
						
						//Mostrar texto pasado por pantalla
						System.out.println(text);
						//Guardo la siguiente linea completa
						aux = t.nextInt();
						
						//Si el rango no es correcto, repetimos el while
						if(aux<=-1) {
							System.out.println("Debes introducir un valor positivo");
							v=false;
						}
						
					}
					catch(Exception e){
						System.out.println("¡El valor introducido no es valido!");
						t.next();
						v=false;
					}
				}while(!v);
				
				auxs = Integer.toString(aux);
				
				break;
			
			}
			
			
			
			//Devuelvo un String
			return auxs;
		}
	
	//############################################ ANDRES ###############################
	
	//Metodos Andres
	
	/* VARIABLES INSTANCIA
	 -----------------------------------------------------------------------------------------------------------------------------------
	 * double [] monedas -> Almacena el valor de cada moneda.
	 ---------------------------------------------------------------------------------------------
	 * int [] cantidad_parqui -> Almacena la cantidad de monedas disponibles en caja de cada moneda.
	 --------------------------------------------------------------------------------------------------------------
	 *int [] cantidad_parqui_du -> Duplicado de cantidad_parqui para almacenar temporalmente la resta de monedas
	 							   de caja para ver si es posible devolver el cambio.	
	 --------------------------------------------------------------------------------------------------------------------------------------------
	 *int [] cantidad_introducida -> Almacena las monedas que va metiendo el usuario.
	 --------------------------------------------------------------------------------------------------------------------------------
	 *int [] cantidad_camb -> Almacena la cantidad de cada moneda que se puede devolver como cambio.
	 -------------------------------------------------------------------------------------------------------------
	 *int id_parqui -> Para cuando se cree un nuevo parquimetro.
	 ----------------------------------------------------------------------------------------------------------------
	 *boolean validar -> Cambia a true cuando se ha pulsado la opciÃ³n validar para salir del bucle.
	 ---------------------------------------------------------------------------------------------------------------
	 *int comprobar -> Almacena el retorno de comprobar_introducida (ver retorno el metodo)
	 ---------------------------------------------------------------------------------------------------------------
	 *boolean pasa -> Cambia a false cuando la moneda introducida mÃ¡s el saldo actual supera el mÃ¡ximo 
	         		  (pero no antes de sumarle dicha moneda). Cuando cambia, devuelve las prÃ³ximas monedas.		
	 ---------------------------------------------------------------------------------------------------------------
	 *double suma_saldo_user -> Va sumando el saldo de las monedas que van metiendo.
	 ---------------------------------------------------------------------------------------------------------------
	 *double dev -> Cantidad de saldo que se le debe/deberia devolver al usuario.
	 ---------------------------------------------------------------------------------------------------------------
	 *double max -> Maximo de dinero permitido por usuario: 2.05
	 ---------------------------------------------------------------------------------------------------------------
	 */
	
	private  double []monedas = {0.05,0.10,0.20,0.50,1,2};
	private  int []cantidad_parqui =  {10,10,10,3,0,0};  
	private  int []cantidad_parqui_du = cantidad_parqui;    
	private  int []cantidad_introducida = {0,0,0,0,0,0};  
	private  int []cantidad_camb = {0,0,0,0,0,0}; 
	private  boolean validar = false;  
	private  int comprobar=0;
	private  boolean pasa = true;
	private  double suma_saldo_user = 0;   
	private  double dev = 0; 
	private final double max = 2.05;
	
	
	/*
	 * METODO: FESTIVO
	 * DESCRIPCIÃ“N: METODO PARA COMPROBAR SI EL DIA ES FESTIVO O NO.
	 * Entrada -> void
	 * Salida -> boolean-> devuelve true si es festivo y false si no lo es.
	 */
	
	public boolean festivo() {
		
		
		/*
		 * VARIABLES LOCALES
		 * Calendar fecha -> variable para poder ver mes y dia.
		 * int mes -> Almacena el mes actual.
		 * int dia -> Almacena el dia actual.
		 */
		
		Calendar fecha = Calendar.getInstance();
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
		
        //busca en estos bucles si el dia es festivo.
        if(dia == 7) {
        	return true;
        }
        if(dia == 1 && mes == 1)
        	return true;
        else if(dia == 6 && mes == 1)
        	return true;
        else if(dia == 1 && mes == 5)
        	return true;
        else if(dia == 12 && mes == 6)
        	return true;
        else if(dia == 15 && mes == 8)
        	return true;
        else if(dia == 8 && mes == 9)
        	return true;
        else if(dia == 12 && mes == 10)
        	return true;
        else if(dia == 1 && mes == 11)
        	return true;
        else if(dia == 6 && mes == 12)
        	return true;
        else if(dia == 8 && mes == 12)
        	return true;
        else if(dia == 25 && mes ==12)
        	return true;
        else
        	return false;
 			
	}
	
	/*
	 * METODO : DEVOLVER
	 * DESCRIPCIÃ“N : MÃ©todo que es llamado cuando se ha pulsado cancelar dos veces 
	  				  en el metodo matricula(se ha dado a ingresar primero y despues a matricula.)
	 * Entradas -> void
	 * Salida -> void
	 */
	
	
	public void devolver() {
		
		System.out.println("Se ha devuelto lo siguiente: ");
		for(int i = 0; i < cantidad_introducida.length; i++) {
			
			if(cantidad_introducida[i]!=0) {
				System.out.println(cantidad_introducida[i]+" moneda/s de "+monedas[i]+" â‚¬");
			}
			cantidad_parqui[i] -= cantidad_introducida[i] + cantidad_camb[i]; 
			cantidad_introducida[i] = 0;
			
		}
		
	}
	
	/*
	 * METODO : INGRESAR
	 * DESCRIPCIÃ“N: MÃ©todo que conlleva la acciÃ³n de cuando se introducen monedas o se pulsa validar o cancelar.
	 * Entradas -> opc-> 
	  					0-> cancelar
	  					1-> monedas 0.01 â‚¬
	  					2-> monedas 0.02 â‚¬
	  					3-> monedas 0.05 â‚¬
	  					4-> monedas 0.10 â‚¬
	  					5-> monedas 0.20 â‚¬
	  					6-> monedas 0.50 â‚¬
	  					7-> monedas 1.00 â‚¬
	  					8-> monedas 2.00 â‚¬
	  					9-> validar
	 		      pas -> Recibe un false si primero se ha llamado al metodo matricula y un true si no.
	 * Salidas -> double []Â vect -> tiene dos posiciones->
	 								vect[0] -> retorna el saldo 
	  								vect[1] -> devuelve un 1.00 si ha cancelado y un 2.00 si ha aceptado.
	 */
	
	public double[] ingresar(int opc, boolean pas){
		
		/*
		 * VARIABLES LOCALES
		 * double []vect -> explicado justo arriba.
		 * boolean segunda -> pasa a true cuando es la segunda vez que se pide una opcion.
		 */
		
		Scanner sc = new Scanner(System.in);
		double[] vect= new double[2];
		boolean segunda;
		segunda = false;
		
		//bucle que se repite mientras que opc no sea igual a validar o cancelar.
		try {
			do {	
				try {
					if(segunda == true) {
						try {
							System.out.println("Introduce otra Moneda: ");
							System.out.println("Tambien puede pulsar 9 para Validar o 0 para Cancelar");
							opc = sc.nextInt();
							System.out.println();
						}
						catch(Exception e) {
							e.getMessage();
						}
					}
				}
				catch(Exception e) {
					e.getMessage();
				}
				
				segunda = true;
				
				try {
					switch(opc) {
					
						
						case 0: //OPCION CANCELAR
							
							vect[1]=2.00;
							
							//bucle para dejar como estaba al cancelar.
							for(int i = 0; i < cantidad_introducida.length; i++) {
								
								cantidad_introducida[i] = 0;
								cantidad_camb[i] = 0;
								cantidad_parqui_du[i] = cantidad_parqui[i];
							}
							System.out.println("Se ha cancelado la operación. Dinero devuelto: "+(double)Math.round(suma_saldo_user * 100d) / 100d+" â‚¬");
							
							//restablecemos el saldo del usuario introducido.
							suma_saldo_user = 0;
							
						break;
					
						case 1:
							
							System.out.println("Las monedas de 0.01 no están permitidas.");
							
							break;
							
						case 2:
							
							System.out.println("Las monedas de 0.02 no están permitidas.");
							
							break;	
							
							
						case 3:
							
							/*comprobamos que el retorno del metodo comprobar_introducida.
							 * 	si es igual a 1 -> suma la moneda porque no ha llegado al tope.
							 * 	si es igual a 2 -> suma la moneda pero con esta ya se ha superado el tope.
							 *  si no es ni 1 ni 2 es porque ya estaba superado el tope.
							*/
							
							comprobar= comprobar_introducida(monedas[0]);
							if(comprobar==1) {
								cantidad_introducida[0]++;
							}
							else if(comprobar==2) {
							
									cantidad_introducida[0]++;	
							}
							
							else
								System.out.println("Moneda devuelta.");
								
							
						break;
						
						
						case 4:
							
							comprobar= comprobar_introducida(monedas[1]);
							if(comprobar==1) {
								cantidad_introducida[1]++;
							}
							else if(comprobar==2) {
									cantidad_introducida[1]++;
							}
							
							else
								System.out.println("Moneda devuelta.");
							
							
						break;
						
						
						case 5:
							
							comprobar= comprobar_introducida(monedas[2]);
							if(comprobar==1) {
								cantidad_introducida[2]++;
							}
							else if(comprobar==2) {
									cantidad_introducida[2]++;
							}
							
							else
								System.out.println("Moneda devuelta.");
							
							
						break;
						
						case 6:
							
							comprobar= comprobar_introducida(monedas[3]);
							if(comprobar==1) {
								cantidad_introducida[3]++;
							}
							else if(comprobar==2) {
									cantidad_introducida[3]++;
							}
							
							else
								System.out.println("Moneda devuelta.");
							
						
						break;
						
						
						case 7:
							
							comprobar= comprobar_introducida(monedas[4]);
							if(comprobar==1) {
								cantidad_introducida[4]++;
							}
							else if(comprobar==2) {
									cantidad_introducida[4]++;
							}
							
							else
								System.out.println("Moneda devuelta.");
							
						break;
						
						
						case 8:
							
							comprobar= comprobar_introducida(monedas[5]);
							if(comprobar==1) {
								cantidad_introducida[5]++;
							}
							else if(comprobar==2) {
									cantidad_introducida[5]++;	
							}
							
							else
								System.out.println("Moneda devuelta.");
						
						break;
						
						case 9:  //OPCION VALIDAR
							
							//si el saldo es mayor que 0.20 si puede validar.
							if(suma_saldo_user >= 0.20) {
									validar=true;  
									
									//si no se ha tenido que devolver dinero.
									if(comprobar_introducida(0)==1) {
										vect[1]=1.00;
										vect[0] = suma_saldo_user; //si es menor que el maximo, devuelve esa cantidad.
										System.out.println("GRACIAS. IMPRIENDO SU TICKET");
										//ticket
										
										//bucle que suma las monedas introducidas al saldo de la caja.
										for(int i = 0 ; i<cantidad_introducida.length; i++) {
											cantidad_parqui[i]+=cantidad_introducida[i];
										}
									}
									//si se ha tenido que devolver dinero.
									else {
										vect[1]=1.00;
										vect[0] = max;  //si es mayor que el maximo, devuelve el maximo.
										System.out.println("GRACIAS. IMPRIENDO SU TICKET Y DEVOLVIENDO CAMBIO");
										//mostrar_ticket
										
										//bucle que resta el cambio devuelto y suma las monedas introducidas a la caja real.
										for(int i = 0; i < cantidad_parqui.length; i++) {
											cantidad_parqui[i] += cantidad_introducida[i]-cantidad_camb[i];
										}
									}
									//bucle que restablece las variables y que iguala la caja real con la virtual si se ha validado y ya ha pasado por matricula.
									if(pas == false) {
										
										for(int i = 0; i<cantidad_parqui.length; i++) {
											cantidad_parqui_du[i] = cantidad_parqui[i];
											cantidad_camb[i]=0;
											cantidad_introducida[i]=0;
										}
									}	
							}
							//si no, tiene que seguir echando monedas.
							else
								System.out.println("Importe minimo son 0.20 €");	
						break;	
					}
				}
				catch(Exception e) {
					e.getMessage();
				}
			}while(validar!=true && opc!=0);
		}
		catch(Exception e) {
			e.getMessage();
		}
		return vect;
	}

	/*
	 * METODO : COMPROBAR_INTRODUCIDA
	 * DESCRIPCION : comprueba si la moneda introducida es menor, mayor o igual que el maximo permitido. 
	 * Entradas -> double moneda -> la moneda introducida.
	 * Salidas -> int puede -> devuelve un 1 si es menor, un 2 si acaba de superarse con esta ultima y un 3 si ya estaba superado.
	 * 
	 */
	
	private int comprobar_introducida(double moneda) {
		
		int puede = 0;
		//si al sumar el saldo con la moneda es menor o igual que el maximo, la coge.
		if(suma_saldo_user+moneda <= max) {	
			suma_saldo_user += moneda;
			puede =1;
			ticket(true,"",suma_saldo_user);
		}
		
		else {
			//si el saldo es menor que el maximo pero al introducir la moneda sobrepasa y es la primera vez que pasa
			if((suma_saldo_user<max) && (pasa==true)) {
				//ticket(true,"",max);
				suma_saldo_user+=moneda;
				System.out.println("El máximo son 2.05 que equivale a 2 horas.");
				dev= suma_saldo_user-max;
				System.out.println("Le sobran: "+(double)Math.round(dev * 100d) / 100d+" €");
				if(comprobar_cambio(dev)==false) {
					System.out.println("Si desea continuar igualmente pulse 9 (validar) o 0 (cancelar).");
				}
				else {
					System.out.println("Se le podría devolver todo el cambio.");
				}
				pasa=false;
				puede=2;
			}
			//si al introducir la moneda ya estabamos en el maximo
			else if(suma_saldo_user >= max) {
				ticket(true,"",max);
				puede=3;
			}
		}
		
		return puede;	
	}
	
	/*
	 * METODO : COMPROBAR_CAMBIO
	 * DESCRIPCIÃ“N : MÃ©todo que comprueba si hay cambio total o parcial para devolver al usuario.
	 * Entradas -> double cambio -> el cambio a devolver.
	 * Salidas -> boolean d -> si se le puede devolver todo devuelve true y si no false. 
	 */
	
	//metodo que comprueba si hay cambio o no.
	public boolean comprobar_cambio(double cambio) {

		boolean d = true; //variable que cambia a false cuando no se puede devolver mas cambio.
		//bucle para repetir mientras quede cambio por devolver.
		while(cambio>0) {
			//bucle para ver si hay monedas disponibles por jerarquia para devolver.
			for(int i = 0; i < cantidad_parqui_du.length; i++) {
				
				if(cantidad_parqui_du[i]!=0) {
					if(cambio-monedas[i]>=0) {
						cambio-=monedas[i];
						cantidad_camb[i]++;
						cantidad_parqui_du[i]--;
					}	
				}	
			}
			if(cambio<0.05) {
				d = true;
				break;  //sale del bucle cuando ya no hay cambio por devolver.
			}
			else{
				System.out.println("Debido a que no hay cambio suficiente, la mÃ¡quina se quedarÃ¡ : "+(double)Math.round(cambio * 100d) / 100d+" â‚¬ si valida");
				d = false;
				break; //sale del bucle cuando ya no se puede devolver mas monedas.
			}
			
		}
		return d;
	}
	
	
	//############################################ DAVID ##############################
	
	//Metodos David
	
	/**
	 * 
	 * @author David García Bermejo
	 * @return mat Vector que almacena la matrícula del vehículo del cliente y parámetros de configuración.
	 * 
	 */

	
	public static String[] matricula() {
		
		// VARIABLES
		
		Scanner t = new Scanner (System.in);
		String mat[] = new String[2];
		String aux = "";
		boolean flag1 = true, flag2 = true;
		
		// INGRESAR Y VALIDAR MATRÍCULA
		
		do {
			flag1 = true;
			try {
				System.out.print("Por favor, ingrese la matrícula: ");
				mat[0] = t.next();
				mat[0] = mat[0].toUpperCase();
			} catch (Exception e) {
				System.out.println("Error al ingresar la matrícula, inténtelo de nuevo");
				System.out.println();
				flag1 = false;
			}
			
			for (int i = 0; i < mat[0].length(); i++) {
				if ((mat[0].charAt(i) < 'A') ||  (mat[0].charAt(i) > 'Z')) {
					if ((mat[0].charAt(i) < '0') ||  (mat[0].charAt(i) > '9')) {
						if (mat[0].charAt(i) != 'Ñ')			flag1 = false;
					}
				}
			}
			
			if (mat[0].length() > 7) {
				System.out.println("La matrícula debe tener hasta 7 caracteres alfanuméricos");
				System.out.println();
				flag1 = false;
			}
			switch (mat[0]) {
				case "EXIT":
					mat[1] = mat[0];
					mat[0] = "";
				break;
				case "FINDIA":
					mat[1] = mat[0];
					mat[0] = "";
				break;
				default:
					mat[1] = "";
			}
			
		} while (flag1 == false);
		
		// COMPROBACIÓN DE MATRÍCULA
		
		do {
			flag2 = true;
			try {
				if ((mat[1].equals("EXIT")) || (mat[1].equals("FINDIA"))) {
					System.out.println("Se ha detectado la palabra registrada " + mat[1] + ", ¿Desea continuar?");
				}else {
					System.out.println("Su matrícula es: " + mat[0] + ", ¿Desea continuar?");
				}
				System.out.println("9 = Validar");
				System.out.println("0 = Cancelar");
				aux = t.next();
				if ((aux.equals("0")) || (aux.equals("9"))) {
					if (aux.equals("0")) {
						mat[1] = "CANCELA";
						mat[0] = "";
					}
					else {
						if (mat[1].equals("FINDIA")) {
							mat[1] = "FINDIA";
						} else if (mat[1].equals("EXIT")) {
							mat[1] = "EXIT";
						} else {
							mat[1] = "OK";
						}
					}
				} else {
					System.out.println("Solo puede utilizar los botones asignados");
					System.out.println();
					flag2 = false;
				}
			}catch (Exception e) {
				System.out.println("Ha ocurrido un error, inténtelo de nuevo");
				System.out.println();
				flag2 = false;
			}
		} while (flag2 == false);
		return mat;
		
	}
	
	
	/**
	 * 
	 * @author David García Bermejo
	 * @param a nos permite saber si se envía por pantalla o se imprime
	 * @param m Matrícula proporcionada por el cliente
	 * @param i Importe proporcionado por el cliente
	 * 
	 */
	
	public static void aumento(int f[]) {
		
		boolean flag = false;
		
		if ((f[4] % 4 == 0) && ((f[4] % 100 != 0) || (f[4] % 400 == 0))) {
			flag = true;
		}
		
		if ((f[2] > 28) && (f[3] == 2) && (flag == true)) {
			f[2] -= 28;
			f[3]++;
		}
		
		if ((f[2] > 29) && (f[3] == 2)) {
			f[2] -= 29;
			f[3]++;
		}
		
		if ((f[2] > 31) && ((f[3] == 1) || (f[3] == 3) || (f[3] == 5) || (f[3] == 7) || (f[3] == 8) || (f[3] == 10) || (f[3] == 12))) {
			f[2] -= 31;
			f[3]++;
			if (f[3] > 12) {
				f[3] -= 11;
				f[4]++;
			}
		}
		
		if ((f[2] > 30) && ((f[3] == 4) || (f[3] == 6) || (f[3] == 9) || (f[3] == 11))) {
			f[2] -= 30;
			f[3]++;
		}
		
	}
	
	
	public static void ticket(boolean a, String mat, double i) {
		
		// VARIABLES
		
		double imp = i;						// Importe
		int f[] = new int[5];				// Fecha y hora a imprimir
		int th = 0, tm = 0;					// Horas y minutos a sumar
		if(a == true) mat = "-------";
		
		GregorianCalendar c = new GregorianCalendar();
		DecimalFormat ft = new DecimalFormat("00");
		DecimalFormat fm = new DecimalFormat("0.00");
		DecimalFormat fd = new DecimalFormat("00");
		
		f[0] = c.get(Calendar.HOUR_OF_DAY);
		f[1] = c.get(Calendar.MINUTE);
		f[2] = c.get(Calendar.DAY_OF_MONTH);
		f[3] = (c.get((Calendar.MONTH))+1);
		f[4] = c.get(Calendar.YEAR);
		
		// CÁLCULO DE TIEMPO CON RESPECTO A LAS MONEDAS
		
		if (imp == 2.05) {
			th += 2;
		} else {
			if (imp >= 1.10) {
				th++;
				imp -= 1.10;
			}
			
			for (int j = 1; imp > 0.00; j++) {
				if (j % 2 == 0)		tm++;
				tm += 2;
				imp -= 0.05;
			}
			
			if (tm >= 60) {
				tm -= 60;
				th++;
			}
		}
		
		f[0] += th;
		f[1] += tm;
		
		if (f[1] >= 60) {
			f[0]++;
			f[1] -= 60;
		}
		if (f[0] >=24) {
			f[2]++;
			f[0] -= 24;
		}
		
		aumento(f);
		
		// VALIDACIÓN DE HORAS
		
		
		
		// VISUALIZACIÓN DEL TICKET
				
		if (a == true)		System.out.println("Su ticket es el siguiente:");
		else				System.out.println("···Imprimiendo···");
		System.out.println("");
		System.out.println("<-------------------------->");
		System.out.println("<    Ticket Parquímetro    >");
		System.out.println("<-------------------------->");
		System.out.println("  >   Hasta: " + ft.format(f[0]) + ":" + ft.format(f[1]));
		System.out.println("  >   Importe: " + fm.format(i) + " €" );
		System.out.println("  >   Matrícula: " + mat);
		System.out.println("  >   Fecha: " + fd.format(f[2]) + "-" + fd.format(f[3]) + "-" + f[4]);
		System.out.println();
		System.out.println("<-------------------------->");
		System.out.println();
	}
	
	
	public parquimetro() {
		
		//Inicialización de variables locales
		
		String auxs = ""; //Variable auxiliar que uso para almacenar strings
		double[] auxdv = null; //Variable auxiliar double que uso como vector
		String[] auxsv = null; //Variable auxiliar String que uso como vector
		boolean flag = false;
		
		//Creamos el ID del parquimetro
		id++;
		
		//Empezamos con el flujo del programa
		do {
			
			double ingreso = 0; //Pongo a 0 los ingresos
			String matricula = ""; //Restablezco la matricula
			double tiempo = 0; //Restablezco el tiempo (regla de 3)
			
			//Restablecemos el flag
			flag = false;
			
			System.out.println();
			System.out.println(">>Bienvenido:>>");
			System.out.println();
			System.out.println("+-----------------------------------------+");
			System.out.println("| Monedas:                                |");
			System.out.println("|                                         |");
			System.out.println("| '1'=0,01€ '2'=0,02€ '3'=0,05€ '4'=0,10€ |");
			System.out.println("| '5'=0,20€ '6'=0,50€ '7'=1,00€ '8'=2,00€ |");
			System.out.println("|                                         |");
			System.out.println("| '9' = Validar   '0' = Cancelar          |");
			System.out.println("+-----------------------------------------+");
			System.out.println();
			
			auxs = getDato("Introduce monedas o Valida para continuar",3);
			
			if(auxs.charAt(0)>49&&auxs.charAt(0)<=56) {  //Numero entre 1 y 8
				
				//si el caracter es un numero del 1 al 8, se lo paso al metodo ingresar
				try {
					auxdv = ingresar(Integer.parseInt(auxs), true); //Le laso la primera moneda al metodo ingresar, true si el metodo ingresar empieza primero
					
					if(auxdv[1]==1.00) {
						//Si el importe es correcto, guardo el valor y llamo al metodo matricula
						ingreso = auxdv[0];
						
						try {//Intento llamar al metodo matricula
							auxsv = matricula();
							
							if(auxsv[1]=="OK") {
								//Si la matricula fue confirmada, la guardo y le paso los datos al ticket
								matricula = auxsv[0];
								
								try {
									ticket(false, matricula, ingreso);
									//Si el ticket se imprime sin problemas, aumento los contadores totales
									
									dineroTotal += ingreso;
									tiempoTotal += tiempo;
									
									//Una vez se imprime el ticket y se aumentan los contadores, volvemos al principio
									flag = false;
									
								}catch(Exception t) {
									System.out.println("Ha Fallado el Ticket");
									t.printStackTrace();
								}
								
							} else { //Si la matricula es cancelada, devolvemos el dinero introducido
								
								try {
									devolver(); //Devolvermos lo ingresado por el usuario
									
									//Una vez devuelto, << Volvemos al inicio >>=====#####>
									flag = false;
									
								}catch(Exception d) {
									System.out.println("Reporte: Fallo el metodo Devolver");
									d.printStackTrace();
								}
							}
							
							
						}catch(Exception m) {
							System.out.println("Ha fallado el metodo 'Matricula' ");
							m.printStackTrace();
						}
						
						
					}else if(auxdv[1]==2.00) {
						//    << Volvemos al inicio >>=====#####>
						flag = false;
					}else {
						System.out.println("Reporte: Algo está mal con el metodo ingresar");
					}
					
				}catch(Exception e) {
					System.out.println("Ha fallado el metodo Ingresar");
					e.printStackTrace();
				}
				
			}else if(auxs.charAt(0)=='9') { 
				
				//Si se le ha dado al botón de validar, entonces ejecutamos el metodos matricula
				try {
					auxsv = matricula();	
					
					switch(auxsv[1]) {
					
					case "OK":
						//Si la matricula fue validada, la guardamos y llamamos al metodo ingresar
						matricula = auxsv[0];
						
						try {
							
							System.out.println();
							System.out.println("Monedas: ");
							System.out.println(" '1'=0,01€ '2'=0,02€ '3'=0,05€ '4'=0,10€ ");
							System.out.println(" '5'=0,20€ '6'=0,50€ '7'=1,00€ '8'=2,00€ ");
							System.out.println();
							System.out.println(" '9' = Validar   '0' = Cancelar");
							System.out.println();
							System.out.println();
							
							auxs = getDato("Introduce monedas para continuar: ",3);
							
							auxdv = ingresar(Integer.parseInt(auxs), false); //le paso un false a ingresar si primero se tiene la matricula
							
							if(auxdv[1]==1.00) {
								//Si el importe es correcto, lo guardamos y llamamos al metodo ticket
								ingreso = auxdv[0];
								
								try {
									ticket(false, matricula, ingreso);
									//Si el ticket se imprime sin problemas, aumento los contadores totales
									
									dineroTotal += ingreso;
									tiempoTotal += tiempo;
									
									//Una vez se imprime el ticket y se aumentan los contadores, volvemos al principio
									flag = false;
									
								}catch(Exception t) {
									System.out.println("Ha Fallado el Ticket");
									t.printStackTrace();
								}
							}
						}catch(Exception i) {
							System.out.println("Ha fallado el metodo 'Ingresar' ");
							i.printStackTrace();
						}
						
						break;
						
					case "CANCELAR": 
						// Si se cancela, volvemos al inicio
						flag = false;
						
						break;
					case "FINDIA": 
						//Si es fin del dia, escribimos fichero
						
						try {
							fichero.escribirFichero(id, dineroTotal, tiempoTotal);						
							System.out.println();
							System.out.println("El fichero fue creado correctamente");
							System.out.println();
						}catch(Exception e) {
							System.out.println("La creación del fichero ha fallado");
							e.printStackTrace();
						}
						
						
						//Ahora volvemos a empezar (a partir de aqui cuenta para el día siguiente)
						flag = false;
						
						break;
					case "EXIT": 
						//Caso especial para el test, obliga a cerrar el programa del objeto
						System.out.println("Saliendo del parquimetro");
						//Salimos del bucle
						flag = true;
						
						break;
					default: 
						//Si falla que salga
						System.out.println("Reporte: La salida de matricula mal");
						//Salimos del bucle
						flag = true;
						
						break;
					
					}
				}catch(Exception m) {
					System.out.println("Ha fallado el metodo Matricula");
					m.printStackTrace();
				}
			}else {//si es un cancelar ('0') o cualquier otra cosa, repetimos el bucle
				flag = false;
			}
			
		}while(flag!=true);
		
		System.out.println("Saliendo del Parquimetro con ID "+id);
	}
	

}
