<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file='header.jsp'%>



<div class="container">
  <h2>Storico Acquisti</h2>
  
  <p>Qui vengono visualizzati tutti i tuoi acquisti</p>
  <c:if test="${sessionScope.acquisti != null}">           
  <table class="table table-hover">
    <thead>
      <tr>
        <th>ID</th>
        <th>Data</th>
        <th>Importo</th>
        <th>Stato</th>
      </tr>
    </thead>
    <c:forEach var="stacq" items="${sessionScope.acquisti}">
    <tbody>
      <tr>
        <td>${stacq.id}</td>
        <td>${stacq.data}</td>
        <td>${stacq.importo}</td>
        <td>${stacq.stato}</td>
      	</tr>
    </tbody>
</c:forEach>
  </table>
  </c:if>

  
  
</div>

<%@include file='footer.jsp'%>