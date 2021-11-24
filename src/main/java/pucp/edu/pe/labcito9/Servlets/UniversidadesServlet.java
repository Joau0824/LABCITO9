package pucp.edu.pe.labcito9.Servlets;

import pucp.edu.pe.labcito9.Beans.BPaises;
import pucp.edu.pe.labcito9.Beans.BUniversidad;
import pucp.edu.pe.labcito9.Daos.DaoPaises;
import pucp.edu.pe.labcito9.Daos.DaoUniversidad;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UniversidadesServlet", value = "/listaUniversidades")
public class UniversidadesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        DaoUniversidad daoUniversidad = new DaoUniversidad();
        RequestDispatcher view;
        switch(action) {
            case "listar":
                String filter = request.getParameter("filter") != null ? request.getParameter("filter") : "";
                ArrayList<BUniversidad> listaUniversidades = daoUniversidad.obtenerListaUniversidades(filter);
                request.setAttribute("listaUniversidades",listaUniversidades);
                view = request.getRequestDispatcher("listaUniversidades.jsp");
                view.forward(request, response);
                break;
            case "formAgregar":
                view = request.getRequestDispatcher("agregarPais.jsp");
                view.forward(request, response);
                break;
            case "formEditar":
                String id = request.getParameter("idUniversidad") != null ? request.getParameter("idUniversidad"):"";
                BUniversidad universidad = daoUniversidad.obtenerUniversidadPorId(id);
                if(universidad != null){
                    request.setAttribute("universidad",universidad);
                    RequestDispatcher view1 = request.getRequestDispatcher("editarUniversidad.jsp");
                    view1.forward(request, response);
                }else{
                    response.sendRedirect(request.getContextPath()+ "");
                }
                break;

            case "borrar":
                String idstr = request.getParameter("idUniversidad");
                int id1 = Integer.parseInt(idstr);
                daoUniversidad.eliminarUniversidad(id1);
                response.sendRedirect(request.getContextPath() + "");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
