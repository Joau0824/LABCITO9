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
                String id = request.getParameter("id") == null ? "id" : request.getParameter("1");
                request.setAttribute("id",id);
                BPaises pais = daoPaises.obtenerPaisPorId(id);
                request.setAttribute("pais",pais);
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
        System.out.println("Entro a post");
        DaoPaises daoPaises = new DaoPaises();

        switch (action){
            case "agregar":
                String nombre = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
                String continente = request.getParameter("continente") != null ? request.getParameter("continente") : "";
                String poblacionStr = request.getParameter("poblacion") != null ? request.getParameter("poblacion") : "";
                String tamanioStr = request.getParameter("tamanio") != null ? request.getParameter("tamanio") : "";
                int poblacion = Integer.parseInt(poblacionStr);
                double tamanio = Double.parseDouble(tamanioStr);
                System.out.println("Inicio de la funcion");
                System.out.println(poblacion);
                System.out.println(tamanio);
                try {
                    daoPaises.anadirPais(nombre,continente,poblacion,tamanio);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                response.sendRedirect(request.getContextPath());
                break;
            case "editar":
                String nombre1 = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
                String poblacionStr1 = request.getParameter("poblacion") != null ? request.getParameter("poblacion") : "";
                String tamanioStr1 = request.getParameter("tamanio") != null ? request.getParameter("tamanio") : "";
                int poblacion1 = Integer.parseInt(poblacionStr1);
                double tamanio1 = Double.parseDouble(tamanioStr1);
                BPaises bpais = new BPaises();
                bpais.setNombre(nombre1);
                bpais.setPoblacion(poblacion1);
                bpais.setTamanio(tamanio1);
                daoPaises.actualizarPais(bpais);
                response.sendRedirect(request.getContextPath());
                break;
        }
    }
}
