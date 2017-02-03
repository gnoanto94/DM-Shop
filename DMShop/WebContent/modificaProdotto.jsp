<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
            <input type="text" class="form-control" name="nome" value="${prodotto.nome}">
          </div>
          <div class="form-group">
            <label for="marcaProdotto">Marca</label>
            <input type="text" class="form-control" id="marcaProdotto" name="marca" value="${prodotto.marca}">
          </div>
          <div class="form-group">
            <label for="exampleTextarea">Descrizione</label>
            <textarea class="form-control" id="exampleTextarea" rows="3" name="descrizione">${prodotto.descrizione}</textarea>
          </div>
          <div class="form-group">
            <div class="col-md-3"><label for="quantita">Quantita</label>
              <input type="number" class="form-control" id="quantita" name="quantitaDisponibile" value="${prodotto.quantitaDisponibile}">
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-4"><label for="prezzoProdotto">Prezzo</label>
              <input type="text" class="form-control" id="prezzoVendita" name="prezzo" value="${prodotto.prezzoVendita}">
              <!-- Qui ci sarà bisogno di un parse double -->
            </div>
          </div>
        </div>
        <div class="col-md-5">
          <div class="form-group">
            <label for="exampleInputFile">Aggiungi Foto</label>
            <br>
            <img id="output" src="https://i.imgsafe.org/e6f0b8a0f8.png" alt="Anteprima della tua immagine"  width="50%"><br><br>
            <input type="file" class="form-control-file" id="imgLoad" aria-describedby="fileHelp" onchange="loadFile(event)">
            <small id="fileHelp" class="form-text text-muted">Inserisci l'immagine di anteprima del prodotto</small>
          </div>
          <button type="submit" class="btn btn-primary">Modifica Prodotto</button>      
        </div>
      </form>
    </c:if> 
  </div>
</div>

<script>
var loadFile = function(event) {
    var output = document.getElementById('output');
    output.src = URL.createObjectURL(event.target.files[0]);
  };

</script>

<%@include file='footer.jsp'%>