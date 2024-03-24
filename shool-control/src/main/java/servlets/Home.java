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
        // String hola = "hola";
        // request.setAttribute("ejemplo", hola);
        // Connection conexion = Queries.createConnection();
        // ArrayList<Carrera> misCarreras = Queries.getCarreras(conexion, Queries.clientTable);
        // request.setAttribute("misCarreras", misCarreras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
        // Queries.closeConnection(conexion);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // String opcion = request.getParameter("opcion");
        // // if(opcion == null){
        // //     opcion = "default";
        // // }
        // RequestDispatcher dispatcher;
        // // Connection conexion = Queries.createConnection();
        // switch (opcion) {
        //     case "Carrera":
        //         dispatcher = request.getRequestDispatcher("consulta");
        //         dispatcher.forward(request, response);
        //     break;
            
        //     case "Crear":
        //         dispatcher = request.getRequestDispatcher("crear");
        //         dispatcher.forward(request, response);
        //     break;
            
        //     case "Listar":
        //         dispatcher = request.getRequestDispatcher("listar");
        //         dispatcher.forward(request, response);
        //         break;
        //     case "Modificar":
        //         dispatcher = request.getRequestDispatcher("modificar");
        //         dispatcher.forward(request, response);
        //         break;
        // }
        //     default:
        //         //Se fija uno a uno el que llega a tener un valor para hacer la consulta determiknada
        //         String consultaCarrera = request.getParameter("consultaCarrera");
        //         String crearCarrera = request.getParameter("nuevaCarrera");
        //         String modificarCarrera = request.getParameter("modificarCarrera");
        //         String nuevaCarreraModificada = request.getParameter("carrera");
        //         String rpt;
        //         if((consultaCarrera) == null){
        //             if(crearCarrera == null){
        //                 if(modificarCarrera == null){
        //                     System.err.println("Error");
        //                     dispatcher = request.getRequestDispatcher("index.jsp");
        //                     dispatcher.forward(request, response);            
        //                 } else {
        //                     try {
        //                         if(modificarCarrera == "" || nuevaCarreraModificada == ""){
        //                             throw new Exception();
        //                         }
        //                         String id = String.valueOf(Queries.getCarrera(conexion, Queries.clientTable, modificarCarrera).getId());
        //                         Queries.updateData(conexion, Queries.clientTable, id, nuevaCarreraModificada);
        //                         rpt = "Carrera creada correctamente";
        //                         request.setAttribute("carrera", rpt);
    
        //                     } catch (Exception e) {
        //                         rpt = "Error, ingrese un valor valido";
        //                         request.setAttribute("carrera", rpt);
        //                         System.out.println("Error, ingrese un valor valido");
        //                     } finally {
        //                         dispatcher = request.getRequestDispatcher("crear.jsp");
        //                         dispatcher.forward(request, response);            
        //                     }
        //                 }
        //             } else {
        //                 try {
        //                     if(crearCarrera == ""){
        //                         throw new Exception();
        //                     }
        //                     Queries.insertData(conexion, Queries.clientTable, crearCarrera);
        //                     rpt = "Carrera creada correctamente";
        //                     request.setAttribute("carrera", rpt);

        //                 } catch (Exception e) {
        //                     rpt = "Error, ingrese un valor valido";
        //                     request.setAttribute("carrera", rpt);
        //                     System.out.println("Error, ingrese un valor valido");
        //                 } finally {
        //                     dispatcher = request.getRequestDispatcher("crear.jsp");
        //                     dispatcher.forward(request, response);            
        //                 }
        //             }
        //         }else {
        //             try {
        //                 Carrera carreraConsulta = Queries.getCarrera(conexion, Queries.clientTable, request.getParameter("consultaCarrera"));
        //                 if(carreraConsulta.getNombre() == null){
        //                     throw new Exception();
        //                 }
        //                 request.setAttribute("carrera", carreraConsulta.getNombre());
        //             } catch (Exception e) {
        //                 rpt = "No se encuentra disponible " + consultaCarrera + " como carrera en nuestra universidad";
        //                 System.out.println("Error Error");
        //                 request.setAttribute("carrera", rpt);
        //             } finally {
        //                 dispatcher = request.getRequestDispatcher("carrera.jsp");
        //                 dispatcher.forward(request, response);        
        //             }
        //         }
        //         break;
        // }
        // Queries.closeConnection(conexion);
    }
}