package acquisti;

import java.util.ArrayList;

import ordini.DettagliOrdine;
import prodotti.Prodotto;
import prodotti.GestioneProdotti;

public class Carrello {
	
	public Carrello() {
		elementiNelCarrello = new ArrayList<>();
	}
	
	
	public ArrayList<DettagliOrdine> getElementiNelCarrello() {
		return elementiNelCarrello;
	}

	public void setElementiNelCarrello(ArrayList<DettagliOrdine> elementiNelCarrello) {
		this.elementiNelCarrello = elementiNelCarrello;
	}
	
	public void aggiungiProdottoNelCarrello(int idProdotto, int quantita){
		
		if (idProdotto != 0)
		{
			Prodotto p = GestioneProdotti.ricercaProdottoPerId(idProdotto);
			DettagliOrdine elemento = new DettagliOrdine(p, quantita, p.getPrezzoVendita());
			DettagliOrdine item = verificaElementoPresente(elemento);
			if (item != null)
			{
				item.setQuantita(item.getQuantita() + quantita);
				p.setQuantitaDisponibile(p.getQuantitaDisponibile() - quantita);  //decremento quantità nel magazzino
			}
			else
			{
				elementiNelCarrello.add(elemento);
				p.setQuantitaDisponibile(p.getQuantitaDisponibile() - quantita);  //decremento quantità nel magazzino
			}
		}
		
	}
	
public void rimuoviProdottoDalCarrello(int idProdotto){
		
		if (idProdotto != 0)
		{
			Prodotto p = GestioneProdotti.ricercaProdottoPerId(idProdotto);
			DettagliOrdine elemento = ricercaElemento(p);
			
			if (elemento != null)
			{
				elementiNelCarrello.remove(elemento);
				p.setQuantitaDisponibile(p.getQuantitaDisponibile() + elemento.getQuantita());  //Incremento quantita nel magazzino
			}
		}
		
	}

	
	public DettagliOrdine verificaElementoPresente(DettagliOrdine elemento){
				
		DettagliOrdine elementoPresente = null;
		
		if (elemento != null)
		{
			for (DettagliOrdine d:elementiNelCarrello)
			{
				if (elemento.getProdotto().equals(d.getProdotto()))
				{
					elementoPresente = d;
					break;
				}
			}
		}
		
		return elementoPresente;
	}
	
	public DettagliOrdine ricercaElemento(Prodotto prodotto)
	{
		DettagliOrdine elementoTrovato = null;
		
		if (prodotto != null)
		{
			for (DettagliOrdine d:elementiNelCarrello)
			{
				if (d.getProdotto().equals(prodotto))
				{
					elementoTrovato = d;
					break;
				}
			}
		}
		
		return elementoTrovato;
	}



	private ArrayList<DettagliOrdine> elementiNelCarrello;

}
