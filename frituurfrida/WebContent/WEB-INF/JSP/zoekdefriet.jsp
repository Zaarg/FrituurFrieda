<%@ page contentType='text/html' pageEncoding='UTF-8' %> 
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html lang='nl'>
  <head>
    <c:import url="/WEB-INF/JSP/head.jsp">
      <c:param name='title' value='Zoek de Friet'/>
    </c:import>
  </head>
  <body>
    <vdab:menu/> 
    <h1>Zoek De Friet!</h1>
	    <form action="<c:url value='/zoekdefriet.htm'/>" method="post">
	    <c:forEach var='friet' items='${frieten.findAll()}'>
	        <button type='submit' name='volgnummer' value='${friet.id}' <c:if test="${gevonden}"><c:out value="disabled='disabled'"/></c:if>>
	  			<c:choose>
				    <c:when test="${!friet.clicked}">
				    	<img src='<c:url value="/images/deurtoe.png"/>' alt='deur toe'/>
				    </c:when>
				    <c:when test="${friet.clicked && !friet.deWareFriet}">
				    	<img src='<c:url value="/images/deuropen.png"/>' alt='deur open'/>
				    </c:when>
				    <c:when test="${friet.clicked && friet.deWareFriet}">
				    	<img src='<c:url value="/images/gevonden.png"/>' alt='gevonden'/>
				    </c:when>
			    </c:choose>	
			</button> 
	    </c:forEach><br/> 
	    <input type='submit' name='nieuwspel' value='Nieuw Spel'>
	    </form>  	
  	<script>
      document.getElementById('toevoegform').onsubmit = function() {
        document.getElementById('toevoegknop').disabled=true;
      };
    </script>
  </body>
</html> 