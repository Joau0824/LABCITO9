package pucp.edu.pe.labcito9.Servlets;

import pucp.edu.pe.labcito9.Beans.BParticipante;
import pucp.edu.pe.labcito9.Daos.DaoPaises;
import pucp.edu.pe.labcito9.Daos.DaoParticipante;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ParticipantesServlet", value = "/listaParticipantes")
public class ParticipantesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        RequestDispatcher view;
        DaoParticipante daoParticipante = new DaoParticipante();
        switch(action) {
            case "listar":
                ArrayList<BParticipante> listaParticipantes = daoParticipante.obtenerListaParticipantes();
                request.setAttribute("listaParticipantes",listaParticipantes);
                view = request.getRequestDispatcher("listaParticipantes.jsp");
                view.forward(request, response);
                break;
            case "formEditar":
                String idParticipante = request.getParameter("idParticipante") == null ? "" : request.getParameter("idParticipante");
                BParticipante participante = daoParticipante.obtenerParticipantePorId(idParticipante);
                request.setAttribute("participante",participante);
                view = request.getRequestDispatcher("editarParticipante.jsp");
                view.forward(request, response);
                break;
            case "formAgregar":
                view = request.getRequestDispatcher("agregarParticipante.jsp");
                view.forward(request, response);
                break;
            case "borrar":
                String idParticipantee = request.getParameter("idParticipante") == null ? "" : request.getParameter("idParticipante");
                daoParticipante.eliminarParticipante(Integer.parseInt(idParticipantee));
                response.sendRedirect(request.getContextPath()+"/listaParticipantes");
            break;
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "agregar";
        System.out.println("Entro a post");
        DaoParticipante daoParticipante = new DaoParticipante();

        switch (action) {
            case "agregar":
                String nombre = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
                String apellido = request.getParameter("apellido") != null ? request.getParameter("apellido") : "";
                String edad = request.getParameter("edad") != null ? request.getParameter("edad") : "";
                String pais = request.getParameter("pais") != null ? request.getParameter("pais") : "";
                int edad1 = Integer.parseInt(edad);
                String genero = request.getParameter("genero") != null ? request.getParameter("genero") : "";

                int idpais = daoParticipante.buscarIdpais(pais);

                daoParticipante.anadirParticipante(nombre, apellido, edad1, genero, idpais);
                response.sendRedirect(request.getContextPath()+"/listaParticipantes");
                break;

            case "editar":
                String idParticipante =request.getParameter("idParticipante") != null ? request.getParameter("idParticipante"):"";
                int idParticipante2=Integer.parseInt(idParticipante);
                String nombre2 = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
                String apellido2 = request.getParameter("apellido") != null ? request.getParameter("apellido") : "";
                String edad2 = request.getParameter("edad") != null ? request.getParameter("edad") : "";
                String pais2 = request.getParameter("pais") != null ? request.getParameter("pais") : "";
                int edad3 = Integer.parseInt(edad2);
                String genero2 = request.getParameter("genero") != null ? request.getParameter("genero") : "";
                int idpais2 = daoParticipante.buscarIdpais(pais2);
                daoParticipante.actualizarParticipante(nombre2,apellido2,edad3,genero2,idpais2,idParticipante2);
                response.sendRedirect(request.getContextPath()+"/listaParticipantes");
                break;
        }
    }
}
