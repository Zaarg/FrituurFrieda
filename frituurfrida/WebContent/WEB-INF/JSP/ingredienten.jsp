<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%> 
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html lang='nl'>
  <head>
    <c:import url="/WEB-INF/JSP/head.jsp">
      <c:param name='title' value='Ingredienten' />
    </c:import>
  </head>
  <body>
    <vdab:menu/> 
    <h1>Ingredienten</h1>
    <form>
      <label>Ingredient <span>${fouten.ingredient}</span>
      <input name='ingredient' value='${param.ingredient}' autofocus ></label>
      <input type='submit' value='Zoeken'>
    </form>
    <c:if test='${not empty sauzen}'>
      <ul class='zebra'>
        <c:forEach var='saus' items='${sauzen}'>
          <li><c:out value='${saus.naam}' /></li>
        </c:forEach>
      </ul>
    </c:if>
  </body>
</html> 