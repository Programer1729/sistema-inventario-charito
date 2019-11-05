package dto;

import java.time.LocalDate;
import java.util.TreeSet;

public class PedidoCompra implements Comparable{  
	
	private int idPedido; 
	private String numeroPedido;
	private Proveedor proveedor; 
	private MateriaPrima materiaPrima;
	private LocalDate fechaPedido; 
	private double cantidad;
	
	public PedidoCompra() {
		// TODO Auto-generated constructor stub
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	} 	
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	} 


	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Proveedor: "+this.proveedor.getNombre()+" Materia Prima: "+this.materiaPrima.getNombre();
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		PedidoCompra p = (PedidoCompra)o; 
		return this.idPedido - p.idPedido;
	}

}
