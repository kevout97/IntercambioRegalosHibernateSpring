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
    </head>
    <body>
        <h1>Intercambio de Regalos</h1>
        <table>
            <tr>
                <th>Nombre del Amigo</th>
                <th>Alias del Amigo</th>
                <th>Correo</th>
            </tr>
            <c:forEach var="userInter" items="${usuarioIntercambios}">
                <tr>
                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
