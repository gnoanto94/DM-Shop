<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file='header.jsp'%>
<%@include file='headerGestore.jsp'%> 
<div class="container">      
<br>
  <c:if test="${sessionScope.clienti != null}">          
  <table class="table table-hover">
    <thead>
      <tr>
        <th>ID</th>
        <th>Cognome</th>
        <th>Nome</th>
        <th>Email</th>
        <th>Azioni</th>
      </tr>
    </thead>
    <c:forEach var="clt" items="${sessionScope.clienti}">
    <tbody>
      <tr>
        <td>${clt.id}</td>
        <td>${clt.cognome}</td>
        <td>${clt.nome}</td>
        <td>${clt.email}</td>
        <c:set var="cliente" scope="request" value="${clt}" />
        <td><a href="datiUtente.jsp"><button class="btn btn-primary"><span class="glyphicon glyphicon-search"></span></button></a></td>
      	</tr>
    </tbody>
    </c:forEach>
  </table>
  </c:if>
</div>

<%@include file='footer.jsp'%>