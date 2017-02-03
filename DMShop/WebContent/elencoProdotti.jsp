<!-- Pagina che visualizza una tabella con l'elenco dei prodotti presenti nel database.  -->
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
  <c:if test="${sessionScope.prodotti != null}">          
  <table class="table table-hover">
    <thead>
      <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Marca</th>
        <th>Quantità</th>
        <th>Prezzo</th>
        <th>Azioni</th>
      </tr>
    </thead>
    <c:forEach var="prd" items="${sessionScope.prodotti}">
    <tbody>
      <tr>
        <td>${prd.idProdotto}</td>
        <td>${prd.nome}</td>
        <td>${prd.marca}</td>
        <td>${prd.quantitaDisponibile}</td>
        <td>${prd.prezzoVendita}</td>
        <td>
        <ul class="list-inline">
        <li>
        <form action="EliminaProdottoControl" method="get" id="eliminaProdotto">
        	<input type="hidden" name="idEliminazione" value='${prd.idProdotto}'>
        	<button class="btn btn-danger" type="submit" form="eliminaProdotto" value="Submit"><span class="glyphicon glyphicon-remove"></span></button>
		</form>
		</li>
		<li>
			<form action="ButtonModificaProdottoControl" method="get" id="modificaProdotto">
			<input type="hidden" name="idModifica" value='${prd.idProdotto}'>
        	<button class="btn btn-primary" type="submit" form="modificaProdotto" value="Submit"><span class="glyphicon glyphicon-cog"></span></button>
			</form>
		</li>
		</ul>
		</td>
      	</tr>
    </tbody>
    </c:forEach>
  </table>
  </c:if>
 
</div>

<%@include file='footer.jsp'%>
