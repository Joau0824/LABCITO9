<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Editar Pais"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="paises"/>
            </jsp:include>

            <div class="mt-2 text-center">
                <h1>Editar Pais </h1>
            </div>
            <div class="d-flex justify-content-center">
                <div class="w-75">
                    <form method="POST" action="">
                        <div class="form-group">
                            <label for="idAlbum">ID</label>
                            <input class="form-control" type="text" disabled name="idAlbum" id="idAlbum" value="">
                        </div>
                        <div class="form-group">
                            <label for="nombreAlbum">Nombre</label>
                            <input class="form-control" type="text" name="nombreAlbum" id="nombreAlbum" value="">
                        </div>
                        <div class="form-group">
                            <label for="nombreAlbum">Poblacion</label>
                            <input class="form-control" type="text" name="poblacion" id="poblacion" value="">
                        </div>
                        <div class="form-group">
                            <label for="nombreAlbum">Tamaño</label>
                            <input class="form-control" type="text" name="tamanio" id="tamanio" value="">
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
