<%-- Een welkom pagina --%> 
<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%> 

<!doctype html>
<html lang='nl'>
  <head>
    <c:import url="/WEB-INF/JSP/head.jsp">
  		<c:param name='title' value='Frituur Fritteke' /> 
  	</c:import>
  	<style type="text/css">
    	body {background-color: rgb(${red},${green},${blue})}
    </style>
  </head>
  <body>
    
  </body>
</html>