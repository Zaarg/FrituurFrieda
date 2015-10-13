<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%> 
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html lang='nl'>
  <head>
    <c:import url="/WEB-INF/JSP/head.jsp">
      <c:param name='title' value='Geslacht'/>
    </c:import>
  </head>
  <body>
    <vdab:menu/> 
    <c:choose>
	    <c:when test="${empty cookie.geslacht.value}">
	    	<link rel='stylesheet' href='styles/default.css'>
	    </c:when>
	    <c:when test="${cookie.geslacht.value =='jongen'}">
	    	<link rel='stylesheet' href='styles/jongen.css'>
	    </c:when>
	    <c:when test="${cookie.geslacht.value =='meisje'}">
	    	<link rel='stylesheet' href='styles/meisje.css'>
	    </c:when>
    </c:choose>
    <h1>Meisje of Jongen?</h1>
    <form method="post" action="<c:url value='/geslacht.htm'/>">
  		<input type="submit" name="meisjesjongens" value="meisje">
  		<input type="submit" name="meisjesjongens" value="jongen">
	</form> 
  </body>
</html> 