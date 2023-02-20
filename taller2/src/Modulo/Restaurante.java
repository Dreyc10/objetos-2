package Modulo;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



public class Restaurante {
	
	//atributos
	private ArrayList<Pedido> pedidos;
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<Combo> combos;
	private ArrayList<Producto> menuBase;
	private Pedido pedidoEnCurso;
	private int Npedidos;
	private ProductoAjustado productoAjustado;
	
	
	
	
	public Restaurante()
	{
		this.pedidos = new ArrayList<>();
		this.ingredientes = new ArrayList<>();
		this.combos = new ArrayList<>();
		this.menuBase = new ArrayList<>();
		this.pedidoEnCurso = null;
		this.Npedidos = -1;
		this.productoAjustado = null;
		
	}
	
	
	public void iniciarPedido(String nombreCliente, String direccionCliente)
	{
		Npedidos += 1;
		pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);
		pedidoEnCurso.Idpedido(Npedidos);
		
	}
	
	public void ponerElementosPedido(String producto) {
		int iterador = combos.size();
		for(int i = 0; i < iterador; i++) {
			String nombre = combos.get(i).getNombre();
			if (nombre.equals(producto)){
				pedidoEnCurso.agregarProducto(combos.get(i));
			}
		}
		int iterator = menuBase.size();
		for(int j = 0; j<iterator;j++){
			String name = menuBase.get(j).getNombre();
			if (name.equals(producto)){
				pedidoEnCurso.agregarProducto(menuBase.get(j));
			}
		}
		
	}
	public void ajustarProducto(String producto) {
		int iterador = combos.size();
		for(int i = 0; i < iterador; i++) {
			String nombre = combos.get(i).getNombre();
			if (nombre.equals(producto)){
				productoAjustado =new ProductoAjustado(combos.get(i));
			}
		}
		int iterator = menuBase.size();
		for(int j = 0; j<iterator;j++){
			String name = menuBase.get(j).getNombre();
			if (name.equals(producto)){
				productoAjustado = new ProductoAjustado(menuBase.get(j));
				//pedidoEnCurso.agregarProducto(menuBase.get(j));
			}
		}
	}
	
	public void anadirIngrediente(String ingrediente) {
		int iterador = ingredientes.size();
		for(int i = 0; i < iterador; i++) {
			String nombre = ingredientes.get(i).getNombre();
			if (nombre.equals(ingrediente)){
				
				productoAjustado.agregarIngrediente(ingredientes.get(i));
			}
		}	
	}
	
	public void eliminarIngrediente(String ingrediente) {
		int iterador = ingredientes.size();
		for(int i = 0; i < iterador; i++) {
			String nombre = ingredientes.get(i).getNombre();
			if (nombre.equals(ingrediente)){
				
				productoAjustado.removerIngrediente(ingredientes.get(i));
			}
		}
	}
	
	public ArrayList<Pedido> getPedido() {
		return pedidos;
	}
	public void terminarAjustado() {
		pedidoEnCurso.agregarProducto(productoAjustado);
	}
	
	
	public String cerrarYGuardarPedido()
	{
		pedidoEnCurso.generarTextoFactura();
		pedidos.add(pedidoEnCurso);
		return pedidoEnCurso.generarTextoFactura();
	}
	public Pedido getPedidoEnCurso()
	{
		return pedidoEnCurso;
	}
	public ArrayList<Producto> getMenuBase()
	{
		return menuBase;
		
	}
	public ArrayList<Ingrediente> getIngredientes()
	{
		return ingredientes;
	}
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos)throws FileNotFoundException, IOException
	{
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
		
	}
	
	
	private void cargarIngredientes(File archivoIngredientes) throws FileNotFoundException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
		String line = br.readLine();
		
		while(line != null)
		{
			String[] lista = line.split(";");
			String nombre = lista[0];
			int precio = Integer.parseInt(lista[1]);
			Ingrediente ingrediente = new Ingrediente(nombre, precio);
			
			ingredientes.add(ingrediente);
			
			
			
			line = br.readLine();
		}
		br.close();
		
	}
	
	
	private void cargarCombos(File archivoCombos) throws FileNotFoundException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
		String line = br.readLine();
		while(line != null)
		{
			String[] lista = line.split(";");
			String nombre = lista[0];
			Integer numero = lista[1].length();
			String price = lista[1].substring(0,numero-1);
			Double descuento = Double.parseDouble(price);
			Integer n = menuBase.size();
			Combo combo = new Combo(nombre, descuento);
			Integer precio = 0;			
			for(int j=2; j < lista.length ;j++) {

					for(int i=0; i < n ;i++ ) {
						
						Producto producto = menuBase.get(i);
						String name = producto.getNombre();
						if( name.equals(nombre) ) {
							
							combo.agregarItemACombo(producto);
							Integer cantidad = producto.getPrecio();
							precio += cantidad;			
						}	
					}
				}
			precio = (int)(precio * (100 - descuento)/100) ;
			combo.ponerPrecio(precio);
			combos.add(combo);
		
			
			line = br.readLine();
		}
		br.close();
		
	}
	private void cargarMenu(File archivoMenu) throws FileNotFoundException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
		String line = br.readLine();
		while(line != null)
		{
			String[] lista = line.split(";");
			String nombre = lista[0];
			Integer precio = Integer.parseInt(lista[1]);
			ProductoMenu menu = new ProductoMenu(nombre, precio);
			
			menuBase.add(menu);
			
			
			
			line = br.readLine();
		}
		br.close();
		
	}

}

































