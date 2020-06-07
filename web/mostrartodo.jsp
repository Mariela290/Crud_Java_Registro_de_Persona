<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>

        <h1>Todos los registros</h1>
        <br>
        <a class="btn btn-success" href="index.jsp">Regresar al Formulario de Registro....</a>
        <hr>
        <c:forEach var="listatotal" items="${sessionScope.personas}">
            Dui:  ${listatotal.dui}<br>
            Apellidos: ${listatotal.apellidos}<br>
            Nombres:${listatotal.nombres}<br>
            <br>
            <a class="btn btn-primary " href="editar.do?dui=${listatotal.dui}">Modificar</a>
             <a class = "btn btn-danger" href="meliminar.do?dui=${listatotal.dui}">Eliminar</a>
            <hr>
            
        </c:forEach>
 
</html>
