package dto;

import java.util.TreeSet;

public class Proveedor implements Comparable{  
	
	private int id;
	private String nombre; 
	private String nit; 
	private String direccion; 
	private String encargado;  
	private TreeSet<MateriaPrima> materiasPrimas = new TreeSet(); 
	private String telefono; 
	
	public Proveedor() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public TreeSet<MateriaPrima> getMateriasPrimas() {
		return materiasPrimas;
	}

	public void setMateriasPrimas(TreeSet<MateriaPrima> materiasPrimas) {
		this.materiasPrimas = materiasPrimas;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	} 
	 
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nombre: "+this.nombre+" Telefono: "+this.telefono;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Proveedor p = (Proveedor)o; 
		return this.id - p.getId();
	}
	

}
