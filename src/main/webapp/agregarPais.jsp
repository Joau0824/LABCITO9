<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Agregar País"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="paises"/>
            </jsp:include>

            <div class="mt-2 text-center">
                <h1 style="color:#F0F8FF">Agregar Pais</h1>
            </div>
            <div class="d-flex justify-content-center">
                <div class="w-75">
                    <form method="POST" action="<%=request.getContextPath()%>?action=agregar">
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input class="form-control" type="text" name="nombre" id="nombre">
                        </div>
                        <div class="form-group">
                            <label for="continente">Continente</label>
                            <input class="form-control" type="text" name="continente" id="continente">
                        </div>
                        <div class="form-group">
                            <label for="poblacion">Poblacion</label>
                            <input class="form-control" type="text" name="poblacion" id="poblacion">
                        </div>
                        <div class="form-group">
                            <label for="tamanio">Tamaño</label>
                            <input class="form-control" type="text" name="tamanio" id="tamanio">
                        </div>
                        <button type="submit" class="btn btn-primary">Enviar</button>
                        <a class="btn btn-danger" href="#">Cancelar</a>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>


