package servlets;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javabeans.Carrera;
import jakarta.servlet.annotation.WebServlet;
import dao.Queries;
import java.sql.Connection;
import java.util.ArrayList;


@WebServlet(urlPatterns = {"/listar"})
public class Listar extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conexion = Queries.createConnection();
        ArrayList<Carrera> misCarreras = Queries.getCarreras(conexion, Queries.clientTable);
        request.setAttribute("misCarreras", misCarreras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conexion = Queries.createConnection();
        String crearCarrera = request.getParameter("nuevaCarrera");
        String rpt;

        try {
            if(crearCarrera == ""){
                throw new Exception();
            }
            Queries.insertData(conexion, Queries.clientTable, crearCarrera);
            rpt = "Carrera creada correctamente";
            request.setAttribute("carrera", rpt);

        } catch (Exception e) {
            rpt = "Error, ingrese un valor valido";
            request.setAttribute("carrera", rpt);
            System.out.println("Error, ingrese un valor valido");
        } finally {
            RequestDispatcher dispatcher = request.getRequestDispatcher("crear.jsp");
            dispatcher.forward(request, response);            
        }
        Queries.closeConnection(conexion);
    }
}