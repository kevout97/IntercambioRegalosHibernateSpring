<%-- 
    Document   : descripcionIntercambio
    Created on : 18/11/2018, 03:19:28 PM
    Author     : kevout
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Descripcion intercambio</title>
        <link href="Css/bootstrap/bootstrap.min.css" rel="stylesheet" />
        <link href="Css/css_inicio.css" rel="stylesheet" />
    </head>
    <body>
        <div class="fondo" style="background-image: url(Images/Crear.png)">
            <ul>
                <li><a href="paginaBienvenida.htm?correo=${correo}">Inicio</a></li>
                <li><a href="registroIntercambio.htm?correo=${correo}">Crear Intercambio</a></li>
                <li><a href="listaAmigos.htm?correo=${correo}">Ver Amigos</a></li>
                <li><a href="index.htm">Salir</a></li>
            </ul>
                <br><br><br>
            <form action="listaIntercambios.htm?correo=${correo}" method="POST" class="login form-group">
                <h1 class="login-title">Descripcion Intercambio</h1>
                <label>Nombre del Intercambio:</label> <br>${intercambio.nombre}<br/><br>
                <label>Monto Maximo del Intercambio:</label><br>${intercambio.montoMaximo}<br/><br>
                <label>Fecha limite para aceptar el Intercambio:</label><br>${intercambio.fechaLimite}<br/><br>
                <label>Fecha del Intercambio:</label><br>${intercambio.fechaIntercambio}<br/><br>
                <label>Comentarios:</label><br>${intercambio.comentarios}<br/><br>
                <button class="login-button-registro"><a href="agregarUsuario.htm?correo=${correo}&idIntercambio=${intercambio.id}">Aceptar Intercambio</a></button>
                <input type="submit" value="Regresar" class="login-button"/>
            </form>
    </body>
</html>


