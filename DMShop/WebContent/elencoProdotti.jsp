<!-- Pagina che visualizza una tabella con l'elenco dei prodotti presenti nel database.  -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file='header.jsp'%>

<%@include file='nav.jsp'%>

<div class="container">
  <h2>Gestione Prodotti</h2>
  <p>In questa pagina vengono visualizzati i prodotti in vendita. Puoi decidere di inserirne di nuovi.</p>            
  <table class="table table-hover">
    <thead>
      <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Marca</th>
        <th>Quantità</th>
        <th>Prezzo</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>1</td>
        <td>Apple iPhone 7</td>
        <td>Apple</td>
        <td>7</td>
        <td>899,00</td>
      </tr>
      <tr>
        <td>2</td>
        <td>Huawei P9</td>
        <td>Huawei</td>
        <td>5</td>
        <td>450,00</td>
      </tr>
      <tr>
        <td>3</td>
        <td>Samsung Galaxy S7</td>
        <td>Samsung</td>
        <td>4</td>
        <td>690,00</td>
      </tr>
    </tbody>
  </table>
  <button type="button" class="btn btn-primary">Aggiungi Prodotto</button>
  
</div>

<%@include file='footer.jsp'%>
