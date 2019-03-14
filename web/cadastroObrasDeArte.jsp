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

        <form action="salvarObras" method="post" id="formObra">
            <ul class="form-style-1">
                <li>
                    <table>
                        <tr>
                            <td>Código:</td>
                            <td><input type="text" readonly="readonly" id="id" name="id"
                                       value="${obra.id}" class="field-long"></td>
                        </tr>
                        <tr>
                            <td>Titulo:</td>
                            <td><input type="text" id="titulo" name="titulo"
                                       value="${obra.titulo}"></td>
                        </tr>

                        <tr>
                            <td>Data:</td>
                            <td><input type="text" id="data" name="data"
                                       value="${obra.data}"></td>
                        </tr>
                        <tr>
                            <td>Técnico:</td>
                            <td><input type="text" id="tecnico" name="tecnico"
                                       value="${obra.tecnico}"></td>
                        </tr>
                        
                         <tr>
                            <td>Dimensões Fisica:</td>
                            <td><input type="text" id="dimensoe_fisica" name="dimensoe_fisica"
                                       value="${obra.dimensoe_fisica}"></td>
                        </tr>
                        
                         <tr>
                            <td>Autor:</td>
                            <td><input type="text" id="autor" name="autor"
                                       value="${obra.autor}"></td>
                        </tr>
                        
                         <tr>
                            <td>Procedencia:</td>
                            <td><input type="text" id="procedencia" name="procedencia"
                                       value="${obra.procedencia}"></td>
                        </tr>
                        
                         <tr>
                            <td>Tipo:</td>
                            <td><input type="text" id="tipo" name="tipo"
                                       value="${obra.tipo}"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Salvar"> <input type="submit"  value="Cancelar" onclick="document.getElementById('formObra').action = 'salvarObras?acao=reset'"></td>
                        </tr>
                    </table>

                </li>
            </ul>
        </form>

        <div class="container">
            <table class="responsive-table">
                <caption>Lisa de Obras</caption>
                <tr>
                    <th>Id</th>
                    <th>Titulo</th>
                    <th>Data</th>
                    <th>Tecnico</th>th>
                    <th>Dimensões Fisica</th>
                    <th>Autor</th>
                    <th>Procedencia</th>th>
                    <th>Tipo</th>
                </tr>
                <c:forEach items="${obras}" var="obra">
                    <tr>
                        <td style="width: 150px"><c:out value="${obra.id}">
                            </c:out></td>
                        <td style="width: 150px"><c:out value="${obra.titulo}">
                            </c:out></td>
                        <td><c:out value="${obra.data}"></c:out></td>
                        
                        <td style="width: 150px"><c:out value="${obra.tecnico}">
                            </c:out></td>
                        <td style="width: 150px"><c:out value="${obra.dimensoe_fisica}">
                            </c:out></td>
                        <td><c:out value="${obra.autor}"></c:out></td>
                         <td style="width: 150px"><c:out value="${obra.procedencia}">
                            </c:out></td>
                        <td><c:out value="${obra.tipo}"></c:out></td>

                            <td><a href="salvarObras?acao=delete&obra=${obra.id}"><img
                                    src="resources/img/excluir.png" alt="excluir" title="Excluir"
                                    width="20px" height="20px"> </a></td>
                        <td><a href="salvarObras?acao=editar&obra=${obra.id}"><img
                                    alt="Editar" title="Editar" src="resources/img/editar.png"
                                    width="20px" height="20px"></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </body>
</html>