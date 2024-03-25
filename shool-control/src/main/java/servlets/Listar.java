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

import com.mysql.cj.QueryInfo;


@WebServlet(urlPatterns = {"/listar"})
public class Listar extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conexion = Queries.createConnection();
        String carreraEliminada = request.getParameter("carreraEliminada");
        System.out.println(carreraEliminada);
        System.out.println("hola");
        ArrayList<Carrera> misCarreras = Queries.getCarreras(conexion, Queries.clientTable);
        if(carreraEliminada != null){
            this.procesarSolicitud(request, response, misCarreras, carreraEliminada);
            request.setAttribute("misCarreras", misCarreras);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
            dispatcher.forward(request, response);
        } else {
        request.setAttribute("misCarreras", misCarreras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
        dispatcher.forward(request, response);
        Queries.closeConnection(conexion);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Connection conexion = Queries.createConnection();
        // String carreraAEliminar = request.getParameter("carreraEliminada");
        // String rpt;

        // try {
        //     Queries.deleteRecord(conexion, Queries.clientTable, carreraAEliminar);
        //     rpt = "Carrera eliminada correctamente";
        //     request.setAttribute("carrera", rpt);

        // } catch (Exception e) {
        //     rpt = "Error, ingrese un valor valido";
        //     request.setAttribute("carrera", rpt);
        //     System.out.println("Error, ingrese un valor valido");
        // } finally {
        //     RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
        //     dispatcher.forward(request, response);            
        // }
        // Queries.closeConnection(conexion);
    }

    protected void procesarSolicitud(HttpServletRequest request, HttpServletResponse response, ArrayList<Carrera> carreras, String carreraAEliminar) throws ServletException, IOException {
        Connection conexion = Queries.createConnection();
        // String carreraAEliminar = request.getParameter("carreraEliminada");
        String rpt;

        try {
            Queries.deleteRecord(conexion, Queries.clientTable, carreraAEliminar);
            rpt = "Carrera eliminada correctamente";
            request.setAttribute("carreraEliminada", rpt);

        } catch (Exception e) {
            rpt = "Error, ingrese un valor valido";
            request.setAttribute("carreraEliminada", rpt);
            System.out.println("Error, ingrese un valor valido");
        } 
        // } finally {
        //     request.setAttribute("misCarreras", carreras);
        //     RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
        //     dispatcher.forward(request, response);            
        // }
    }


    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Connection conexion = Queries.createConnection();
        // String carreraAEliminar = request.getParameter("carrera");
        // String rpt;

        // try {
        //     Queries.deleteRecord(conexion, Queries.clientTable, carreraAEliminar);
        //     rpt = "Carrera eliminada correctamente";
        //     request.setAttribute("carrera", rpt);

        // } catch (Exception e) {
        //     rpt = "Error, ingrese un valor valido";
        //     request.setAttribute("carrera", rpt);
        //     System.out.println("Error, ingrese un valor valido");
        // } finally {
        //     RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
        //     dispatcher.forward(request, response);            
        // }
        // Queries.closeConnection(conexion);
    }
}