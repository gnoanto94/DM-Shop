<!-- Pagina che visualizza una tabella con l'elenco dei prodotti presenti nel database.  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file='header.jsp'%>
<%@include file='headerGestore.jsp'%>    
<div class="container"> 
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
