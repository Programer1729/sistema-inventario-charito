package negocio;

import java.time.LocalDate;
import java.util.TreeSet;

import dao.DetallePedidoDAO;
import dao.MateriaPrimaDAO;
import dao.PedidoDAO;
import dao.ProveedoresMPDAO;
import dto.*;

public class SistemaInventario { 
	
	private Rol rol; 
	private TreeSet<MateriaPrima> materiasPrimas = new TreeSet(); 
	private TreeSet<Proveedor> proveedores = new TreeSet(); 
	private TreeSet<PedidoCompra> pedidos = new TreeSet();  
	
	public SistemaInventario() {
		// TODO Auto-generated constructor stub 
		
	}  
	
	public boolean cargarMateriaPrima() { 
		
		MateriaPrimaDAO mpdao = new MateriaPrimaDAO();
		
		materiasPrimas = mpdao.obtenerMateriaPrima(); 
		
		if(!materiasPrimas.isEmpty()){
			return true;
		}
		
		return false;
	}  
	
	public boolean esMateriaCritica(MateriaPrima mp) {
		return mp.getCantidad() <= mp.getCantidadMinima();
	} 
	
	public MateriaPrima cargarProveedorMateriaPrima(int id) { 
		MateriaPrima mp = new MateriaPrima(); 
		mp.setId(id);
		mp = this.buscarMateriaPrima(mp); 
		if(mp == null){
			return null;
		} 
		ProveedoresMPDAO pmp = new ProveedoresMPDAO(); 
		TreeSet<Proveedor> proveedoresMP = pmp.obtenerProveedoresMateriaPrima(id); 
		mp.setProveedores(proveedoresMP); 
		return mp;
	} 
	
	public MateriaPrima buscarMateriaPrima(MateriaPrima mp) {
		if(this.materiasPrimas.contains(mp))
        {
            return this.materiasPrimas.floor(mp);
        }
        return null;

	} 
	
	public boolean realizarPedido(int idMateria, int cantidad, int idProveedor) {
		MateriaPrima mp = new MateriaPrima(); 
		Proveedor p = new Proveedor(); 
		PedidoCompra pc = new PedidoCompra(); 
		
		mp.setId(idMateria); 
		p.setId(idProveedor); 
		pc.setCantidad(cantidad); 
		pc.setFechaPedido(LocalDate.now());  
		
		DetallePedidoDAO dp = new DetallePedidoDAO();
		if(dp.insertarDetallePedido(idMateria, cantidad, idProveedor)) {  
			int idDetallePedido = dp.obtenerDetallePedidoID(idMateria, cantidad, idProveedor);
			PedidoDAO pdao = new PedidoDAO(); 
			pdao.insertarPedido(LocalDate.now(), idDetallePedido);   
			
			MateriaPrima materia = this.buscarMateriaPrima(mp); 
			pc.setMateriaPrima(materia); 
			Proveedor proveedor = materia.obtenerProveedor(p); 
			pc.setProveedor(proveedor);
			
			
			System.out.println(pc);
			this.pedidos.add(pc);  
			return true;
		} 
		return false;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public TreeSet<MateriaPrima> getMateriasPrimas() {
		return materiasPrimas;
	}

	public void setMateriasPrimas(TreeSet<MateriaPrima> materiasPrimas) {
		this.materiasPrimas = materiasPrimas;
	}

	public TreeSet<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(TreeSet<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public TreeSet<PedidoCompra> getPedidos() {
		return pedidos;
	}

	public void setPedidos(TreeSet<PedidoCompra> pedidos) {
		this.pedidos = pedidos;
	} 
	
	
	
	

}
