<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='header.jsp'%>


<div class="container" style="margin-top: 70px">

<h2>Gestisci il tuo negozio</h2>
  
  <p>Benvenuto nella tua area privata. Da qui puoi gestire il tuo negozio, creare prodotti ed evadere gli ordini</p>  

<div class="text-left">
	<a href="ButtonElencoProdottiControl"><button class="btn btn-primary"><span class="glyphicon glyphicon-tags"></span>&nbsp; Elenco Prodotti</button></a>
	<a href="ButtonAggiungiProdottoControl"><button class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>&nbsp; Nuovo Prodotto</button></a>
	<a href="ButtonGestioneOrdiniControl"><button class="btn btn-warning"><span class="glyphicon glyphicon-check"></span>&nbsp; Gestisci Ordini</button></a>
	<a href="index.jsp"><button class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp; Torna Indietro</button></a>

</div>      
            
   <%@include file='footer.jsp'%>