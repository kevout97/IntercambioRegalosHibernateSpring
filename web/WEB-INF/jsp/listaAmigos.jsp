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
        <link href="Css/bootstrap/bootstrap.min.css" rel="stylesheet" />
        <link href="Css/css_inicio.css" rel="stylesheet" />
    </head>
    <body>
        <div class="fondo" style="background-image: url(Images/Admin.png)">
            <ul>
                <li><a href="paginaBienvenida.htm?correo=${correo}">Inicio</a></li>
                <li><a href="registroIntercambio.htm?correo=${correo}">Crear Intercambio</a></li>
                <li><a href="listaIntercambios.htm?correo=${correo}">Ver Intercambios</a></li>
                <li><a href="index.htm">Salir</a></li>
            </ul>
            <br><br><br><br>
            <table class="GeneratedTable">
                <thead>
                    <tr>
                        <th>Nombre del Amigo</th>
                        <th>Correo</th>
                    </tr>
                </thead>
                <c:forEach var="amigo" items="${amigos}">
                    <tr>
                        <td>${amigo.usuarioByCorreoAmigo.nombre}</td>
                        <td>${amigo.usuarioByCorreoAmigo.correo}</td>
                    </tr>
                </c:forEach>
            </table>
            <form action="altaAmigos.htm" method="POST" class="login form-group">
                <h1 class="login-title">Agregar Amigos</h1>
                <input type="email" name="correoAmigo" placeholder="email" class="login-input"/>
                <input type="hidden" name="correo" value="${correo}"/>
                <input type="submit" value="Añadir" class="login-button-registro"/>
            </form>
        </div>
    </body>
</html>
