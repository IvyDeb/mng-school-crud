package controller.servlets;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.Queries;
import jakarta.servlet.annotation.WebServlet;

import java.sql.Connection;


@WebServlet(urlPatterns = {"/modificar"})
public class Modificar extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/modificar.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conexion = Queries.createConnection();
        String modificarCarrera = request.getParameter("modificarCarrera");
        String nuevaCarreraModificada = request.getParameter("carrera");
        String rpt;

        try {
            if(modificarCarrera == "" || nuevaCarreraModificada == ""){
                throw new Exception();
            }
            String id = String.valueOf(Queries.getCarrera(conexion, Queries.clientTable, modificarCarrera).getId());
            Queries.updateData(conexion, Queries.clientTable, id, nuevaCarreraModificada);
            rpt = "Carrera actualizada correctamente";
            request.setAttribute("carrera", rpt);

        } catch (Exception e) {
            rpt = "Error, ingrese un valor valido";
            request.setAttribute("carrera", rpt);
            System.out.println("Error, ingrese un valor valido");
        } finally {
            RequestDispatcher dispatcher = request.getRequestDispatcher("./view/modificar.jsp");
            dispatcher.forward(request, response);            
        }

        Queries.closeConnection(conexion);
    }
}