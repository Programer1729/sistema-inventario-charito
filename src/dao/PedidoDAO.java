package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import connection.ConexionDataBase;

public class PedidoDAO {

	private String sql1 = "INSERT INTO pedido (fecha_pedido, id_detalle_pedido) "
			+ "VALUES ( ?, ?)";   
	
	public boolean insertarPedido(LocalDate fechaPedido, int idDetallePedido) { 
		
		Connection con = ConexionDataBase.realizarConexion();
    	
    	if(con != null) {
    		try {
    			PreparedStatement ps = con.prepareStatement(sql1);
        		ps.setDate(1, Date.valueOf(fechaPedido));
                ps.setInt(2, idDetallePedido); 
                ps.executeUpdate(); 
                return true;
                
    		}catch(SQLException e) {
    			System.out.print(e.getMessage());
    		}
		
    	} 
    	return false;

	}   
}
