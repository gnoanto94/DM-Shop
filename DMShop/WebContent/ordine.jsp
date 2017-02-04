<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@include file='header.jsp'%>
<div class="container" style="margin-top: 70px">

<h2>Evadi l'ordine...</h2>
  
  <p>Controlla il riepilogo prima di evadere l'ordine...</p>  

<div class="text-left">
	
	<a href="amministrazione.jsp"><button class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp; Torna Indietro</button></a>

</div>      
<br>
  <c:if test="${ordine != null}">  
  <div class="inline"><strong>ID</strong>: ${ordine.idOrdine} <b>Data</b>: ${ordine.data} <b>Stato</b>: ${ordine.stato}</div> <b>Utente</b>: ${ordine.cliente.email}        
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
    <c:forEach var="p" items="${ordine.dettagli}">
    <tbody>
      <tr>
        <td>${p.prodotto.idProdotto}</td>
        <td>${p.prodotto.marca}&nbsp;${p.prodotto.nome}</td>
        <td>${p.quantita}</td>
        <td>${p.prezzo}</td>
        <td>${p.importo}</td>
      	</tr>
    </tbody>
    </c:forEach>
  </table>
  <div class="pull-right"><h2>IMPORTO: ${ordine.importo}</h2></div>
  </c:if>
 <form method="get" action="ButtonEvadiOrdineControl">
 <input type="hidden" name="idOrdine" value="${ordine.idOrdine}"/>
 <c:if test="${ordine.stato == 1}">
   <input class="btn btn-primary" type="submit" value="Metti In Lavorazione"/>
 </c:if> 
 <c:if test="${ordine.stato == 2}">
 <input class="btn btn-primary" type="submit" value="Evadi"/>
 </c:if>
 </form>
</div>

<%@include file='footer.jsp'%>