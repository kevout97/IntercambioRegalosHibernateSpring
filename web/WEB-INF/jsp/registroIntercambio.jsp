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
        <link href="Css/bootstrap/bootstrap.min.css" rel="stylesheet" />
        <link href="Css/css_inicio.css" rel="stylesheet" />
    </head>
    <body>
        <div class="fondo" style="background-image: url(Images/holiday.png)">
            <ul>
                <li><a href="paginaBienvenida.htm?correo=${usuario.correo}">Inicio</a></li>
                <li><a href="listaIntercambios.htm?correo=${usuario.correo}">Ver Intercambios</a></li>
                <li><a href="listaAmigos.htm?correo=${usuario.correo}">Ver Amigos</a></li>
                <li><a href="index.htm">Salir</a></li>
            </ul>
            <br><br><br>
            <form modelAttribute="intercambio" action="altaIntercambio.htm" method="POST" class="login form-group">
                <h1 class="login-title">Registrar Intercambio</h1>
                <label>Nombre:</label>
                <input name="nombre" type="text" placeholder="Nombre del Intercambio" class="login-input"/>
                <label>Tema:</label><br>
                <select name="tema">
                    <c:forEach var="varTema" items="${temas}">
                        <option value="${varTema.getNombreTema()}">${varTema.getNombreTema()}</option>
                    </c:forEach>
                </select>
                <br><br><label>Monto Maximo:</label>
                <input name="montoMaximo" type="number" placeholder="Monto Maximo" class="login-input"/>
                <label>Fecha Limite de Registro:</label>
                <input name="fechaLimite" type="date" placeholder="Fecha limite de registro" id="fecha_limite"/>
                <label>Fecha del Intercambio:</label>
                <input name="fechaIntercambio" type="date" placeholder="Fecha del Intercambio" id="fecha_intercambio"/>
                <label>Comentarios:</label>
                <textarea name="comentarios" placeholder="Escribe tus comentarios" rows="4" cols="50" id="comentarios"></textarea>
                <input type="hidden" name="correo" value="${usuario.getCorreo()}"/>
                <input type="submit" value="Crear Intercambio" class="login-button-registro"/>
            </form>
        </div>
    </body>
</html>