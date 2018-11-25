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
        <link href="Css/bootstrap/bootstrap.min.css" rel="stylesheet" />
        <link href="Css/css_inicio.css" rel="stylesheet" />
    </head>
    <body>
        <div class="fondo" style="background-image: url(Images/Registro.png)">
            <header>
                <button class="login-button-salir-small"><a href="index.htm">Salir</a></button>
            </header>
            <mvc:form class="login" modelAttribute="usuario" action="altaUsuario.htm">
                <mvc:input path="nombre" type="text" placeholder="Nombre" class="login-input" />
                <mvc:input path="correo" type="email" placeholder="Email" class="login-input"/>
                <mvc:input path="contrasenia" type="password" placeholder="Password" class="login-input"/>
                <mvc:input path="alias" type="text" placeholder="Alias" class="login-input"/>
                <mvc:input path="registrado" type="hidden" value="true" class="login-input"/>
                <input type="submit" value="Guardar" class="login-button-registro"/>
            </mvc:form>
        </div>
    </body>
</html>