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
    <h1>Consulta carrera</h1>
    <jsp:include page="navbar.jsp" flush="true"></jsp:include>
    <c:choose>
      <c:when test="${empty carrera}">
        <form action="consulta" method="post">
          <label for="consultarCarrera">Ingrese carrera a consultar</label>
          <input type="text" name="consultaCarrera" />
          <input type="submit" value="Consultar" />
        </form>
      </c:when>
      <c:otherwise>
        <form action="consulta" method="post">
          <label for="consultarCarrera">Ingrese carrera a consultar</label>
          <input type="text" name="consultaCarrera" />
          <input type="submit" value="Consultar" />
        </form>
        <p>${carrera}</p>
      </c:otherwise>
    </c:choose>
  </body>
</html>
