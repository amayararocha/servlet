<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Musica"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="header.jsp"  %>

<h2>Músicas Cadastradas</h2>

<c:forEach items="${musicas}" var="musica">
    <p><c:out value="${musica.nome}"/></p>
    <p><c:out value="${musica.artista}"/></p>
    <p><c:out value="${musica.estiloMusical}"/></p>
    <p><c:out value="${musica.duracao}"/></p>
    <p><c:out value="${musica.anoLancamento}"/></p>
</c:forEach>

<ul>
    <%
        ArrayList<Musica> musicas = (ArrayList<Musica>) request.getAttribute("musicas");
        for(Musica musica : musicas){
            out.println("<li>" + musica.getNome() + " - " + musica.getArtista() + "</li>");
        }
    %>
</ul>

</body>
</html>
