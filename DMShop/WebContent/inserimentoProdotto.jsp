<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file='header.jsp'%>
<%@include file='headerGestore.jsp'%> 
<div class="container">   
  <div class="row">  
    <div class="col-md-7">
      <br>
      <form method="get" action="AggiungiProdottoControl">
        <div class="form-group">
          <label for="nomeProdotto">Nome</label>
          <input type="text" class="form-control" name="nome">
        </div>
        <div class="form-group">
          <label for="marcaProdotto">Marca</label>
          <input type="text" class="form-control" id="marcaProdotto" name="marca">
        </div>
        <div class="form-group">
          <label for="exampleTextarea">Descrizione</label>
          <textarea class="form-control" id="exampleTextarea" rows="3" name="descrizione"></textarea>
        </div>  
        <div class="form-group">
          <div class="col-md-3"><label for="quantita">Quantita</label>
            <input type="number" class="form-control" id="quantita" name="quantitaDisponibile">
          </div>
        </div>
        <div class="form-group">
          <div class="col-md-4"><label for="prezzoProdotto">Prezzo</label>
            <input type="text" class="form-control" id="prezzoVendita" name="prezzo">
            <!-- Qui ci sarà bisogno di un parse double -->
          </div>
        </div>
	 
    <div class="col-md-5">  
      <div class="form-group">
        <label for="exampleInputFile">Aggiungi Foto</label>
        <br>
        
        <input type="text" class="form-control"  aria-describedby="fileHelp" name="url_immagine">
        <small id="fileHelp" class="form-text text-muted">Inserisci l'immagine di anteprima del prodotto</small>
      </div>
      <button type="submit" class="btn btn-primary">Aggiungi Prodotto</button>
      </div>
	  </form>
    </div>      
  </div>
</div>


<%@include file='footer.jsp'%>