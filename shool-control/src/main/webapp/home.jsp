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
    <h1>Sos un crack</h1>
    <form action="home" method="post">
      <input type="submit" name="opcion" value="Carrera" />
      <input type="submit" name="opcion" value="Crear" />
      <input type="submit" name="opcion" value="Listar" />
      <input type="submit" name="opcion" value="Modificar" />
    </form>
  </body>
</html>
