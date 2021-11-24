
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

            <div class="d-flex justify-content-center">
                <div class="w-75">
                    <table class="table table-dark table-transparent table-hover">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Continente</th>
                                <th>Población</th>
                                <th>Tamaño</th>
                            </tr>
                        </thead>
                        <tbody>
                            <td> Peru</td>
                            <td> America</td>
                            <td> 32 000 000</td>
                            <td> 4000000</td>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>

    </body>
</html>
