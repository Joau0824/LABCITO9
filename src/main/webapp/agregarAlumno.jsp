<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Editar Participante"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="universidades"/>
            </jsp:include>

            <div class="mt-2 text-center">
                <h1 style="color:#F0F8FF">Agregar Alumno </h1>
            </div>
            <div class="d-flex justify-content-center">
                <div class="w-75">
                    <form method="POST" action=" ">
                        <div class="form-group">
                            <label for="genero" style="color:#F0F8FF" >Genero</label>
                            <select name="genero" id="genero">
                                <option value="hombre">Hombre</option>
                                <option value="mujer">Mujer</option>
                                <option value="otros">Otros</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="codigoAlumno" style="color:#F0F8FF">ID</label>
                            <input class="form-control" type="text" name="codigoAlumno" id="codigoAlumno" value="">
                        </div>
                        <div class="form-group">
                            <label for="promedio" style="color:#F0F8FF" >Nombre</label>
                            <input class="form-control" type="text" name="promedio" id="promedio" value="">
                        </div>
                        <div class="form-group">
                            <label for="condicion" style="color:#F0F8FF" >Apellido</label>
                            <input class="form-control" type="text" name="condicion" id="condicion" value="">
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

