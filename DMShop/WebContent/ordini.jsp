<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file='header.jsp'%>
<div class="container" style="margin-top: 70px">

<h2>Gestisci il tuo negozio</h2>
  
  <p>Benvenuto nella tua area privata. Da qui puoi gestire il tuo negozio, creare prodotti ed evadere gli ordini</p>  

<div class="text-left">
	<a href="ButtonElencoProdottiControl"><button class="btn btn-primary"><span class="glyphicon glyphicon-tags"></span>&nbsp; Elenco Prodotti</button></a>
	<a href="ButtonAggiungiProdottoControl"><button class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>&nbsp; Nuovo Prodotto</button></a>
	<button class="btn btn-warning"><span class="glyphicon glyphicon-check"></span>&nbsp; Gestisci Ordini</button>
	<button class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp; Torna Indietro</button>

</div>      
<br>
  <c:if test="${sessionScope.ordini != null}">          
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
    <c:forEach var="ord" items="${sessionScope.ordini}">
    <tbody>
      <tr>
        <td>${ord.idOrdine}</td>
        <td>${ord.cliente}</td>
        <td>${ord.importo}</td>
        <td>${ord.stato}</td>
        <td></td>
      	</tr>
    </tbody>
    </c:forEach>
  </table>
  </c:if>
 
</div>

<%@include file='footer.jsp'%>