<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file='header.jsp'%>
<div class="container" style="margin-top: 70px">

<h2>Evadi l'ordine...</h2>
  
  <p>Controlla il riepilogo prima di evadere l'ordine...</p>  

<div class="text-left">
	
	<a href="amministrazione.jsp"><button class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp; Torna Indietro</button></a>

</div>      
<br>
  <c:if test="${sessionScope.ordine != null}">  
  <div class="inline"><strong>ID</strong>: ${ordine.idOrdine} <b>Data</b>: ${ordine.data}</div> <b>Utente</b>: ${ordine.utente.email}        
  <table class="table table-hover">
    <thead>
      <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Quantita</th>
        <th>Prezzo</th>
        <th>Importo</th>
      </tr>
    </thead>
    <c:forEach var="p" items="${sessionScope.ordine.dettagli}">
    <tbody>
      <tr>
        <td>${p.prodotto.idProdotto}</td>
        <td>${p.prodotto.marca} ${p.prodotto.nome}</td>
        <td>${p.quantita}</td>
        <td>${p.prezzo}</td>
        <td>${p.quantita}*${p.prezzo}</td>
      	</tr>
    </tbody>
    </c:forEach>
  </table>
  <div class="pull-right"><h2>IMPORTO: ${sessionScope.ordine.importo}</h2></div>
  </c:if>
 
</div>

<%@include file='footer.jsp'%>