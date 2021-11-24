<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

            <div class="my-2">
                <a class="btn btn-info" href="">Añadir</a>
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
                            <td> <a class="btn btn-info" href=""><span class="fa fa-edit"></span></a> </td>
                            <td> <a class="btn btn-info" href=""><span class="fa fa-trash"></span> </a> </td>

                        </tbody>
                    </table>
                </div>
            </div>

        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
