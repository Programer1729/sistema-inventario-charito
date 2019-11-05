package dao;

import java.sql.*;
import java.util.TreeSet;

import connection.ConexionDataBase;
import dto.Proveedor;

public class ProveedoresMPDAO { 
	
	private String sql = "SELECT p.nombre_proveedor, p.telefono_proveedor, p.id_proveedor FROM proveedor p WHERE p.id_proveedor IN "
			+ "(SELECT pmp.id_proveedor FROM proveedor_materia_prima pmp WHERE pmp.id_materia_prima::integer = ?)"; 
	
	public TreeSet obtenerProveedoresMateriaPrima(int id) { 
		
		TreeSet<Proveedor> proveedores = new TreeSet();
		Connection con = ConexionDataBase.realizarConexion();
    	
    	if(con != null) {
    		try {
    			PreparedStatement s = con.prepareStatement(sql); 
    			s.setInt(1,id);
                ResultSet rs = s.executeQuery();
                
                while(rs.next()) {  
                	Proveedor p = new Proveedor();
                	p.setNombre(rs.getString(1));
                	p.setTelefono(rs.getString(2)); 
                	p.setId(rs.getInt(3));
                	proveedores.add(p);
                }
    		}catch(SQLException e) {
    			System.out.print(e.getMessage());
    		}
		
    	} 
    	return proveedores; 

	}

}
