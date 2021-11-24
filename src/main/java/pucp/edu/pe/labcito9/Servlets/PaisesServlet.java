package pucp.edu.pe.labcito9.Servlets;

import pucp.edu.pe.labcito9.Beans.BPaises;
import pucp.edu.pe.labcito9.Daos.DaoPaises;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
