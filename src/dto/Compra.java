package dto;

import java.time.LocalDate;

public class Compra {
	
	private PedidoCompra pedido; 
	private LocalDate fechaResivido; 
	private String anotacion; 
	
	public Compra() {
		// TODO Auto-generated constructor stub
	}

	public PedidoCompra getPedido() {
		return pedido;
	}

	public void setPedido(PedidoCompra pedido) {
		this.pedido = pedido;
	}

	public LocalDate getFechaResivido() {
		return fechaResivido;
	}

	public void setFechaResivido(LocalDate fechaResivido) {
		this.fechaResivido = fechaResivido;
	}

	public String getAnotacion() {
		return anotacion;
	}

	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	} 
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Pedido: "+this.pedido+" Fecha Entrega: "+this.fechaResivido;
	}
}
