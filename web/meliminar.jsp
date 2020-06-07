

<%@page import="modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Persona p = new Persona();
            String id = (String)request.getAttribute("pdui");
            if(p.Eliminar(id))
            {
                request.getRequestDispatcher("mostrar.do").forward(request, response);
            }
            
        %>
    </body>
</html>
