<%-- 
    Document   : listaIntercambios
    Created on : 18/11/2018, 03:20:42 PM
    Author     : kevout
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Intercambios</title>
    </head>
    <body>
        <h1>Lista Intercambios</h1>
        <table>
            <tr>
                <th>Id del Intercambio</th>
                <th>Nombre del Intercambio</th>
                <th>Tema del Intercambio</th>
                <th>Monto Maximo del Intercambio</th>
                <th>Fecha Limite del Intercambio</th>
                <th>Fecha del Intercambio</th>
                <th>Comentarios</th>
                <th>Persona que me toco</th>
            </tr>
            <c:forEach var="inter" items="${intercambios}">
                <td><input type="label" value="${inter.id}"/></td>
                <td><input type="label" value="${inter.nombre}"/></td>
                <td><input type="label" value="${inter.nombreTema}"/></td>
                <td><input type="label" value="${inter.montoMaximo}"/></td>
                <td><input type="label" value="${inter.fecha_limite}"/></td>
                <td><input type="label" value="${inter.fecha_intercambio}"/></td>
                <td><input type="label" value="${inter.intercambiar}"/></td>
            </c:forEach>
        </table>
    </body>
</html>
