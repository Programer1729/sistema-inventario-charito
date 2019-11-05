package dto;

import java.util.TreeSet;

public class MateriaPrima implements Comparable{
	
	private int id;
	private String nombre; 
	private double cantidad; 
	private String unidadMedida;   
	private double cantidadMinima; 
	private TreeSet<Proveedor> proveedores = new TreeSet(); 
	
	public MateriaPrima() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	} 
	public TreeSet<Proveedor> getProveedores() {
		return proveedores;
	}
	public void setProveedores(TreeSet<Proveedor> proveedor) {
		this.proveedores = proveedor;
	} 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 

	public double getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(double cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	} 
	
	public Proveedor obtenerProveedor(Proveedor p) {
		if(this.proveedores.contains(p))
        {
            return this.proveedores.floor(p);
        }
        return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nombre: "+this.nombre+" Cantidad: "+this.cantidad+" "+this.unidadMedida;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		MateriaPrima mp = (MateriaPrima)o; 
		return this.id - mp.id;
	}
	
}
