<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file='header.jsp'%>
<div class="container" style="margin-top: 70px">
<%@include file='headerGestore.jsp'%>       
<br>
  <c:if test="${sessionScope.ordiniNuovi != null}">          
  <table class="table table-hover">
    <thead>
      <tr>
        <th>ID</th>
        <th>Utente</th>
        <th>Importo</th>
        <th>Stato</th>
        <th>Azioni</th>
      </tr>
    </thead>
    <c:forEach var="ord" items="${sessionScope.ordiniNuovi}">
    <tbody>
      <tr>
        <td>${ord.idOrdine}</td>
        <td>${ord.cliente.nome}</td>
        <td>${ord.importo}</td>
        <td>${ord.stato}</td>
        <td><a href="VisualizzaDettagliOrdineControl?idVisualizzaOrdine=${ord.idOrdine}"><button class="btn btn-primary"><span class="glyphicon glyphicon-search"></span></button></a></td>
      	</tr>
    </tbody>
    </c:forEach>
  </table>
  </c:if>
 
</div>

<%@include file='footer.jsp'%>