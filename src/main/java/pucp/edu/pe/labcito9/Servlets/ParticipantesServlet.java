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
        RequestDispatcher view;
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        DaoParticipante daoParticipante = new DaoParticipante();
        switch(action) {
            case "listar":
                ArrayList<BParticipante> listaParticipantes = daoParticipante.obtenerListaParticipantes();
                request.setAttribute("listaParticipantes",listaParticipantes);
                view = request.getRequestDispatcher("listaParticipantes.jsp");
                view.forward(request, response);
            case "formEditar":
                String idParticipante = request.getParameter("idParticipante") == null ? "" : request.getParameter("idParticipante");
                BParticipante participante = daoParticipante.obtenerParticipantePorId(idParticipante);
                request.setAttribute("participante",participante);
                view = request.getRequestDispatcher("editarParticipante.jsp");
                view.forward(request, response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
