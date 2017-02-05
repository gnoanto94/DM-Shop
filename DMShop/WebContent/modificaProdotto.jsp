<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@include file='header.jsp'%>
<%@include file='headerGestore.jsp'%> 

<div class="container">
  <div class="row">
    <div class="col-xs-12">        
      <h2>Modifica Prodotto</h2>
      <p>Modifica un prodotto.</p>        
    </div>    
    <c:if test="${prodotto != null}">          
      <form method="post" action="ModificaProdottoControl">
        <div class="col-md-7">
          <div class="form-group">
            <label for="nomeProdotto">Nome</label>
            <input type="text" class="form-control" name="nome" pattern="[a – z A-Z 0-9] {1, 50}" value="${prodotto.nome}">
          </div>
          <div class="form-group">
            <label for="marcaProdotto">Marca</label>
            <input type="text" class="form-control" id="marcaProdotto" name="marca" pattern="[a – z A-Z 0-9] {1, 50}" value="${prodotto.marca}">
          </div>
          <div class="form-group">
            <label for="exampleTextarea">Descrizione</label>
            <textarea class="form-control" id="exampleTextarea" rows="3" pattern=" [a – z A-Z 0-9] {0, 255}" name="descrizione">${prodotto.descrizione}</textarea>
          </div>
          <div class="form-group">
            <div class="col-md-3"><label for="quantita">Quantita</label>
              <input type="number" class="form-control" id="quantita" name="quantitaDisponibile" pattern="[0-9] {1, 5}" value="${prodotto.quantitaDisponibile}">
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-4"><label for="prezzoProdotto">Prezzo</label>
              <input type="text" class="form-control" id="prezzoVendita" name="prezzo" pattern="[0-9]{1,8}(,|\.)[0-9]{2}{4, 10}" value="${prodotto.prezzoVendita}">
              <!-- Qui ci sarà bisogno di un parse double -->
            </div>
          </div>
        </div>
        <div class="col-md-5">
          <div class="form-group">
            <label for="exampleInputFile">Aggiungi Foto</label>
            <br>
            <input type="text" class="form-control"  aria-describedby="fileHelp" name="url_immagine" value="${prodotto.urlImmagine}">
            <small id="fileHelp" class="form-text text-muted">Inserisci l'immagine di anteprima del prodotto</small>
          </div>
          <input type="hidden" name="idProdotto" value="${prodotto.idProdotto}">
          <button type="submit" class="btn btn-primary">Modifica Prodotto</button>      
        </div>
      </form>
    </c:if> 
  </div>
</div>


<%@include file='footer.jsp'%>