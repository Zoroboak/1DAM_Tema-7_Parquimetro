package parquimetro;

public class test {


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
		
		//Creamos variables locales
		int opc = 0;
		String aux;
		boolean flag = false;
		
		//Creamos los parquimetros
		parquimetro[] p = new parquimetro[3]; 
		
		
		System.out.println("Programa Parquimetro: Clase Test");
		
		do {
			//Menu
			System.out.println();
			System.out.println();
			System.out.println("+------------------------------+");
			System.out.println("| Menu de Prueba: Simulación   |");
			System.out.println("--------------------------------");
			System.out.println("| 1. Iniciar Parquimetro 1     |");		
			System.out.println("| 2. Iniciar Parquimetro 2     |");		
			System.out.println("| 3. Iniciar Parquimetro 3     |");		
			System.out.println("| 4. Mostrar Totales           |");		
			System.out.println("| 5. Salir                     |");		
			System.out.println("+------------------------------+");
			
			aux = parquimetro.getDato("Introduce opción del menu: ", 1);
			
			//Hago un cast
			opc = Integer.parseInt(aux);
			
			switch (opc) {
			case 1:
				System.out.println("Abriendo Parquimetro 1");
				p[0] = new parquimetro(); 
				break;
			case 2:
				System.out.println("Abriendo Parquimetro 2");
				p[1] = new parquimetro();
				break;
			case 3:
				System.out.println("Abriendo Parquimetro 3");
				p[2] = new parquimetro(); 
				break;
			case 4: 
				System.out.println("Mostrando totales de ingreso: ");
				System.out.println(". . .");
				System.out.println(". . .");
				System.out.println(". . .");
				System.out.println("Opción aun en desarrollo");
				System.out.println();
				System.out.println("En proximas versiones, estará disponible");
				System.out.println();
				break;

			default:
				System.out.println("Saliendo del Programa Parquimetro...");
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("Vuelva pronto :3");
				
				flag=true;
				break;
			}
			
			
			
			
		} while (flag!=true);
		
		
		
		
		
		

	}
	
	

}
