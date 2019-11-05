package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

import connection.ConexionDataBase;
import dto.MateriaPrima;

public class DetallePedidoDAO { 
	
	private String sql1 = "INSERT INTO detalle_pedido (id_proveedor, id_materia_prima, cantidad_pedido) "
			+ "VALUES (?, ?, ?)";  
	
	private String sql2 = "SELECT dp.id_detalle_pedido FROM detalle_pedido dp WHERE "
			+ "dp.id_proveedor::integer = ? AND dp.id_materia_prima::integer = ? AND dp.cantidad_pedido::real = ?";
	
	public boolean insertarDetallePedido(int idMateria, int cantidad, int idProveedor) { 
		
		Connection con = ConexionDataBase.realizarConexion();
    	
    	if(con != null) {
    		try {
    			PreparedStatement ps = con.prepareStatement(sql1);
        		ps.setInt(1, idProveedor);
                ps.setInt(2, idMateria); 
                ps.setDouble(3, cantidad);
                ps.executeUpdate(); 
                return true;
                
    		}catch(SQLException e) {
    			System.out.print(e.getMessage());
    		}
		
    	} 
    	return false;

	}  
	
	public int obtenerDetallePedidoID(int idMateria, int cantidad, int idProveedor) {
		
		int idDetallePedido = 0;
		Connection con = ConexionDataBase.realizarConexion();
    	
    	if(con != null) {
    		try {
    			PreparedStatement ps = con.prepareStatement(sql2);
        		ps.setInt(1, idProveedor);
                ps.setInt(2, idMateria); 
                ps.setInt(3, cantidad); 
                ResultSet rs = ps.executeQuery();  
                while(rs.next())
                	idDetallePedido = rs.getInt(1);
                
    		}catch(SQLException e) {
    			System.out.print("No se obtuvo id"); 
    		}
		
    	} 
    	return idDetallePedido;

	}

}
