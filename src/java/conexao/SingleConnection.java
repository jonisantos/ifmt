/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.*;

/**
 *
 * @author Joni
 */
public class SingleConnection {
    
    private static String url = "jdbc:mysql://localhost/ifmt";
	private static String password = "root";
	private static String user = "root";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}
	
	private static void conectar(){
		try {
			
			if(connection == null){
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}
			
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar com o banco de dados");
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
        
}
