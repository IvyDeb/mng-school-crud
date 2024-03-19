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
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rpt = request.getParameter("opcion");
        if(rpt == "1"){
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
    
            // for (Carrera carrera : miCarreras) {
            //     System.out.println();
            // }
        }

    }
}