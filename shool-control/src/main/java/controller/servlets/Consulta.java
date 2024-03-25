package controller.servlets;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.Queries;
import model.javabeans.Carrera;
import jakarta.servlet.annotation.WebServlet;

import java.sql.Connection;


@WebServlet(urlPatterns = {"/consulta"})
public class Consulta extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/carrera.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conexion = Queries.createConnection();
        String consultaCarrera = request.getParameter("consultaCarrera");
        String rpt;

        try {
                Carrera objCarreraConsulta = Queries.getCarrera(conexion, Queries.clientTable, consultaCarrera);
                if(objCarreraConsulta.getNombre() == null){
                   throw new Exception();
                }
                request.setAttribute("carrera", objCarreraConsulta.getNombre());
        } catch (Exception e) {
                rpt = "No se encuentra disponible " + consultaCarrera + " como carrera en nuestra universidad";
                System.out.println("Error Error");
                request.setAttribute("carrera", rpt);
        } finally {
                RequestDispatcher dispatcher = request.getRequestDispatcher("./view/carrera.jsp");
                dispatcher.forward(request, response);        
        }
        Queries.closeConnection(conexion);
    }
}