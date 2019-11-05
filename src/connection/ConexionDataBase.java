package connection;

import java.sql.*;

public class ConexionDataBase { 

	private static String url = "jdbc:postgresql://localhost:5432/tutorial";
    private static String user = "postgres";
    private static String password = "12345"; 
    
    public static Connection realizarConexion() {  
    	
    	Connection connection = null;
    	
    	try {
			Class.forName("org.postgresql.Driver");  
			connection = DriverManager.getConnection(url,user,password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    	
    	return connection;
    }

}
