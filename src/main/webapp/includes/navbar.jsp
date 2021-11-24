<%--

  NO TOCAR!


--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar sticky-top navbar-expand-lg navbar-dark">
    <a class="navbar-brand" href="<%=request.getContextPath()%>">Paises VIP</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link <%=request.getParameter("page").equals("paises")? "active": "" %>" href="<%=request.getContextPath()%>">Paises</a>
            </li>
            <li class="nav-item">
                <a class="nav-link <%=request.getParameter("page").equals("participantes")? "active": "" %>" href="<%=request.getContextPath()%>/listaParticipantes">Participantes</a>
            </li>
            <li class="nav-item">
                <a class="nav-link <%=request.getParameter("page").equals("universidades")? "active": "" %>" href="<%=request.getContextPath()%>/listaUniversidades">Universidades</a>
            </li>
        </ul>
    </div>
</nav>

