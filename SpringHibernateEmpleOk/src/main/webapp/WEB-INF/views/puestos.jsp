<%-- 
    Document   : puestos
    Created on : 29-abr-2014, 19:39:38
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="tags.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${puestos}" var="puesto">
            <div>
                ${puesto.nombre}
            </div>
            
            
        </c:forEach>
    </body>
</html>
