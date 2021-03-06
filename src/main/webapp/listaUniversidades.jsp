<%@ page import="pucp.edu.pe.labcito9.Beans.BUniversidad" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaUniversidades" scope="request" type="java.util.ArrayList<pucp.edu.pe.labcito9.Beans.BUniversidad>"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="universidades"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="universidades"/>
            </jsp:include>

            <div class="mt-2 text-center">
                <h1 style="color:#F0F8FF">Lista de Universidades</h1>
            </div>

            <div class="my-2 text-right">
                <a class="btn btn-info" href="">Añadir universidad</a>
            </div>

            <div class="d-flex justify-content-center">
                <div class="w-75">
                    <table class="table table-dark table-transparent table-hover">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Pais</th>
                                <th>Ranking</th>
                                <th>Numero de alumnos</th>
                                <th>Foto</th>
                                <th>Alumnos</th>
                                <th>Editar</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for(BUniversidad universidad : listaUniversidades){%>
                            <tr>
                                <td> <%=universidad.getNombre()%></td>
                                <td> <%=universidad.getPais()%></td>
                                <td> <%=universidad.getRanking()%></td>
                                <td> <%=universidad.getNumeroAlumnos()%></td>
                                <td> <img style="width: 150px; height: 150px;" src ="" ></td>
                                <td><a class="btn btn-primary" href="/listaAlumnos">Lista de alumnos</a></td>
                                <td><a class="btn btn-primary" href="<%=request.getContextPath()%>/listaUniversidades?action=formEditar&idUniversidad=<%=universidad.getIdUniversidad()%>"><span class="fa fa-edit"></span></a></td>
                                <td><a class="btn btn-danger" href="<%=request.getContextPath()%>/listaUniversidades?action=borrar&idUniversidad=<%=universidad.getIdUniversidad()%>"><span class="fa fa-trash"></span></a></td>
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
