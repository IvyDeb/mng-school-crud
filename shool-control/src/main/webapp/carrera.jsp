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
    <h1>Carrera</h1>
    <form method="post">
      <label for="opcion">Opcion</label>
      <input type="text" name="opcion" />
      <input type="submit" value="submit" />
    </form>
    <ul>
      <ul>
        <c:forEach var="carrera" items="${requestScope.misCarreras}">
          <li>${carrera.getNombre()}</li>
        </c:forEach>
      </ul>
    
    <ul>
      <li><a href="carrera">Carrera</a></li>
      <li><a href="crear">Crear</a></li>
      <li><a href="listar">Listar</a></li>
      <li><a href="modificar">Modificar</a></li>
    </ul>
    ${requestScope.misCarreras[0].getNombre()}
  </body>
</html>
