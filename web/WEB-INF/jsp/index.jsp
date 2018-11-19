<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intercambio regalos</title>
    </head>

    <body>
        <h1>Intercambio de regalos</h1>
        <form action="inicioSesion.htm" method="POST">
            <input type="email" name="correo" placeholder="Email"/>
            <input type="password" name="contrasenia" placeholder="Password"/>
            <input type="submit" value="Ingresar"/>
        </form>
        <form action="verIntercambio.htm" method="POST">
            <input type="number" name="idIntercambio" placeholder="Id Intercambio"/>
            <input type="submit" value="Ver Intercambio"/>
        </form>
        <button><a href="registroUsuario.htm">Registro</a></button>
    </body>
</html>
