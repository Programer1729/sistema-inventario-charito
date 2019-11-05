package dao;

import java.sql.*;

import connection.ConexionDataBase;

public class RolDAO { 
	
	
    String sql = "SELECT * FROM rol WHERE nombre=? AND contraseña=?";
    
    public boolean check(String username, String pass) {
    	Connection con = ConexionDataBase.realizarConexion();
    	
    	if(con != null) {
    		try {
    			PreparedStatement ps = con.prepareStatement(sql);
        		ps.setString(1, username);
                ps.setString(2, pass);
                ResultSet rs = ps.executeQuery();

                if(rs.next())
                    return true;
    		}catch(SQLException e) {
    			return false;
    		}
    	} 
    	
    	return false;
    } 

}
