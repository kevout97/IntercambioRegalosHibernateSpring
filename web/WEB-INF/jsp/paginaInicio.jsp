<%-- 
    Document   : paginaInicio
    Created on : 18/11/2018, 03:19:12 PM
    Author     : kevout
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Inicio</title>
        <link href="Css/css_menu.css" rel="stylesheet" />
    </head>
 
    <body>
        <div style="background-image: url(Images/Home.png)" class="fondo"> 
            <ul>
                <li><a href="registroIntercambio.htm?correo=${usuario.correo}">Crear Intercambio</a></li>
                <li><a href="listaIntercambios.htm?correo=${usuario.correo}">Ver Intercambios</a></li>
                <li><a href="listaAmigos.htm?correo=${usuario.correo}">Ver Amigos</a></li>
                <li><a href="index.htm">Salir</a></li>
            </ul>
        </div>
    </body>
</html>
