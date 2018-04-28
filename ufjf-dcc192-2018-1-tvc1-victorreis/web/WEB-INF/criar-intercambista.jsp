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
    <label for="nome-intercambista">Nome Intercambista</label><br>
    <input type="text" name="nome-intercambista" /><br>
    
    <label for="descricao">Descricao</label><br>
    <input type="text" name="descricao" /><br>
    
    <label for="idiomas">Idioma</label><br>
    <input type="text" name="idiomas" /><br>
    
    <br><br>
    
    <input type="submit" value="Cadastrar">
</form>

<%@include file="jspf/rodape.jspf" %>
