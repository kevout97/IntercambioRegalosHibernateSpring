<%-- 
    Document   : registroUsuario
    Created on : 18/11/2018, 07:56:05 PM
    Author     : kevout
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Usuario</title>
    </head>
    <body>
        <h1>Registro Usuario</h1>
        <a href="index.htm">Regresar</a>
        <mvc:form modelAttribute="usuario" action="altaUsuario.htm">
            <mvc:input path="nombre" type="text" placeholder="Nombre"/>
            <mvc:input path="correo" type="email" placeholder="Email"/>
            <mvc:input path="contrasenia" type="password" placeholder="Password"/>
            <mvc:input path="alias" type="text" placeholder="Alias"/>
            <mvc:input path="registrado" type="hidden" value="true"/>
            <input type="submit" value="Guardar"/>
        </mvc:form>
    </body>
</html>
