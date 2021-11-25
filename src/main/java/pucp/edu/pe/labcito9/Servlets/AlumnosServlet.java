package pucp.edu.pe.labcito9.Servlets;

import pucp.edu.pe.labcito9.Beans.BAlumnos;
import pucp.edu.pe.labcito9.Beans.BUniversidad;
import pucp.edu.pe.labcito9.Daos.DaoAlumno;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AlumnosServlet", value = "/listaAlumnos")
public class AlumnosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        RequestDispatcher view;
        DaoAlumno daoAlumno = new DaoAlumno();

        ArrayList<BAlumnos> listaAlumnos = daoAlumno.obtenerListaAlumnos();
        switch (action) {
            case "listar":
                String filter = request.getParameter("filter") != null ? request.getParameter("filter") : "";
                request.setAttribute("listaAlumnos", listaAlumnos);
                view = request.getRequestDispatcher("listaAlumnos.jsp");
                view.forward(request, response);
                break;
        }
    }
        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {


    }
}