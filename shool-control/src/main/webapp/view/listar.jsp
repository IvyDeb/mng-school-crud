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
    <h1>Lista de carreras</h1>
    <jsp:include page="navbar.jsp" flush="true"></jsp:include>
    <c:choose>
      <c:when test="${empty carreraEliminada}">
        <ul>
          <c:forEach var="carrera" items="${requestScope.misCarreras}">
            <li>
              ${carrera.getNombre()}
              <span
                ><a href="listar?carreraEliminada=${carrera.nombre}"
                  >Borrar</a
                ></span
              >
            </li>
          </c:forEach>
        </ul>
      </c:when>
      <c:otherwise>
        <ul>
          <c:forEach var="carrera" items="${requestScope.misCarreras}">
            <li>
              ${carrera.getNombre()}
              <span
                ><a href="listar?carreraEliminada=${carrera.nombre}"
                  >Borrar</a
                ></span
              >
            </li>
          </c:forEach>
        </ul>
        <p>${carreraEliminada}</p>
      </c:otherwise>
    </c:choose>
  </body>
</html>
