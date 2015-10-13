<%-- Een welkom pagina --%> 
<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<fmt:setBundle basename='resourceBundles.teksten'/>
<!doctype html>
<html lang='nl'>
  <head>
    <fmt:message key='Frituur' var='title'/>
    <c:import url="/WEB-INF/JSP/head.jsp">
  		<c:param name='title' value='${title}' /> 
  	</c:import>
  </head>
  <body>
    <vdab:menu/>
    <h1><fmt:message key='Frituur'/></h1>
    <h2><fmt:message key='Vandaag${openClosed}'/></h2>
    <fmt:message key='Pic${openClosed}' var='afbeelding'/>
    <img src='<c:url value="images/${afbeelding}.png"/>' alt="<fmt:message key='${openGesloten}'/>">
    <fmt:formatNumber value='${adres.gemeente.postcode}' groupingUsed='false' var='postcode'/>
    <p><fmt:message key='Adres'>
          <fmt:param value='${adres.straat}'/>
          <fmt:param value='${adres.huisNr}'/>
          <fmt:param value='${postcode}'/>
          <fmt:param value='${adres.gemeente.naam}'/>
    </fmt:message></p>
  </body>
</html>