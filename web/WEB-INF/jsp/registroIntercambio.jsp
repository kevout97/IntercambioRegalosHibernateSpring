<%-- 
    Document   : registroIntercambio
    Created on : 18/11/2018, 08:24:48 PM
    Author     : kevout
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Intercambio</title>
    </head>
    <body>
        <h1>Registro Intercambio</h1>
        <form modelAttribute="intercambio" action="altaIntercambio.htm" method="POST">
            <input name="nombre" type="text" placeholder="Nombre del Intercambio"/>
            <select name="tema">
                <c:forEach var="varTema" items="${temas}">
                    <option value="${varTema.getNombreTema()}">${varTema.getNombreTema()}</option>
                </c:forEach>
            </select>
            <input name="montoMaximo" type="number" placeholder="Monto Maximo"/>
            <input name="fechaLimite" type="date" placeholder="Fecha limite de registro"/>
            <input name="fechaIntercambio" type="date" placeholder="Fecha del Intercambio"/>
            <textarea name="comentarios" placeholder="Comentarios"></textarea>
            <input type="hidden" name="correo" value="${usuario.getCorreo()}"/>
            <input type="submit" value="Crear Intercambio"/>
        </form>
        <button><a href="paginaBienvenida.htm?correo=${usuario.correo}">Pagina de Inicio</a></button>
        <button><a href="index.htm">Salir</a></button>
    </body>
</html>
