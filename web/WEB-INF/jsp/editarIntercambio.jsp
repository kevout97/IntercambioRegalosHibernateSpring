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
    </head>
    <body>
        <h1>Editar Intercambio</h1>
        <form action="cambioIntercambio.htm" method="POST">
            <input name="nombre" type="text" value="${intercambio.nombre}"/>
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
            <input name="montoMaximo" type="number" value="${intercambio.montoMaximo}"/>
            <input name="fechaLimite" type="date" value="${intercambio.fechaLimite}"/>
            <input name="fechaIntercambio" type="date" value="${intercambio.fechaIntercambio}"/>
            <textarea name="comentarios" >${intercambio.comentarios}</textarea>
            <input type="hidden" name="correo" value="${usuario.correo}"/>
            <input type="hidden" name="idIntercambio" value="${intercambio.id}"/>
            <input type="submit" value="Actualizar Intercambio"/>
        </form>
    </body>
</html>
