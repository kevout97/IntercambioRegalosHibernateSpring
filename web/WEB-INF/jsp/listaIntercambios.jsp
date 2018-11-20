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
                <th>Persona que me toco</th>
                <th>Comentarios</th>
            </tr>
            <c:forEach var="userInter" items="${usuarioIntercambios}">
                <tr>
                    <td>${userInter.intercambio.id}</td>
                    <td>${userInter.intercambio.nombre}</td>
                    <td>${userInter.intercambio.tema.nombreTema}</td>
                    <td>${userInter.intercambio.montoMaximo}</td>
                    <td>${userInter.intercambio.fechaLimite}</td>
                    <td>${userInter.intercambio.fechaIntercambio}</td>
                    <td>
                        <c:forEach var="usuario" items="${usuarios}">
                            <c:if test="${usuario.correo == userInter.idIntercambiar}">
                                ${usuario.nombre}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>${userInter.intercambio.comentarios}</td>
                    <c:if test="${userInter.creadorIntercambio}">
                        <td><button><a href="editarIntercambio.htm?idIntercambio=${userInter.intercambio.id}&correo=${userInter.usuario.correo}">Editar</a></button>
                        <td><button><a href="bajaIntercambio.htm?idIntercambio=${userInter.intercambio.id}&correo=${userInter.usuario.correo}">Eliminar</a></button>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
