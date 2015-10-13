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
    <h1>Raad De Saus!</h1>
	    
	Te Raden Saus: ${sausspel.getJuist()} <br/>
	    
	
	<form action="<c:url value='/raaddesaus.htm'/>" method="post">    
	<c:choose>   
	    <c:when test="${sausspel.getSpelstatus() == 'bezig'}">
			    <label>Gok een letter: <input name='gok' value='${param.gok}' maxlength='1' size='1' required autofocus ><br/></label>
			    <input type='submit' name='raden' value='Raden'> <br/> <br/>
  		</c:when>
  		<c:when test="${sausspel.getSpelstatus() == 'gewonnen'}">
	  		<h1>YOU LIVE!!</h1>
	  		De saus was inderdaad ${sausspel.getSaus()} 
	  	</c:when>
  	  	<c:when test="${sausspel.getSpelstatus() == 'verloren'}">
	  		<h1>YOU DIE!!</h1>
	  		De saus was ${sausspel.getSaus()}, helaas. 
	  	</c:when>
  	</c:choose>
  	<input type='submit' name='nieuwspel' value='Nieuw Spel'> <br/> <br/>
  	</form>
  	<img src='<c:url value="/images/${sausspel.getKeerGeraden()}.png"/>' alt='voortgang'/>
  	<script>
      document.getElementById('toevoegform').onsubmit = function() {
        document.getElementById('toevoegknop').disabled=true;
      };
    </script>
  </body>
</html> 


<%-- <c:forEach var='friet' items='${frieten.findAll()}'> --%>
<%-- 	        <button type='submit' name='volgnummer' value='${friet.id}' <c:if test="${gevonden}"><c:out value="disabled='disabled'"/></c:if>> --%>
<%-- 	  			<c:choose> --%>
<%-- 				    <c:when test="${!friet.clicked}"> --%>
<%-- 				    	<img src='<c:url value="/images/deurtoe.png"/>' alt='deur toe'/> --%>
<%-- 				    </c:when> --%>
<%-- 				    <c:when test="${friet.clicked && !friet.deWareFriet}"> --%>
<%-- 				    	<img src='<c:url value="/images/deuropen.png"/>' alt='deur open'/> --%>
<%-- 				    </c:when> --%>
<%-- 				    <c:when test="${friet.clicked && friet.deWareFriet}"> --%>
<%-- 				    	<img src='<c:url value="/images/gevonden.png"/>' alt='gevonden'/> --%>
<%-- 				    </c:when> --%>
<%-- 			    </c:choose>	 --%>
<!-- 			</button>  -->
<%-- </c:forEach><br/> --%>