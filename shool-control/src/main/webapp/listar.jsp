<%@ page import="java.util.ArrayList" %> <%@ page import="javabeans.Carrera" %>
<%@ page isELIgnored="false" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <h1>Lista de carreras</h1>
    <jsp:include page="navbar.jsp" flush="true"></jsp:include>
    <ul>
      <c:forEach var="carrera" items="${requestScope.misCarreras}">
        <li>
          ${carrera.getNombre()} <span><a href="">Borrar</a></span>
        </li>
      </c:forEach>
    </ul>
  </body>
</html>
