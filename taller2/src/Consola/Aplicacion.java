package Consola;

import Modulo.Restaurante;
import Modulo.Pedido;
import Modulo.Producto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;
import java.util.Map;




public class Aplicacion {

	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	private Restaurante restaurante;
	
	
	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		
		System.out.println("1. Mostrar menu");
		System.out.println("2. Iniciar Pedido");
		System.out.println("3. Añadir productos a un pedido");
		System.out.println("4. Cerrar y guardar un pedido");
		System.out.println("5. Consultar pedido por id");
		System.out.println("6. Cerrar aplicacion");
		
	
		
	}
	
	public void ejecutarAplicacion()throws FileNotFoundException, IOException
	{
		System.out.println("Iniciando restaurante\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					 iniciarRestaurante();
				else if (opcion_seleccionada == 2 && restaurante != null)
					ejecutarIniciarPedido();
				else if (opcion_seleccionada == 3 && restaurante != null)
					ejecutarPonerElementosPedido();
				else if (opcion_seleccionada == 4 && restaurante != null)
					cerrarPedido();
				else if (opcion_seleccionada == 5 && restaurante != null)
					consultarPedido();
				
			
				else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}


public void iniciarRestaurante() throws FileNotFoundException, IOException {
	
	restaurante = new Restaurante();
	File archivoIngredientes = new File("./Taller 2 - Hamburguesas_esqueleto/Taller 2 - Hamburguesas_esqueleto/data/ingredientes.txt");
	File archivoMenu = new File("./Taller 2 - Hamburguesas_esqueleto/Taller 2 - Hamburguesas_esqueleto/data/menu.txt");
	File archivoCombo = new File("./Taller 2 - Hamburguesas_esqueleto/Taller 2 - Hamburguesas_esqueleto/data/combos.txt");
	restaurante.cargarInformacionRestaurante(archivoIngredientes,archivoMenu,archivoCombo);
	
	
}

public void ejecutarIniciarPedido() {
	String nombre = input("Escriba su nombre: ");
	String direccion = input("Escriba su direccion: ");
	restaurante.iniciarPedido(nombre, direccion);
}

public void ejecutarPonerElementosPedido() {
	
	System.out.println("Estos son los productos que disponemos: ");
	System.out.println("\n");
	System.out.println("	Menu   \n");
	System.out.println("\n");
	System.out.println("1. Corral 14.000$");
	System.out.println("2. Corral queso 16.000$");
	System.out.println("3. Corral pollo 15.000$");
	System.out.println("4. Corralita 13.000$");
	System.out.println("5. Todoterreno 25.000$");
	System.out.println("6. Media libra 25.000$");
	System.out.println("7. Especial 24.000$");
	System.out.println("8. Casera 23.000$");
	System.out.println("9. Mexicana 22.000$");
	System.out.println("10. Criolla 22.000$");
	System.out.println("11. Costeña 20.000$");
	System.out.println("12. Hawaiana 20.000$");
	System.out.println("13. Wrap de pollo 15.000$");
	System.out.println("14. Wrap de lomo 22.000$");
	System.out.println("15. Ensalada mexicana 20.900$");
	System.out.println("16. Papas medianas 5.500$");
	System.out.println("17. Papas grandes 6.900$");
	System.out.println("18. Papas en casco medianas 5.500$");
	System.out.println("19. Papas en casco grande 6.900$");
	System.out.println("20. Agua cristal sin gas 5.000$");
	System.out.println("21. Agua cristal con gas 5.000$");
	System.out.println("22. Gaseosa 5.000$");
	System.out.println("\n");
	System.out.println("	Combos   \n");
	System.out.println("\n");
	System.out.println("23. Combo corral ");
	System.out.println("24. Combo corral queso ");
	System.out.println("25. Combo todoterreno");
	System.out.println("26. Combo especial ");
	System.out.println("27. Terminar ");
	System.out.println("\n");
	
	 
	boolean continuar = true;
	
	
	while(continuar) {
		int opcion = Integer.parseInt(input("Seleccione el numero del producto que le gustaría añadir: "));
		
		if (opcion == 1) {
	
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("corral");
			}
			else{
				restaurante.ponerElementosPedido("corral");
				System.out.println("Añadido corral");
			}
			
		}
		else if (opcion == 2) {
			
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("corral queso");
			}
			else{
				restaurante.ponerElementosPedido("corral queso");
				System.out.println("Añadido corral queso");
			}
			
		}
		else if (opcion == 3) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("corral pollo");
			}
			else{
				restaurante.ponerElementosPedido("corral pollo");
				System.out.println("Añadido corral pollo");
			}
		}
		else if (opcion == 4) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("corralita");
			}
			else{
				restaurante.ponerElementosPedido("corralita");
				System.out.println("Añadido corralita");
			}
		}
		else if (opcion == 5) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("todoterreno");
			}
			else{
				restaurante.ponerElementosPedido("todoterreno");
				System.out.println("Añadido todoterreno");
			}
		}
		else if (opcion == 6) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("1/2 libra");
			}
			else{
				restaurante.ponerElementosPedido("1/2 libra");
				System.out.println("Añadido media libra");
			}
		}
		else if (opcion == 7) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("especial");
			}
			else{
				restaurante.ponerElementosPedido("especial");
				System.out.println("Añadido especial");
			}
		}
		else if (opcion == 8) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("casera");
			}
			else{
				restaurante.ponerElementosPedido("casera");
				System.out.println("Añadido casera");
			}
		}
		else if (opcion == 9) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("mexicana");
			}
			else{
				restaurante.ponerElementosPedido("mexicana");
				System.out.println("Añadido mexicana");
			}
		}
		else if (opcion == 10) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("criolla");
			}
			else{
				restaurante.ponerElementosPedido("criolla");
				System.out.println("Añadido criolla");
			}
		}
		else if (opcion == 11) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("costeña");
			}
			else{
				restaurante.ponerElementosPedido("costeña");
				System.out.println("Añadido costeña");
			}
		}
		else if (opcion == 12) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("hawaiana");
			}
			else{
				restaurante.ponerElementosPedido("hawaiana");
				System.out.println("Añadido hawaiana");
			}
		}
		else if (opcion == 13) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("wrap de pollo");
			}
			else{
				restaurante.ponerElementosPedido("wrap de pollo");
				System.out.println("Añadido wrap de pollo");
			}
		}
		else if (opcion == 14) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("wrap de lomo");
			}
			else{
				restaurante.ponerElementosPedido("wrap de lomo");
				System.out.println("Añadido wrap de lomo");
			}
		}
		else if (opcion == 15) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("ensalada mexicana");
			}
			else{
				restaurante.ponerElementosPedido("ensalada mexicana");
				System.out.println("Añadido ensalada mexicana");
			}
		}
		else if (opcion == 16) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("papas medianas");
			}
			else{
				restaurante.ponerElementosPedido("papas medianas");
				System.out.println("Añadido papas medianas");
			}
		}
		else if (opcion == 17) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("papas grandes");
			}
			else{
				restaurante.ponerElementosPedido("papas grandes");
				System.out.println("Añadido papas grandes");
			}
		}
		else if (opcion == 18) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("papas en casco medianas");
			}
			else{
				restaurante.ponerElementosPedido("papas en casco medianas");
				System.out.println("Añadido papas en casco medianas");
			}
		}
		else if (opcion == 19) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("papas en casco grandes");
			}
			else{
				restaurante.ponerElementosPedido("papas en casco grandes");
				System.out.println("Añadido papas en casco grandes");
			}
		}
		else if (opcion == 20) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("agua cristal sin gas");
			}
			else{
				restaurante.ponerElementosPedido("agua cristal sin gas");
				System.out.println("Añadido agua cristal sin ganas");
			}
		}
		else if (opcion == 21) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("agua cristal con gas");
			}
			else{
				restaurante.ponerElementosPedido("agua cristal con gas");
				System.out.println("Añadido agua cristal con gas");
			}
		}
		else if (opcion == 22) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("gaseosa");
			}
			else{
				restaurante.ponerElementosPedido("gaseosa");
				System.out.println("Añadido gaseosa");
			}
		}
		else if (opcion == 23) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("combo corral");
			}
			else{
				restaurante.ponerElementosPedido("combo corral");
				System.out.println("Añadido combo corral");
			}
		}
		else if (opcion == 24) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("combo corral queso");
			}
			else{
				restaurante.ponerElementosPedido("combo corral queso");
				System.out.println("Añadido combo corral queso");
			}
		}
		else if (opcion == 25) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("combo todoterreno");
			}
			else{
				restaurante.ponerElementosPedido("combo todoterreno");
				System.out.println("Añadido combo todoterreno");
			}
		}
		else if (opcion == 26) {
			int op = Integer.parseInt(input("Seleccione 1 si desea modificar el producto, y cualquier otro numero si no"));
			if(op == 1) {
				ajustarProducto("combo especial");
			}
			else{
				restaurante.ponerElementosPedido("combo especial");
				System.out.println("Añadido combo especial");
			}
		}
		else if (opcion == 27) {
			System.out.println("Terminando...");
			continuar = false;
		}
		else {
			
		
				System.out.println("Por favor seleccione una opción válida.");
			
		}
		
	}
	
	
}

public void ajustarProducto(String base) {
	System.out.println("Los ingredientes que puede añadir o retirar son: \n");
	System.out.println("     Ingredientes   \n");
	System.out.println("\n");
	
	System.out.println("1. Lechuga 1.000$");
	System.out.println("2. Tomate 1.000$");
	System.out.println("3. Cebolla 1.000$");
	System.out.println("4. Queso mozzarella 2.500$");
	System.out.println("5. Huevo 2.500$");
	System.out.println("6. Queso americano 2.500$");
	System.out.println("7. Tocineta express 2.500$");
	System.out.println("8. Papa callejera 2.000$");
	System.out.println("9. Pepinillos 2.500$");
	System.out.println("10. Cebolla grille 2.500$");
	System.out.println("11. Suero costeño 3.000$");
	System.out.println("12. Frijol refrito 4.500$");
	System.out.println("13. Queso fundido 4.500$");
	System.out.println("14. Tocineta picada 6.000$");
	System.out.println("15. Piña 2.500$");
	System.out.println("16. Salir");
	
	restaurante.ajustarProducto(base);
	
	
	 
	boolean seguir = true;
	while(seguir) {
		int k = Integer.parseInt(input("escriba el numero si desea añadirlo, y escriba el numero x100 si desea eliminarlo"));
		if (k == 1) {
			
			restaurante.anadirIngrediente("lechuga");
			System.out.println("+1");
		}
		else if (k == 100) {
			
			restaurante.eliminarIngrediente("lechuga");
			System.out.println("-1");
		}
		else if (k == 2) {
			
			restaurante.anadirIngrediente("tomate");
			System.out.println("+1");
		}
		else if (k == 200) {
			
			restaurante.eliminarIngrediente("tomate");
			System.out.println("-1");
		}
		else if (k == 3) {
			
			restaurante.anadirIngrediente("cebolla");
			System.out.println("+1");
		}
		else if (k == 300) {
			
			restaurante.eliminarIngrediente("cebolla");
			System.out.println("-1");
		}
		else if (k == 4) {
			
			restaurante.anadirIngrediente("queso mozzarella");
			System.out.println("+1");
		}
		else if (k == 400) {
			
			restaurante.eliminarIngrediente("queso mozzarella");
			System.out.println("-1");
		}
		else if (k == 5) {
		
			restaurante.anadirIngrediente("huevo");
			System.out.println("+1");
		}
		else if (k == 500) {
			
			restaurante.eliminarIngrediente("huevo");
			System.out.println("-1");
		}
		else if (k == 6) {
			
			restaurante.anadirIngrediente("queso americano");
			System.out.println("+1");
		}
		else if (k == 600) {
			
			restaurante.eliminarIngrediente("queso americano");
			System.out.println("-1");
		}
		else if (k == 7) {
			
			restaurante.anadirIngrediente("tocineta express");
			System.out.println("+1");
		}
		else if (k == 700) {
			
			restaurante.eliminarIngrediente("tocineta express");
			System.out.println("-1");
		}
		else if (k == 8) {
			
			restaurante.anadirIngrediente("papa callejera");
			System.out.println("+1");
		}
		else if (k == 800) {
			
			restaurante.eliminarIngrediente("papa callejera");
			System.out.println("-1");
		}
		else if (k == 9) {
			
			restaurante.anadirIngrediente("pepinillos");
			System.out.println("+1");
		}
		else if (k == 900) {
			
			restaurante.eliminarIngrediente("pepinillos");
			System.out.println("-1");
		}
		else if (k == 10) {
			
			restaurante.anadirIngrediente("cebolla grille");
			System.out.println("+1");
		}
		else if (k == 1000) {
			
			restaurante.eliminarIngrediente("cebolla grille");
			System.out.println("-1");
		}
		else if (k == 11) {
			
			restaurante.anadirIngrediente("suero costeño");
			System.out.println("+1");
		}
		else if (k == 1100) {
			
			restaurante.eliminarIngrediente("suero costeño");
			System.out.println("-1");
		}
		else if (k == 12) {
			restaurante.anadirIngrediente("frijol refrito");
			System.out.println("+1");
		}
		else if (k == 1200) {
			restaurante.eliminarIngrediente("frijol refrito");
			System.out.println("-1");
		}
		else if (k == 13) {
			restaurante.anadirIngrediente("queso fundido");
			System.out.println("+1");
		}
		else if (k == 1300) {
			restaurante.eliminarIngrediente("queso fundido");
			System.out.println("-1");
		}
		else if (k == 14) {
			restaurante.anadirIngrediente("tocineta picada");
			System.out.println("+1");
		}
		else if (k == 1400) {
			restaurante.eliminarIngrediente("tocineta picada");
			System.out.println("-1");
		}
		else if (k == 15) {
			restaurante.anadirIngrediente("piña");
			System.out.println("+1");
		}
		else if (k == 1500) {
			restaurante.eliminarIngrediente("piña");
			System.out.println("-1");
		}
		else if(k == 16) {
			
			seguir = false;
			
		}
		else {
			System.out.println("Elija una opcion valida");
		}
		
	}
}

public void cerrarPedido() {
	System.out.println(restaurante.cerrarYGuardarPedido());
}

public void consultarPedido() {
	int a = Integer.parseInt("Ingresa el id :D");
	System.out.println(restaurante.getPedido().get(a));
}

public static void main(String[] args)throws FileNotFoundException, IOException {
	Aplicacion view = new Aplicacion();
    view.ejecutarAplicacion();
}

	
}






















