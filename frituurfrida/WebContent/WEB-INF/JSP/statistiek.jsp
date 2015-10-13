<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%> 
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html lang='nl'>
  <head>
    <c:import url="/WEB-INF/JSP/head.jsp">
      <c:param name='title' value='Statistiek' />
    </c:import>
  </head>
  <body>
    <vdab:menu/> 
    <h1>Statistiek</h1>
    <c:forEach var='entry' items='${statistiek}'>
  		<li>${entry.key}: ${entry.value}</li>
	</c:forEach> 
    
  </body>
</html> 