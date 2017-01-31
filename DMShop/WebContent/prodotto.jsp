<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file='header.jsp'%>



<div class="container" style="padding-top: 70px">
    <div class="row">
        <div class="col-md-5"><img src="img/iphone.jpg"></div>
        <div class="col-md-7"><div class="product-title">Apple iPhone 7</div>
					<div class="product-desc">Bla bla bla</div>
					<div class="product-rating"><i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star-o"></i> </div>
					<hr>
					<div class="product-price">€790,00</div>
					<div class="product-stock">Disponibile</div>
					<hr>
					<div class="btn-group cart">
						<button type="button" class="btn btn-success">
							Aggiungi al carrello 
						</button>
					</div>
					<div class="btn-group wishlist">
						<button type="button" class="btn btn-danger">
							Lista Desideri
						</button>
					</div></div>
        <div class="col-xs-12"><ul id="myTab" class="nav nav-tabs nav_tabs">
						
						<li class="active"><a href="#service-one" data-toggle="tab">Descrizione</a></li>
						<li><a href="#service-two" data-toggle="tab">Dettagli</a></li>
						<li><a href="#service-three" data-toggle="tab">Recensioni</a></li>
						
					</ul>
				<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade in active" id="service-one">
						 
							<section class="container product-info">
								L'iPhone 7 è pensato per soddisfare tutte le tue esigenze
								<h3>Caratteristiche Tecniche <strong>iPhone7</strong></h3>
								<ul>
								<li>It supports the latest ATX12V v2.3 standard and is backward compatible with ATX12V 2.2 and ATX12V 2.01 systems</li>
								<li>An ultra-quiet 140mm double ball-bearing fan delivers great airflow at an very low noise level by varying fan speed in response to temperature</li>
								<li>80Plus certified to deliver 80% efficiency or higher at normal load conditions (20% to 100% load)</li>
								<li>0.99 Active Power Factor Correction provides clean and reliable power</li>
								<li>Universal AC input from 90~264V — no more hassle of flipping that tiny red switch to select the voltage input!</li>
								<li>Extra long fully-sleeved cables support full tower chassis</li>
								<li>A three year warranty and lifetime access to Corsair’s legendary technical support and customer service</li>
								<li>Over Current/Voltage/Power Protection, Under Voltage Protection and Short Circuit Protection provide complete component safety</li>
								<li>Dimensions: 150mm(W) x 86mm(H) x 160mm(L)</li>
								<li>MTBF: 100,000 hours</li>
								<li>Safety Approvals: UL, CUL, CE, CB, FCC Class B, TÜV, CCC, C-tick</li>
								</ul>
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


<%@include file='footer.jsp'%>