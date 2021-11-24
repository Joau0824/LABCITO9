<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Editar Universidad"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="universidades"/>
            </jsp:include>

            <div class="mt-2 text-center">
                <h1 style="color:#F0F8FF">Editar Universidad </h1>
            </div>
            <div class="d-flex justify-content-center">
                <div class="w-75">
                    <form method="POST" action="">
                        <div class="form-group">
                            <label for="idUniversidad" style="color:#F0F8FF">ID</label>
                            <input class="form-control" type="text" disabled name="idUniversidad" id="idUniversidad" value="">
                        </div>
                        <div class="form-group">
                            <label for="pais" style="color:#F0F8FF" >País</label>
                            <input class="form-control" type="text" name="pais" id="pais" value="">
                        </div>
                        <div class="form-group">
                            <label for="ranking" style="color:#F0F8FF" >Ranking</label>
                            <input class="form-control" type="text" name="ranking" id="ranking" value="">
                        </div>
                        <div class="form-group">
                            <label for="fotoUrl" style="color:#F0F8FF" >Foto de la universidad</label>
                            <input class="form-control" type="text" name="fotoUrl" id="fotoUrl" value="">
                        </div>
                        <div class="form-group">
                            <label for="genero" style="color:#F0F8FF" >Genero</label>
                            <select name="genero" id="genero">
                                <option value="hombre">Hombre</option>
                                <option value="mujer">Mujer</option>
                                <option value="otros">Otros</option>
                            </select>
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