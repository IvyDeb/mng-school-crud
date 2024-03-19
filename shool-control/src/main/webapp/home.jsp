<%@ page import="java.util.ArrayList" %> <%@ page import="javabeans.Carrera" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <h1>Sos un crack</h1>
    <form method="post">
      <label for="opcion">Opcion</label>
      <input type="text" name="opcion" />
      <input type="submit" value="submit" />
    </form>
    ${requestScope.misCarreras[0].getNombre()}
  </body>
</html>
