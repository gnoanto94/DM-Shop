<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file='header.jsp'%>



<div class="container">
  <h2>Un riepilogo di cosa stai acquistando...</h2>
  
  <p>Dai un'occhiata ai prodotti che stai per acquistare e conferma l'ordine</p>  
  <c:if test="${sessionScope.carrello != null}">          
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Nome</th>
        <th>Marca</th>
        <th>Quantità</th>
        <th>Prezzo</th>
      </tr>
    </thead>
    <c:forEach var="prd" items="${sessionScope.carrello.elementiNelCarrello}">
    <tbody>
      <tr>
        <td>${prd.prodotto.nome}</td>
        <td>${prd.prodotto.marca}</td>
        <td>${prd.quantita}</td>
        <td>${prd.prezzo}</td>
      	</tr>
    </tbody>
    </c:forEach>
  </table>
  </c:if>
  <form method="link" action="AcquistoCarrelloControl">
    						<input class="btn btn-primary" type="submit" value="Concludi Ordine"/>
							</form>
  
</div>

<%@include file='footer.jsp'%>