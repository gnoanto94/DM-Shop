package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import acquisti.Carrello;
import ordini.DettagliOrdine;
import prodotti.GestioneProdotti;

public class CarrelloTest {
	Carrello carrello;

	@Before
	public void setUp() throws Exception {
		carrello = new Carrello();
	}

	@After
	public void tearDown() throws Exception {
		carrello = null;
	}
	
	@Test
	public void testAll(){ // E' necessario eseguire i test in ordine
		testGetElementiNelCarrello();
		testSetElementiNelCarrello();
		testAggiungiProdottoNelCarrello();
		testRicercaElemento();
		testGetImporto();
		testRimuoviProdottoDalCarrello();
	}

	public void testGetElementiNelCarrello() {
		ArrayList<DettagliOrdine> elementi = carrello.getElementiNelCarrello();
		assertNotNull(elementi);
	}

	public void testSetElementiNelCarrello() {
		ArrayList<DettagliOrdine> nuoviElementi = new ArrayList<>();
		carrello.setElementiNelCarrello(nuoviElementi);
		assertEquals(nuoviElementi, carrello.getElementiNelCarrello());
	}

	public void testAggiungiProdottoNelCarrello() {
		carrello.aggiungiProdottoNelCarrello(1, 1);
		assertEquals(1, carrello.getElementiNelCarrello().size());
	}

	public void testRicercaElemento() {
		DettagliOrdine elemento = carrello.ricercaElemento(GestioneProdotti.ricercaProdottoPerId(1));
		assertNotNull(elemento);
	}

	public void testGetImporto() {
		double importo = carrello.getImporto();
		assertEquals(GestioneProdotti.ricercaProdottoPerId(1).getPrezzoVendita(), importo, (GestioneProdotti.ricercaProdottoPerId(1).getPrezzoVendita()) - importo);
	}
	
	public void testRimuoviProdottoDalCarrello() {
		carrello.rimuoviProdottoDalCarrello(1);
		assertEquals(0, carrello.getElementiNelCarrello().size());
	}

}
