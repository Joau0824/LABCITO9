<%@ page import="pucp.edu.pe.labcito9.Beans.BUniversidad" %>
<%@ page import="pucp.edu.pe.labcito9.Beans.BAlumnos" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaAlumnos" type="java.util.ArrayList<pucp.edu.pe.labcito9.Beans.BAlumnos>" scope="request"  />
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Alumnos"/>
    </jsp:include>

    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="alumnos"/>
            </jsp:include>

            <div class="mt-2 text-center">
                <h1 style="color:#F0F8FF">Lista de Alumnos</h1>
            </div>

            <div class="my-2 text-right">
                <a class="btn btn-info" href="">Añadir alumno</a>
            </div>
            <div class="d-flex justify-content-center">
                <div class="w-75">
                    <table class="table table-dark table-transparent table-hover" >
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Edad</th>
                                <th>Codigo de alumno</th>
                                <th>Promedio ponderado</th>
                                <th>Condicion</th>
                                <th>Editar</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for(BAlumnos alumno : listaAlumnos){%>
                            <tr>
                                <td> <%=alumno.getParticipante().getNombre()%></td>
                                <td> <%=alumno.getParticipante().getApellido()%></td>
                                <td> <%=alumno.getParticipante().getEdad()%></td>
                                <td> <%=alumno.getCodigoAlumno()%></td>
                                <td> <%=alumno.getPromedioPonderado()%></td>
                                <td> <%=alumno.getCondicion()%></td>
                                <td><a class="btn btn-primary" href=""><span class="fa fa-edit"></span></a></td>
                                <td><a class="btn btn-danger" href=""><span class="fa fa-trash"></span></a></td>
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