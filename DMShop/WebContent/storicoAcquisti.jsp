<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

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
        <td>${stacq.idOrdine}</td>
        <td>${stacq.data}</td>
        <td>${stacq.importo}</td>
        <td>${stacq.stato}</td>
      	</tr>
    </tbody>
</c:forEach>
  </table>
  </c:if>
  <p><b><i>Legenda sullo Stato: 1 = Nuovo; 2 = in Lavorazione; 3 = Evaso</i></b></p>
</div>

<%@include file='footer.jsp'%>