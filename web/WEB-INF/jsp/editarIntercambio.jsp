<%-- 
    Document   : editarIntercambio
    Created on : 20/11/2018, 09:17:31 AM
    Author     : kevout
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Intercambio</title>
        <link href="Css/bootstrap/bootstrap.min.css" rel="stylesheet" />
        <link href="Css/css_inicio.css" rel="stylesheet" />
    </head>
    <body>
         <div class="fondo" style="background-image: url(Images/Crear.png)">
            <ul>
                <li><a href="paginaBienvenida.htm?correo=${usuario.correo}">Inicio</a></li>
                <li><a href="registroIntercambio.htm?correo=${usuario.correo}">Crear Intercambio</a></li>
                <li><a href="listaAmigos.htm?correo=${usuario.correo}">Ver Amigos</a></li>
                <li><a href="index.htm">Salir</a></li>
            </ul>
                <br><br><br><br>
        
            <form action="cambioIntercambio.htm" method="POST" class="login form-group">
                <h1 class="login-title">Editar Intercambio</h1>
                <label>Nombre:</label>
                <input name="nombre" type="text" value="${intercambio.nombre}" class="login-input"/>
                <label>Tema:</label><br>
                <select name="tema">
                    <c:forEach var="varTema" items="${temas}">
                        <c:choose>
                            <c:when test="${intercambio.tema.nombreTema == varTema.nombreTema}">
                                <option selected="true" value="${varTema.getNombreTema()}">${varTema.getNombreTema()}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${varTema.getNombreTema()}">${varTema.getNombreTema()}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                <br><br><label>Monto Maximo:</label>
                <input name="montoMaximo" type="number" value="${intercambio.montoMaximo}" class="login-input"/>
                <label>Fecha Limite de Registro:</label>
                <input name="fechaLimite" type="date" value="${intercambio.fechaLimite}"  id="fecha_limite"/>
                <label>Fecha del Intercambio:</label>
                <input name="fechaIntercambio" type="date" value="${intercambio.fechaIntercambio}" id="fecha_intercambio"/>
                <label>Comentarios:</label>
                <textarea name="comentarios" rows="4" cols="50" id="comentarios">${intercambio.comentarios}</textarea>
                <input type="hidden" name="correo" value="${usuario.correo}"/>
                <input type="hidden" name="idIntercambio" value="${intercambio.id}"/>
                <input type="submit" value="Actualizar Intercambio" class="login-button-registro"/>
            </form>
         </div>
    </body>
</html>
