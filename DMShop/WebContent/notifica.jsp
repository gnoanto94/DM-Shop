<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@include file='header.jsp'%>
<div class="container">
    <div class="row">
		<h2>Ops! Qualcosa è andato storto...</h2>

		<p>${messaggio}</p> 

		<a href="${urlTornaIndietro}"><button class="btn btn-primary">Torna Indietro</button></a> 
</div></div>

<%@include file='footer.jsp'%>