<%-- 
    Document   : listaAmigos
    Created on : 18/11/2018, 03:20:57 PM
    Author     : kevout
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intercambio Regalos</title>
    </head>
    <body>
        <h1>Intercambio de Regalos</h1>
        <table>
            <tr>
                <th>Nombre del Amigo</th>
                <th>Correo</th>
            </tr>
            <c:forEach var="amigo" items="${amigos}">
                <tr>
                    <td>${amigo.usuarioByCorreoAmigo.nombre}</td>
                    <td>${amigo.usuarioByCorreoAmigo.correo}</td>
                </tr>
            </c:forEach>
        </table>
        <form action="altaAmigos.htm" method="POST">
            <input type="email" name="correoAmigo" placeholder="email"/>
            <input type="hidden" name="correo" value="${correo}"/>
            <input type="submit" value="Añadir amigo"/>
        </form>
        <button><a href="paginaBienvenida.htm?correo=${correo}">Pagina de Inicio</a></button>
        <button><a href="index.htm">Salir</a></button>
    </body>
</html>
