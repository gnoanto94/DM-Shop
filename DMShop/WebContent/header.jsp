<!-- 
Questo è l'header che deve essere incluso in ogni pagina.  
Comprende i metatag, le intestazioni e l'importazioni di librerie utili
come bootstrap, jquery e componenti off-the-shelf
-->


<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DM Shop</title> 

<!-- Impostazione tag viewport per visualizzazione ottimale da mobile -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Importazione foglio di stile personalizzato -->
<link href="assets/style.css" rel="stylesheet" type="text/css">

<!--  Importazione bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap/js/bootstrap.min.js"></script>


</head>
<body style="margin-top: 70px">
<%
    if(session.getAttribute("hello") == null)
    {
     
%>
     
<%@include file='nav.jsp'%>

<%
    } else if((int)session.getAttribute("id") != 1) {

%>

<%@include file='user_nav.jsp'%>
<%
    } else if((int)session.getAttribute("id") == 1) {

%>
<%@include file='gestore_nav.jsp'%>
<%
    } 

%>
</html>