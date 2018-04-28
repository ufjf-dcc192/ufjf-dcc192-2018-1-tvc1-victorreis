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

<form method="POST">
    <label for="data-inicio">Data Início do Período</label><br>
    <input type="date" name="data-inicio" /><br>
    
    <label for="data-final">Data Final do Período</label><br>
    <input type="date" name="data-final" /><br>
    
    <br><br>
    
    <input type="hidden" name="id-anfitriao" value="${anfitriao.getId()}">
    <input type="submit" value="Cadastrar Período">
</form>

<%@include file="jspf/rodape.jspf" %>
