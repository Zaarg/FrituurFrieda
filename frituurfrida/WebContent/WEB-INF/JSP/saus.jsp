<%-- Een welkom pagina --%> 
<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%> 
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html lang='nl'>
  <head>
    <c:import url="/WEB-INF/JSP/head.jsp">
  		<c:param name='title' value='Sauzen' /> 
  	</c:import>
  </head>
  <body>
    <vdab:menu/> 
    <h1>Fritteke's Sauzen</h1>
    <form method="post" id="verwijderlijst" action="<c:url value='/sauzen/verwijderen.htm'/>">
    <ul class='zebra'>
    <c:forEach var='saus' items='${sauzen}'>
  		<li>
			<label><input type='checkbox' name='nummer' value='${saus.nummer}'>
	             	<c:out value='${saus.naam}'/>
	           	<img src="images/${saus.naam}.png" alt="${saus.naam}">
				<c:forEach items="${saus.ingredienten}" var="ingredient" varStatus="status">
					${ingredient}
					<c:if test="${!status.last}">
						,&nbsp;
					</c:if>
				</c:forEach>
			</label>
		</li> 
	</c:forEach>
    </ul>
    <input type='submit' value='Aangevinkte sauzen verwijderen'>
    </form>
  </body>
</html>