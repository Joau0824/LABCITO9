package pucp.edu.pe.labcito9.Servlets;

import pucp.edu.pe.labcito9.Beans.BPaises;
import pucp.edu.pe.labcito9.Daos.DaoPaises;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;

@WebServlet(name = "PaisesServlet", value = "")
public class PaisesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        DaoPaises daoPaises = new DaoPaises();
        RequestDispatcher view;
        switch(action) {
            case "listar":
                String filter = request.getParameter("filter") != null ? request.getParameter("filter") : "";
                System.out.println(filter);
                System.out.println("DIEGO");
                System.out.println("com1");
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
                String id = request.getParameter("idPais") != null ? request.getParameter("idPais"):"";
                BPaises pais = daoPaises.obtenerPaisPorId(id);
                if(pais != null){
                    request.setAttribute("idPais",pais);
                    RequestDispatcher view1 = request.getRequestDispatcher("editarPais.jsp");
                    view1.forward(request, response);
                }else{
                    response.sendRedirect(request.getContextPath()+ "");
                }
                break;

            case "borrar":
                String idstr = request.getParameter("idPais");
                int id1 = Integer.parseInt(idstr);
                daoPaises.eliminarPais(id1);
                response.sendRedirect(request.getContextPath() + "");
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
                daoPaises.anadirPais(nombre,continente,poblacion,tamanio);
                response.sendRedirect(request.getContextPath());
                break;
            case "editar":

                String idPaisstr = request.getParameter("idPais") != null ? request.getParameter("idPais"):"";
                String nombre1 = request.getParameter("nombrePais") != null ? request.getParameter("nombrePais") : "";
                String poblacionStr1 = request.getParameter("poblacion") != null ? request.getParameter("poblacion") : "";
                String tamanioStr1 = request.getParameter("tamanio") != null ? request.getParameter("tamanio") : "";
                int idPais = Integer.parseInt(idPaisstr);
                int poblacion1 = Integer.parseInt(poblacionStr1);
                double tamanio1 = Double.parseDouble(tamanioStr1);
                daoPaises.actualizarPais(idPais,nombre1,poblacion1,tamanio1);
                response.sendRedirect(request.getContextPath()+"");
                break;
            case "listar":
                String filtro_continente = request.getParameter("idcontinente") != null ? request.getParameter("idcontinente"):"";
                response.sendRedirect(request.getContextPath()+"?action=listar&filter="+filtro_continente);
        }
    }
}
