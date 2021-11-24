package pucp.edu.pe.labcito9.Servlets;

import pucp.edu.pe.labcito9.Beans.BPaises;
import pucp.edu.pe.labcito9.Daos.DaoPaises;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "PaisesServlet", value = "")
public class PaisesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoPaises daoPaises = new DaoPaises();
        RequestDispatcher view;
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        switch(action) {
            case "listar":
                String filter = request.getParameter("filter") != null ? request.getParameter("filter") : "";
                ArrayList<BPaises> listaPaises = daoPaises.obtenerListaPaises(filter);
                request.setAttribute("listaPaises",listaPaises);
                view = request.getRequestDispatcher("listaPaises.jsp");
                view.forward(request, response);
                break;
            case "formAgregar":
                view = request.getRequestDispatcher("agregarPais.jsp");
                view.forward(request, response);
                break;
            case "formEditar":
                view = request.getRequestDispatcher("editarPais.jsp");
                view.forward(request, response);
                break;
            case "borrar":

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "agregar";

        DaoPaises daoPaises = new DaoPaises();

        switch (action){
            case "agregar":
                String nombre = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
                String continente = request.getParameter("continente") != null ? request.getParameter("continente") : "";
                String poblacionStr = request.getParameter("poblacion") != null ? request.getParameter("poblacion") : "";
                String tamanioStr = request.getParameter("tamanio") != null ? request.getParameter("tamanio") : "";
                int poblacion = Integer.parseInt(poblacionStr);
                double tamanio = Double.parseDouble(tamanioStr);
                daoPaises.anadirPais(nombre,continente,poblacion,tamanio);
                response.sendRedirect(request.getContextPath());
                break;
        }
    }
}
