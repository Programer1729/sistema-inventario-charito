package dao;

import java.sql.*;
import java.util.TreeSet;

import connection.ConexionDataBase;
import dto.MateriaPrima; 


public class MateriaPrimaDAO {  
	
	private String sql = "SELECT * FROM materia_prima";  
	
	public TreeSet obtenerMateriaPrima() { 
		
		TreeSet<MateriaPrima> materiasPrimas = new TreeSet();
		Connection con = ConexionDataBase.realizarConexion();
    	
    	if(con != null) {
    		try {
    			Statement s = con.createStatement(); 
                ResultSet rs = s.executeQuery(sql);
                
                while(rs.next()) {  
                	MateriaPrima mp = new MateriaPrima();
                	mp.setId(rs.getInt(1));
                	mp.setNombre(rs.getString(2)); 
                	mp.setCantidad(rs.getDouble(3)); 
                	mp.setUnidadMedida(rs.getString(4));  
                	mp.setCantidadMinima(rs.getDouble(5));
                	materiasPrimas.add(mp);
                }
    		}catch(SQLException e) {
    			System.out.print(e.getMessage());
    		}
		
    	} 
    	return materiasPrimas;

	} 
}
