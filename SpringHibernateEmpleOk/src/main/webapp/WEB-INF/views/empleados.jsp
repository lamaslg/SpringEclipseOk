

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Empleados de la compañia a dia 
        <fmt:formatDate value="${fecha}" />
        
        
        <a href="AltaEmpleado.htm">Nuevo empleado</a>
        
        <table>
            <tr>
                <td>
                    Nombre
                </td>
                <td>
                    Salario
                </td>
                <td>Acciones</td>
            </tr>
            <c:forEach items="${empleados}" var="empleado">
                 <tr>
                <td>
                    ${empleado.nombre}
                </td>
                <td>
                    ${empleado.salario}
                </td>
                <td>
                		<a href="#" id="lnkBor" data-code="${empleado.idEmpleado}">
                		Borrar empleado
                		</a>
                		<a href="ModificarEmpleado.htm?id=${empleado.idEmpleado}">
                		Modificar empleado
                		</a>
                </td>
            </tr>
                
            </c:forEach>
        </table>
        
    </body>
</html>










