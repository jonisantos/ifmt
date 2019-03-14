/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.DaoLogin;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author Joni
 */
@WebServlet(urlPatterns = "/Login")
public class ServletLogin extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    private DaoLogin daoLogin = new DaoLogin();
    
    public ServletLogin(){
        super();
        
    }
    
    protected void doGet(HttpServletRequest request,
            
            HttpServletResponse response) throws ServletException, IOException{
        doPost(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, 
            HttpServletResponse resp) throws ServletException, 
            IOException {
       try{
           
           Usuario usurio = new Usuario();
           
           String login = req.getParameter("login");
           String senha = req.getParameter("senha");
           
           if(daoLogin.validarLogin(login, senha)){
               RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
           }else{
               RequestDispatcher dispatcher = req.getRequestDispatcher("acessonegado");
           }
           
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    
    
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
