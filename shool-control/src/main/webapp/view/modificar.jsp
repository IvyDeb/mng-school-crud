<%@ page import="java.util.ArrayList" %> <%@ page
import="model.javabeans.Carrera" %> <%@ page isELIgnored="false" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <h1>Modificar</h1>
    <jsp:include page="navbar.jsp" flush="true"></jsp:include>
    <c:choose>
      <c:when test="${empty carrera}">
        <form method="post">
          <label for="modificarCarrera">Carrera a modificar</label>
          <input type="text" name="modificarCarrera" />
          <label for="carrera">Nuevo nombre</label>
          <input type="text" name="carrera" />
          <input type="submit" value="submit" />
        </form>
      </c:when>
      <c:otherwise>
        <p>${carrera}</p>
      </c:otherwise>
    </c:choose>
  </body>
</html>
