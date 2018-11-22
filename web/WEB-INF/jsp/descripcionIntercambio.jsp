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
    </head>
    <body>
        <h1>Descripcion Intercambio</h1>
        <label>Nombre del Intercambio</label>${intercambio.nombre}<br/>
        <label>Monto Maximo del Intercambio</label>${intercambio.montoMaximo}<br/>
        <label>Fecha limite para aceptar el Intercambio</label>${intercambio.fechaLimite}<br/>
        <label>Fecha del Intercambio</label>${intercambio.fechaIntercambio}<br/>
        <label>Comentarios</label>${intercambio.comentarios}<br/>
        <button><a href="agregarUsuario.htm?correo=${correo}&idIntercambio=${intercambio.id}">Aceptar Intercambio</a></button>
        <button><a href="listaIntercambios.htm?correo=${correo}">Declinar</a></button>
        <button><a href="paginaBienvenida.htm?correo=${correo}">Pagina de Inicio</a></button>
        <button><a href="index.htm">Salir</a></button>
    </body>
</html>
