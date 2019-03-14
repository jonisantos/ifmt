/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sun.xml.ws.tx.at.v10.types.PrepareResponse;
import conexao.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Joni
 */
public class DaoLogin {
    
    private Connection connection;
    
    public DaoLogin(){
        connection = SingleConnection.getConnection();
    }
    
    public boolean validarLogin(String login, String senha) throws SQLException{
        
        String sql = "select * from usuario where login = '" + login 
                + "' and senha = '" + senha + "'";
        PreparedStatement st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        
        if(rs.next()){
            return true;
        }else{
            return false;
        }      
        
    }
}
