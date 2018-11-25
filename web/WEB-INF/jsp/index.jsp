<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intercambio regalos</title>
        <link href="Css/bootstrap/bootstrap.min.css" rel="stylesheet" />
        <link href="Css/css_inicio.css" rel="stylesheet" />
    </head>

    <body>
        <div style="background-image: url(Images/Inicio.png)" class="fondo">
            <form class="login" action="inicioSesion.htm" method="POST">
                <h1 class="login-title">Inicio</h1>
                <img src="Images/Log.png" class="person" alt="hi">
                <input type="email" name="correo" placeholder="Email" class="login-input"/>
                <input type="password" name="contrasenia" placeholder="Password" class="login-input"/>
                <input type="submit" value="Ingresar" class="login-button"/>
                <button class="login-button-registro"><a href="registroUsuario.htm">Registro</a></button>
              </form>
        </div>
        
</html>

