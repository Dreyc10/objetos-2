package Modulo;

import java.util.ArrayList;

public class Combo implements Producto {
	
	//atributos
	private double descuento;
	private String nombreCombo;
	private ArrayList<Producto> itemsCombo;
	private int precio;
	
	
	//constructor
	public Combo(String nombre, double descuento) {
		this.nombreCombo = nombre;
		this.descuento = descuento;
		this.itemsCombo = new ArrayList<>();
		this.precio = 0;
	}
	
	
	//metodos
	public void agregarItemACombo(Producto itemCombo) {
		
		itemsCombo.add(itemCombo);
		
	}
	
	public int getPrecio() {
		return precio;
		
	}
	
	public String getNombre(){
		return nombreCombo;
	}
	
	public void ponerPrecio(int Precio) {
		this.precio = Precio;
	}
	
	public String generarTextoFactura() {
		return "xd";
	}

}
