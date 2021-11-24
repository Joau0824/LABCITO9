
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

            <div class="container text-center mt-2">
                <h1>Bienvenido a la lista de paises vIP</h1>

                <p>Esta es una página donde puede conocer más sobre sus bandas y artistas favoritos e incluso actualizar nuestra
                    base de datos con las nuevas estrellas.</p>
            </div>


        </div>

    </body>
</html>
