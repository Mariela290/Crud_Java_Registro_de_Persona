<%-- 
    Document   : Mmodificar
    Created on : 06-07-2020, 09:20:20 PM
    Author     : Guido
--%>

<%@page import="modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         <% 
           
           String id = (String)request.getAttribute("pdui");
           Persona person = new Persona();
           Persona p=(Persona)person.list(id);
           
         %>
         
        <div class="container">
            <div  class="container" >
        <h1 class="" >Editar persona</h1>
        <form action="mActualizar.do" method="POST" >
            <input type="hidden" value="<%= p.getDui() %>" name="txtDui" />
            Apellidos: <input class="form-control" type="text" name="txtApellidos" value="<%= p.getApellidos() %>" required /><br>
            Nombres: <input class="form-control" type="text" name="txtNombres" value="<%= p.getNombres() %>"  required /><br>
            <input class="btn btn-primary" type="submit" value="Actualizar registro" />
            
        </form>
            
        </div>
        </div>
    </body>
</html>
