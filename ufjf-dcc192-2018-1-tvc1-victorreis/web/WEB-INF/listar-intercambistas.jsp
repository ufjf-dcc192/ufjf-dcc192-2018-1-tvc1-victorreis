<%@page 
    import="java.util.Date" 
    errorPage="pagina-de-erro.jsp" 
    isErrorPage="false" 
    contentType="text/html" 
    pageEncoding="UTF-8" %>

<!--The core group of tags are the most commonly used JSTL tags.-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--The JSTL formatting tags are used to format and display text, the date, the time, and numbers for internationalized Websites.-->
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="jspf/cabecalho.jspf" %>

<table border="1">
    <thead>
        <tr>
            <th>Id Intercambista</th>
            <th>Nome</th>
            <th>Descricao</th>
            <th>Idiomas</th>
            <th>Períodos de INTERESSE</th>
            <th>Cadastrar período</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${intercambistas}" var="intercambista">
        <tr>
            <td>${intercambista.getId()}</td>
            <td>${intercambista.getNome()}</td>
            <td>${intercambista.getDescricao()}</td>
            <td>${intercambista.getIdioma()}</td>
            <td>
                <ul>
                    <c:forEach items="${intercambista.getPeriodosDeInteresse()}" var="periodo">
                        <li>De ${periodo.getInicioPeriodo()} até ${periodo.getFinalPeriodo()}</li>
                    </c:forEach>
                </ul>
            </td>
            <td><a href="criar-periodo-interesse.html?id=${intercambista.getId()}">Cadastrar Período</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%@include file="jspf/rodape.jspf" %>
