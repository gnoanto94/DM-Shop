<%@ page import="prodotti.*" %>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<Prodotto> prodottiDaVisualizzare = GestioneProdotti.getProdotti();  %>
<div class="container bootstrap snipets">
   <%for (Prodotto p: prodottiDaVisualizzare){ %>
   <div class="row flow-offset-1 text-center">
     <div class="col-xs-6 col-md-4">
       <div class="product tumbnail thumbnail-3"><a href="#"><img src="img/lumia.jpg" alt=""></a>
         <div class="text-center">
         <button type="button" class="btn btn-primary">Scopri</button> <button type="button" class="btn btn-success">Aggiungi al Carrello</button>
           <h6><a href="prodotto.jsp"><%= p.getMarca()+" "+p.getNome() %></a></h6><span class="price sale"><%= p.getPrezzoVendita() %></span>
         </div>
       </div>
     </div>
   </div>
   <% } %>
 </div>