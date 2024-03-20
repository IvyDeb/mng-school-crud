package servlets;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import dao.Queries;
import javabeans.Carrera;
import java.sql.Connection;
import java.util.ArrayList;


@WebServlet(urlPatterns = {"/home"})
public class Home extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hola = "hola";
        request.setAttribute("ejemplo", hola);
        Connection conexion = Queries.createConnection();
        ArrayList<Carrera> misCarreras = Queries.getCarreras(conexion, Queries.clientTable);
        request.setAttribute("misCarreras", misCarreras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
        Queries.closeConnection(conexion);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rpt = request.getParameter("opcion");
        RequestDispatcher dispatcher;
        Connection conexion = Queries.createConnection();
        switch (rpt) {
            case "Carrera":
                dispatcher = request.getRequestDispatcher("carrera.jsp");
                dispatcher.forward(request, response);
            break;
            
            case "Crear":
                dispatcher = request.getRequestDispatcher("crear.jsp");
                dispatcher.forward(request, response);
            break;
            
            case "Listar":
                ArrayList<Carrera> misCarreras = Queries.getCarreras(conexion, Queries.clientTable);
                request.setAttribute("misCarreras", misCarreras);
                dispatcher = request.getRequestDispatcher("listar.jsp");
                dispatcher.forward(request, response);
                break;
            case "Modificar":
                dispatcher = request.getRequestDispatcher("modificar.jsp");
                dispatcher.forward(request, response);
                break;
            default:
                //Se fija uno a uno el que llega a tener un valor para hacer la consulta determiknada
                if(request.getParameter("consultaCarrera") == null){
                    if(request.getParameter("nuevaCarrera") == null){
                        if(request.getParameter("carreraModificar") == null){
                            System.err.println("Error");
                        }
                    }
                }else {
                    
                }
                break;
        }
        Queries.closeConnection(conexion);
    }
}