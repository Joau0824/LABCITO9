<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Editar Participante"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="participantes"/>
            </jsp:include>

            <div class="mt-2 text-center">
                <h1 style="color:#F0F8FF">Editar Participante </h1>
            </div>
            <div class="d-flex justify-content-center">
                <div class="w-75">
                    <form method="POST" action="<%=request.getContextPath()%>/?action=editar">
                        <div class="form-group">.0
                            <label for="idParticipante" style="color:#F0F8FF">ID</label>
                            <input class="form-control" type="text" disabled name="idParticipante" id="idParticipante" value="">
                        </div>
                        <div class="form-group">
                            <label for="nombre" style="color:#F0F8FF" >Nombre</label>
                            <input class="form-control" type="text" name="nombre" id="nombre" value="">
                        </div>
                        <div class="form-group">
                            <label for="apellido" style="color:#F0F8FF" >Apellido</label>
                            <input class="form-control" type="text" name="apellido" id="apellido" value="">
                        </div>
                        <div class="form-group">
                            <label for="edad" style="color:#F0F8FF" >Edad</label>
                            <input class="form-control" type="text" name="edad" id="edad" value="">
                        </div>
                        <div class="form-group">
                            <label for="pais" style="color:#F0F8FF" >Pais</label>
                            <input class="form-control" type="text" name="pais" id="pais" value="">
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