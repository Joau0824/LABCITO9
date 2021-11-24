<%@ page import="pucp.edu.pe.labcito9.Beans.BParticipante" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaParticipantes" scope="request" type="java.util.ArrayList<pucp.edu.pe.labcito9.Beans.BParticipante>"/>

<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="participantes"/>
    </jsp:include>

    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="participantes"/>
            </jsp:include>

            <div class="mt-2 text-center">
                <h1 style="color:#F0F8FF">Lista de Participantes</h1>
            </div>

            <div class="my-2 text-right">
                <a class="btn btn-info" href="<%=request.getContextPath()%>/listaParticipantes?action=formAgregar">Añadir participante</a>
            </div>
            <div class="d-flex justify-content-center">
                <div class="w-75">
                    <table class="table table-dark table-transparent table-hover" >
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Edad</th>
                                <th>Nacionalidad</th>
                                <th>Genero</th>
                                <th>Editar</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for(BParticipante participante : listaParticipantes){%>
                            <tr>
                                <td><%=participante.getNombre()%></td>
                                <td><%=participante.getApellido()%></td>
                                <td><%=participante.getEdad()%></td>
                                <td><%=participante.getNacionalidad()%></td>
                                <td><%=participante.getGenero()%></td>
                                <td><a class="btn btn-primary" href="<%=request.getContextPath()%>/listaParticipantes?action=formEditar%idParticipante=<%=participante.getIdParticipante()%>"><span class="fa fa-edit"></span></a></td>
                                <td><a class="btn btn-danger" href="<%=request.getContextPath()%>/listaParticipantes?action=borrar"><span class="fa fa-trash"></span></a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
