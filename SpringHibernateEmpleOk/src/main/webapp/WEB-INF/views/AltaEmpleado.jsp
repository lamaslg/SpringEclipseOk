<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="tags.jsp"  %>
<%@taglib uri="http://www.springframework.org/tags/form" 
          prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form:form method="post" commandName="empleado"
                   
                   >
            <label>Nombre:</label>
            <br>
            <form:input path="nombre" />
            <form:errors path="nombre" />
            <br>
            <label>Salario</label>
            <form:input path="salario" />
            <form:errors path="salario" />
            <br>
            <label>Puesto</label>
            <form:select path="puesto" >
            <form:option value="-1" label="-De que curra este-"></form:option>
            		<form:options items="${puestos}"/>
            </form:select>
            <br>
            <label>Conocimientos</label>
            <form:select path="conocimientos" 
            				items="${conocimientos}" multiple="true">
            </form:select>
            
            <input type="submit" value="Ok">
            
        </form:form>
        
    </body>
</html>











