<%-- 
    Document   : cadastroObrasDeArte
    Created on : 12/03/2019, 21:46:35
    Author     : Joni
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro de Obra de Arte</title>

        <link rel="stylesheet" href="resources/css/cadastro.css">

    </head>
    <body>
        <center>
            <h1>Cadastro de Obra</h1>
            <h3 style="color: orange;">${msg}</h3>
        </center>

        <form action="salvarUsuario" method="post" id="formUser">
            <ul class="form-style-1">
                <li>
                    <table>
                        <tr>
                            <td>C�digo:</td>
                            <td><input type="text" readonly="readonly" id="id" name="id"
                                       value="${user.id}" class="field-long"></td>
                        </tr>
                        <tr>
                            <td>Titulo:</td>
                            <td><input type="text" id="login" name="login"
                                       value="${user.login}"></td>
                        </tr>

                        <tr>
                            <td>Data:</td>
                            <td><input type="password" id="senha" name="senha"
                                       value="${user.senha}"></td>
                        </tr>
                        <tr>
                            <td>T�cnico:</td>
                            <td><input type="text" id="nome" name="nome"
                                       value="${user.nome}"></td>
                        </tr>
                        
                         <tr>
                            <td>Dimens�o Fisica:</td>
                            <td><input type="text" id="nome" name="nome"
                                       value="${user.nome}"></td>
                        </tr>
                        
                         <tr>
                            <td>Autor:</td>
                            <td><input type="text" id="nome" name="nome"
                                       value="${user.nome}"></td>
                        </tr>
                        
                         <tr>
                            <td>Procedencia:</td>
                            <td><input type="text" id="nome" name="nome"
                                       value="${user.nome}"></td>
                        </tr>
                        
                         <tr>
                            <td>Tipo:</td>
                            <td><input type="text" id="nome" name="nome"
                                       value="${user.nome}"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Salvar"> <input type="submit"  value="Cancelar" onclick="document.getElementById('formUser').action = 'salvarUsuario?acao=reset'"></td>
                        </tr>
                    </table>

                </li>
            </ul>
        </form>

        <div class="container">
            <table class="responsive-table">
                <caption>Usu�rios cadastrados</caption>
                <tr>
                    <th>Id</th>
                    <th>Login</th>
                    <th>Nome</th>
                    <th>Delete</th>
                    <th>Editar</th>
                </tr>
                <c:forEach items="${usuarios}" var="user">
                    <tr>
                        <td style="width: 150px"><c:out value="${user.id}">
                            </c:out></td>
                        <td style="width: 150px"><c:out value="${user.login}">
                            </c:out></td>
                        <td><c:out value="${user.nome}"></c:out></td>

                            <td><a href="salvarUsuario?acao=delete&user=${user.id}"><img
                                    src="resources/img/excluir.png" alt="excluir" title="Excluir"
                                    width="20px" height="20px"> </a></td>
                        <td><a href="salvarUsuario?acao=editar&user=${user.id}"><img
                                    alt="Editar" title="Editar" src="resources/img/editar.png"
                                    width="20px" height="20px"></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </body>
</html>