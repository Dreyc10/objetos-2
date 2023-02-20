package Modulo;
import java.util.ArrayList;

public class Pedido {
	
	private int numeroPedidos;
	
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> itemsPedido = new ArrayList<>();
	
	
	public Pedido(String nombreCliente, String direccionCliente)
	{
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.idPedido = 0;
		
		
		
	}
	
	public void Idpedido(int numero) {
		this.idPedido = numero;
	}
	
	public int getIdPedido()
	{
		return idPedido;
		
	}
	public void agregarProducto(Producto nuevoItem)
	{
		itemsPedido.add(nuevoItem);
	}
	
	private int getPrecioNetoPedido()
	{
		int iterador = itemsPedido.size();
		int suma = 0;
		for(int i=0; i<iterador; i++) {
			Producto producto = itemsPedido.get(i);
			int precio = producto.getPrecio();
			suma += precio;
		}
		return suma;
	}
	
	private int getPrecioTotalPedido()
	{
		int iva = getPrecioIvaPedido();
		int Neto = getPrecioNetoPedido();
		int Total = iva + Neto;
		return Total;
		
	}
	private int getPrecioIvaPedido()
	{
		int Neto = getPrecioNetoPedido();
		int iva = (int)(Neto * 0.19);
		return iva;
	}
	
	
	
	public String generarTextoFactura()
	{
		String total1 = Integer.toString(getPrecioNetoPedido());
		String total2 = Integer.toString(getPrecioIvaPedido());
		String total3 = Integer.toString(getPrecioTotalPedido());
		return "Nombre: " + nombreCliente + "\n" + "Direccion: "+direccionCliente+"\n" +"precio neto: " + total1+"\n" +"precio iva"+ total2+"\n"+"precio total" + total3; 
				
		
	}
	

}
