<%@ page import="pucp.edu.pe.labcito9.Beans.BPaises" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% BPaises pais = (BPaises) request.getAttribute("idPais"); %>

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
                <h1 style="color:#F0F8FF">Editar Pais </h1>
            </div>
            <div class="d-flex justify-content-center">
                <div class="w-75">
                    <form method="POST" action="<%=request.getContextPath()%>?action=editar&idPais=<%=pais.getIdPais()%>">
                        <div class="form-group">
                            <label for="idPais" style="color:#F0F8FF">ID</label>
                            <input class="form-control" type="text" value="<%=pais.getIdPais()%>" disabled name="idPais" id="idPais" >
                        </div>
                        <div class="form-group">
                            <label for="nombre" style="color:#F0F8FF" >Nombre</label>
                            <input class="form-control" type="text" name="nombrePais" id="nombre" value="">
                        </div>
                        <div class="form-group">
                            <label for="poblacion" style="color:#F0F8FF" >Poblacion</label>
                            <input class="form-control" type="text" name="poblacion" id="poblacion" value="">
                        </div>
                        <div class="form-group">
                            <label for="tamanio" style="color:#F0F8FF" >Tamaño</label>
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
