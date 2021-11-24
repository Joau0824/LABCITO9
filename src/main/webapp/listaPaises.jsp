
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="paises"/>
    </jsp:include>
    <body>
        <div class='container'>
            <!-- Incluir el navbar indicando el nombre de página correcto para que se señale la sección actual -->
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="paises"/>
            </jsp:include>

            <div class="mt-2 text-center">
                <h1 style="color:#F0F8FF">Lista de paises</h1>
            </div>


        </div>

    </body>
</html>
