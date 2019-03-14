/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.DaoDetalhesObra;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DetalhesObra;

/**
 *
 * @author Joni
 */
@WebServlet(urlPatterns = "/salvarObras")
public class ServletDetalhesObras extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private DaoDetalhesObra daoDetalhe = new DaoDetalhesObra();

    public ServletDetalhesObras() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            String acao = request.getParameter("acao");
            String user = request.getParameter("user");

            if (acao.equalsIgnoreCase("delete")) {
                daoDetalhe.delete(user);
                RequestDispatcher view = request
                        .getRequestDispatcher("/cadastroObrasDeArtr.jsp");
                request.setAttribute("obras", daoDetalhe.listar());
                view.forward(request, response);
            } else if (acao.equalsIgnoreCase("editar")) {

                DetalhesObra obra = daoDetalhe.consultar(user);

                RequestDispatcher view = request
                        .getRequestDispatcher("/cadastroObrasDeArte.jsp");
                request.setAttribute("user", obra);
                view.forward(request, response);
            } else if (acao.equalsIgnoreCase("listartodos")) {

                RequestDispatcher view = request
                        .getRequestDispatcher("/cadastroObrasDeArte.jsp");
                request.setAttribute("obras", daoDetalhe.listar());
                view.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String acao = request.getParameter("acao");

        if (acao != null && acao.equalsIgnoreCase("reset")) {
            try {
                RequestDispatcher view = request
                        .getRequestDispatcher("/cadastroObrasDeArte.jsp");
                request.setAttribute("obras", daoDetalhe.listar());
                view.forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            String id = request.getParameter("id");
            String titulo = request.getParameter("titulo");
            String data = request.getParameter("data");
            String tecnico = request.getParameter("tecnico");
            String dimensoe_fisica = request.getParameter("dimensoe_fisica");
            String autor = request.getParameter("autor");
            String procendencia = request.getParameter("procedencia");
            String tipo = request.getParameter("tipo");

            DetalhesObra obra = new DetalhesObra();
            obra.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
            obra.setTitulo(titulo);
            obra.setData(data);
            obra.setTecnico(tecnico);
            obra.setDimensoe_fisica(dimensoe_fisica);
            obra.setAutor(autor);
            obra.setProcedencia(procendencia);
            obra.setTipo(tipo);
            try {                

                RequestDispatcher view = request
                        .getRequestDispatcher("/cadastroDetalhesObrasDeArte.jsp");
                request.setAttribute("obras", daoDetalhe.listar());
                view.forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
