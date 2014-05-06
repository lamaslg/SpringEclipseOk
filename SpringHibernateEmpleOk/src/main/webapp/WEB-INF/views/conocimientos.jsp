<%-- 
    Document   : conocimientos
    Created on : 29-abr-2014, 18:56:01
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <fmt:formatDate value="${fecha}" />
        
        <table>
            <tr>
                <td>
                    Nombre
                </td>
                <td>
                    Salario
                </td>
            </tr>
            <c:forEach items="${conocimientos}" var="conocimiento">
                 <tr>
                <td>
                    ${conocimiento.nombre}
                </td>
               
            </tr>
                
            </c:forEach>
        </table>
    </body>
</html>
