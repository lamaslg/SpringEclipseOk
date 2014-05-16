

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
    <c:if test="${pageContext.request.userPrincipal.name!=null}">
    Bienvenido ${pageContext.request.userPrincipal.name}
     <a href='<c:url value="j_spring_security_logout" />'>Logout</a>
    
    </c:if>
    
    
        Empleados de la compañia a dia 
        <fmt:formatDate value="${fecha}" />
        
        
        <a href="AdminAltaEmpleado.htm">Nuevo empleado</a>
        <a href='<c:url value="j_spring_security_logout" />'>Logout</a>
        <table id="tablita">
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
                <img src='<c:url value="${empleado.foto }"/>' />
                    ${empleado.nombre}
                </td>
                <td>
                    ${empleado.salario}
                </td>
                <td>
                		<a href="#"  class="borr" data-code="${empleado.idEmpleado}">
                		Borrar empleado
                		</a>
                		<a href="ModificarEmpleado.htm?id=${empleado.idEmpleado}">
                		Modificar empleado
                		</a>
                </td>
            </tr>
                
            </c:forEach>
        </table>
        <script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.1.min.js" />'></script>
   		
   		<script type="text/javascript">
   		
   		$(document).ready(function(){
   			$(".borr").click(function(){
   				
   				var enl=this.getAttribute('data-code');
   				var celda=this.parentNode;
   				var fila=celda.parentNode;
   				
   				
   				var data={idEmpleado:enl};
   				data=JSON.stringify(data);
   				
   				$.ajax(
   				"empleado",
   				{
   					data: data,
   					method: 'DELETE',
   					contentType: 'application/json',
   					success: function(xhr){
   						alert(xhr.idEmpleado +" ha sido dado de baja");
   						fila.parentNode.removeChild(fila);
   						
   						
   						
   						
   					},
   					error: function(xhr){
   						
   						alert(JSON.stringify(xhr));
   						
   					}
   					
   				}
   				
   				);
   				
   				
   				
   				
   			});
   			
   			
   			
   			
   			
   		});
   		
   		</script>
   
   
    </body>
</html>





















