<%-- 
    Document   : clientes
    Created on : 27 abr. 2022, 22:48:46
    Author     : snz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CLIENTES</title>
    </head>
    <body>
        <h1>Lista de Cientes </h1>
        
        <u>
            <c:forEach var="cliente" items="$(clientes)"><!-- comment -->
            <li> $(cliente.idCliente) $(cliente.nombre) $(cliente.apellido) $(cliente.email) $(cliente.telefono) $(cliente.saldo) </li>
            </c:forEach>  
        </u>
        
    </body>
</html>
