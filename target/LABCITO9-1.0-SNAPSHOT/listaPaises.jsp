<%@ page import="pucp.edu.pe.labcito9.Beans.BPaises" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ArrayList<BPaises> listaPaises = (ArrayList) request.getAttribute("listaPaises");%>
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

            <div class="my-2 text-right">
                <a class="btn btn-info" href="<%=request.getContextPath()%>?action=formAgregar">Añadir país</a>
            </div>
            <div class="d-flex justify-content-center">
                <div class="w-75">
                    <table class="table table-dark table-transparent table-hover">
                        <thead>
                            <tr>
                                <form method="POST" action="<%=request.getContextPath()%>/?action=listar">
                                    <div class="form-group">
                                    <label for="idcontinente" style="color:#F0F8FF" >Filtrar por continente</label>
                                    <select name="idcontinente" id="idcontinente">
                                        <option value="America">America</option>
                                        <option value="Asia">Asia</option>
                                        <option value="Europa">Europa</option>
                                        <option value="Africa">Africa</option>
                                        <option value="Oceania">Oceania</option>
                                    </select>
                                    <button type="submit" class="btn btn-primary">Filtrar</button>
                                    </div>
                                </form>

                            </tr>
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

                        <%for(BPaises pais: listaPaises){
                        %>
                        <tr>
                            <td> <%=pais.getNombre()%></td>
                            <td> <%=pais.getContinente()%></td>
                            <td> <%=pais.getPoblacion()%></td>
                            <td> <%=pais.getTamanio()%></td>
                            <td><a href="<%=request.getContextPath()%>?action=formEditar&idPais=<%=pais.getIdPais()%> "class="btn btn-primary" ><span class="fa fa-edit"></span></a></td>
                            <td><a class="btn btn-danger" href="<%=request.getContextPath()%>?action=borrar&idPais=<%=pais.getIdPais()%>"><span class="fa fa-trash"></span></a></td>
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
