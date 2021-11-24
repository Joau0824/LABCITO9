<%@ page import="pucp.edu.pe.labcito9.Beans.BPaises" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaPaises" type="java.util.ArrayList<pucp.edu.pe.labcito9.Beans.BPaises>" scope="request"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="paises"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="paises"/>
            </jsp:include>

            <div class="mt-2 text-center">
                <h1 style="color:#F0F8FF">Lista de paises</h1>
            </div>

            <form method="post" action="<%=request.getContextPath()%>/?opcion=listar">
                <div style="margin-top:30px;"class = "box">
                    <input type="text" name="filter" class="src" autocomplete = "off">
                </div>
            </form>
            <div class="my-2 text-right">
                <a class="btn btn-info" href="<%=request.getContextPath()%>?action=formAgregar">Añadir país</a>
            </div>

            <div class="d-flex justify-content-center">
                <div class="w-75">
                    <table class="table table-dark table-transparent table-hover">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Continente</th>
                                <th>Población</th>
                                <th>Tamaño</th>
                                <th>Editar</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                    <tbody>
                        <%for(BPaises pais :listaPaises){
                        %>
                        <tr>
                            <td> <%=pais.getNombre()%></td>
                            <td> <%=pais.getContinente()%></td>
                            <td> <%=pais.getPoblacion()%></td>
                            <td> <%=pais.getTamanio()%></td>
                            <td><a class="btn btn-primary" href="<%=request.getContextPath()%>?action=formEditar&id=<%=pais.getIdPais()%>"><span class="fa fa-edit"></span></a></td>
                            <td><a class="btn btn-danger" href="<%=request.getContextPath()%>?action=borrar&id=<%=pais.getIdPais()%>"><span class="fa fa-trash"></span></a></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                    </table>

                </div>
            </div>

        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
