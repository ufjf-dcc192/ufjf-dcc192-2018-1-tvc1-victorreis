<%@page 
    import="java.util.Date, java.util.Date, java.util.Locale, java.util.Calendar" 
    errorPage="pagina-de-erro.jsp" 
    isErrorPage="false" 
    contentType="text/html" 
    pageEncoding="UTF-8" %>

<!--The core group of tags are the most commonly used JSTL tags.-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--The JSTL formatting tags are used to format and display text, the date, the time, and numbers for internationalized Websites.-->
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="jspf/cabecalho.jspf" %>

<%
    String aux = Calendar.getInstance().getDisplayName(Calendar.DATE, Calendar.SHORT_FORMAT, Locale.ENGLISH);
    aux = aux + "aaa";
    out.println(aux);
%>
<table border="1">
    <thead>
        <tr>
            <th>Id Anfitriao</th>
            <th>Nome</th>
            <th>Descricao</th>
            <th>Localizacao</th>
            <th>Está disponível?</th>
            <th>Períodos OCUPADOS</th>
            <th>Cadastrar período</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${anfitrioes}" var="anfitriao">
        <tr>
            <td>${anfitriao.getId()}</td>
            <td>${anfitriao.getNome()}</td>
            <td>${anfitriao.getDescricao()}</td>
            <td>${anfitriao.getLocalizacao()}</td>
            <td>
                <ul>
                    <c:forEach items="${anfitriao.getPeriodosOcupados()}" var="periodo">
                        <li>De ${periodo.getInicioPeriodo()} até ${periodo.getFinalPeriodo()}</li>
                    </c:forEach>
                </ul>
            </td>
            <td><a href="cadastrar-periodo.html?id=${anfitriao.getId()}">Cadastrar Período</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%@include file="jspf/rodape.jspf" %>
