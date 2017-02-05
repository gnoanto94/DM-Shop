<%@ page import="acquisti.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>   
<%@include file='header.jsp'%>

<div class="container" style="margin-top: 70px">
  <div class="row">
    <div class="col-xs-8">
      <div class="panel panel-info">
        <div class="panel-heading">
          <div class="panel-title">
		    <div class="row">
			  <div class="col-xs-6">
			    <h5><span class="glyphicon glyphicon-shopping-cart"></span> Il tuo carrello</h5>
			  </div>
              <div class="col-xs-6">
                <a href="index.jsp">
                  <button type="button" class="btn btn-primary btn-sm btn-block"><span class="glyphicon glyphicon-share-alt"></span>
                     Continua gli acquisti
                  </button>
                </a>
              </div>
            </div>
          </div>
        </div>
        <c:if test="${sessionScope.carrello != null}">
	      <div class="panel-body">	
            <c:forEach var="prodcar" items="${sessionScope.carrello.elementiNelCarrello}">
              <div class="row">
                <div class="col-xs-2"><img class="img-responsive" src="http://placehold.it/100x70"></div>
                <div class="col-xs-4">
                  <h4 class="product-name"><strong>${prodcar.prodotto.nome}</strong></h4><h4><small>${prodcar.prodotto.descrizione}</small></h4>
                </div>
                <div class="col-xs-6">
                  <div class="col-xs-6 text-right">
                    <h6><strong>${prodcar.prezzo}</strong></h6>
                  </div>
                  <div class="col-xs-4">
                    <a href="RimuoviProdottoCarrelloControl?idProdotto=${prodcar.prodotto.idProdotto}"><button type="submit" class="btn btn-danger">Rimuovi</button></a>						
                  </div>				
                </div>
              </div>
              <hr>
            </c:forEach>		
        </div>
        <div class="panel-footer">
          <div class="row text-center">
            <div class="col-xs-9">
              <h4 class="text-right"> <strong>IMPORTO TOTALE: ${sessionScope.carrello.importo}</strong></h4>
            </div>
            <div class="col-xs-3">
              <form method="get" action="ButtonAcquistaControl">
                <input class="btn btn-primary" type="submit" value="Acquista"/>
              </form>		
            </div>
          </div>
        </div>
        </c:if>
      </div>
    </div>
  </div>
</div>

<%@include file='footer.jsp'%>