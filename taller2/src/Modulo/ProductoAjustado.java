package Modulo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
	
	//Atributos
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	private Producto base;
	private int precio;
	
	public ProductoAjustado(Producto base) {
		this.base = base;
		this.agregados = new ArrayList<>();
		this.eliminados = new ArrayList<>();
		this.precio = 0; 
		
	}
	
	public void agregarIngrediente(Ingrediente ingrediente){
		agregados.add(ingrediente);
	}
	
	public void removerIngrediente(Ingrediente ingrediente){
		eliminados.add(ingrediente);
	}
	
	public void calcularPrecio() {
		int preci= base.getPrecio(); 
		int iterador = agregados.size();
		for(int i = 0; i<iterador; i++ ) {
			Ingrediente ingrediente = agregados.get(i);
			int costo = ingrediente.getCostoAdicional();
			preci += costo;
		}
		this.precio = preci;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public String getNombre() {
		String nombre = base.getNombre();
		return nombre;
	}
	
	public String generarTextoFactura() {
		return "xd";
	}

}
