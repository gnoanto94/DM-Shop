<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>

<%@include file='header.jsp'%>
<div class="container" style="margin-top: 70px">
<%@include file='headerGestore.jsp'%>       
<br>
  <c:if test="${sessionScope.ordiniNuovi != null}">  
  <h2>Ordini Nuovi</h2>        
  <table class="table table-hover">
    <thead>
      <tr>
        <th>ID</th>
        <th>Utente</th>
        <th>Data</th>
        <th>Importo</th>
        <th>Stato</th>
        <th>Azioni</th>
      </tr>
    </thead>
    <c:forEach var="ordNuovi" items="${sessionScope.ordiniNuovi}">
    <tbody>
      <tr>
        <td>${ordNuovi.idOrdine}</td>
        <td>${ordNuovi.cliente.email}</td>
        <td>${ordNuovi.data}</td>
        <td>${ordNuovi.importo}</td>
        <td>${ordNuovi.stato}</td>
        <td><a href="VisualizzaDettagliOrdineControl?idVisualizzaOrdine=${ordNuovi.idOrdine}"><button class="btn btn-primary"><span class="glyphicon glyphicon-search"></span></button></a></td>
      	</tr>
    </tbody>
    </c:forEach>
  </table>
  </c:if>
  <c:if test="${sessionScope.ordiniInLavorazione != null}"> 
  <h2>Ordini in Lavorazione</h2>         
  <table class="table table-hover">
    <thead>
      <tr>
        <th>ID</th>
        <th>Utente</th>
        <th>Data</th>
        <th>Importo</th>
        <th>Stato</th>
        <th>Azioni</th>
      </tr>
    </thead>
    <c:forEach var="ordLavorazione" items="${sessionScope.ordiniInLavorazione}">
    <tbody>
      <tr>
        <td>${ordLavorazione.idOrdine}</td>
        <td>${ordLavorazione.cliente.email}</td>
        <td>${ordLavorazione.data}</td>
        <td>${ordLavorazione.importo}</td>
        <td>${ordLavorazione.stato}</td>
        <td><a href="VisualizzaDettagliOrdineControl?idVisualizzaOrdine=${ordLavorazione.idOrdine}"><button class="btn btn-primary"><span class="glyphicon glyphicon-search"></span></button></a></td>
      	</tr>
    </tbody>
    </c:forEach>
  </table>
  </c:if>
</div>

<%@include file='footer.jsp'%>