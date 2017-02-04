<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='header.jsp'%>


<c:if test="${prodotto != null}">
<div class="container">
    <div class="row">
        <div class="col-md-5"><img src="${prodotto.urlImmagine}"></div>
        <div class="col-md-7"><div class="product-title"><h2>${prodotto.marca}&nbsp;<strong>${prodotto.nome}</strong></h2></div>
					
					<hr>
					<div class="product-price">Prezzo: ${prodotto.prezzoVendita}</div>
					<c:if test="${prodotto.quantitaDisponibile > 0}">
					<div class="product-stock">Disponibile</div>
					</c:if>
					<c:if test="${prodotto.quantitaDisponibile <= 0}">
					<div class="product-stock">Non Disponibile</div>
					</c:if>
					<hr>
					<div class="btn-group cart">
						<a href="AggiungiProdottoCarrelloControl?idProdotto=${prodotto.getIdProdotto()}&quantita=1"><button  class="btn btn-success">Aggiungi al Carrello</button></a>
					</div>
					</div>
        <div class="col-xs-12"><ul id="myTab" class="nav nav-tabs nav_tabs">
						
						<li class="active"><a href="#service-one" data-toggle="tab">Descrizione</a></li>
					
						
					</ul>
				<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade in active" id="service-one">
						 
							<section class="container product-info">
								<h3>Caratteristiche Tecniche <strong>${prodotto.nome }</strong></h3>
								${prodotto.descrizione }
							</section>
										  
						</div>
					<div class="tab-pane fade" id="service-two">
						
						<section class="container">
								
						</section>
						
					</div>
					<div class="tab-pane fade" id="service-three">
												
					</div>
				</div></div>
    </div>
</div>

</c:if>
<%@include file='footer.jsp'%>