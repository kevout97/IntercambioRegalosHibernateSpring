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
    </head>
    <body>
        <h1>Pagina de Inicio</h1>
        <button><a href="registroIntercambio.htm?correo=${usuario.correo}">Crear Intercambio</a></button>
        <button><a href="listaIntercambios.htm?correo=${usuario.correo}">Ver Intercambios</a></button>
        <button><a href="listaAmigos.htm?correo=${usuario.correo}">Ver Amigos</a></button>
        <button><a href="index.htm">Salir</a></button>
    </body>
</html>
