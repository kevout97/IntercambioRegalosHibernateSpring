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
        <link href="Css/bootstrap/bootstrap.min.css" rel="stylesheet" />
        <link href="Css/css_inicio.css" rel="stylesheet" />
    </head>
    <body>
        <div class="fondo" style="background-image: url(Images/Crear.png)">
            <ul>
                <li><a href="paginaBienvenida.htm?correo=${correo}">Inicio</a></li>
                <li><a href="registroIntercambio.htm?correo=${correo}">Crear Intercambio</a></li>
                <li><a href="listaAmigos.htm?correo=${correo}">Ver Amigos</a></li>
                <li><a href="index.htm">Salir</a></li>
            </ul>
                <br><br><br><br><br>
            <table class="GeneratedTable">
                <thead>
                    <tr>
                        <th>Id del Intercambio</th>
                        <th>Nombre del Intercambio</th>
                        <th>Tema del Intercambio</th>
                        <th>Monto Maximo del Intercambio</th>
                        <th>Fecha Limite del Intercambio</th>
                        <th>Fecha del Intercambio</th>
                        <th>Persona que me toco</th>
                        <th>Comentarios</th>
                        <th>opciones</th>
                    </tr>
                </thead>
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
                        <c:if test="${userInter.creadorIntercambio == true }">
                            <td>
                                <c:if test="${userInter.sortear == true}" >
                                <c:forEach var="usuaInterAll" items="${usuarioIntercambiosAll}">
                                   
                                    <c:if test="${userInter.intercambio.id == usuaInterAll.intercambio.id}">
                                        A:
                                        <c:forEach var="usuario" items="${usuarios}">
                                            <c:if test="${usuario.correo == usuaInterAll.usuario.correo}">
                                                ${usuario.nombre} (${usuario.correo})
                                            </c:if>
                                        </c:forEach>
                                         le toco:
                                        <c:forEach var="usuario" items="${usuarios}">
                                            <c:if test="${usuario.correo == usuaInterAll.idIntercambiar}">
                                                ${usuario.nombre} (${usuario.correo})
                                            </c:if>
                                        </c:forEach>
                                                 <br/>
                                    </c:if>
                                </c:forEach>
                                </c:if>
                            </td>
                            <td>
                                <button class="button-tabla"><a href="editarIntercambio.htm?idIntercambio=${userInter.intercambio.id}&correo=${userInter.usuario.correo}">Editar</a></button>
                                <button class="button-tabla-elim"><a href="bajaIntercambio.htm?idIntercambio=${userInter.intercambio.id}&correo=${userInter.usuario.correo}">Eliminar</a></button>
                                
                                <c:if test="${userInter.sortear == false}" >
                                    <form action="realizarSorteo.htm" method="POST">
                                        <input type="hidden" name="idIntercambio" value="${userInter.intercambio.id}"/>
                                        <input type="hidden" name="correo" value="${userInter.usuario.correo}"/>
                                        <input type="submit" value="Sortear" class="button-tabla"/>
                                    </form>
                                    
                                </c:if>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
            <br><br>
            <form action="descripcionIntercambio.htm" method="POST" class="login form-group">
                <h1 class="login-title">Buscar Intercambio</h1>
                <input type="number" name="idIntercambio" placeholder="Id Intercambio" class="login-input"/>
                <input type="hidden" name="correo" value="${correo}"/>
                <input type="submit" value="Buscar" class="login-button-registro"/>
            </form>
        </div>
    </body>
</html>


