package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prodotti.GestioneProdotti;
import prodotti.Prodotto;

public class GestioneProdottiTest {

	private Prodotto prodotto;
	private ArrayList<Prodotto> prodotti;
	
	@Before
	public void setUp() throws Exception {
		prodotto = new Prodotto("marcaProva", "nomeProva", "descrizioneProva", 10, 100.00, "img.com");
		prodotti = new ArrayList<>();
		
	}

	@After
	public void tearDown() throws Exception {
		prodotto = null;
		prodotti = null;
	}

	@Test
	public void testGetProdotti() {
		prodotti = GestioneProdotti.getProdotti();
		assertNotNull(prodotti);
	}

	@Test
	public void testAggiungiProdotto() {
		boolean inserito = GestioneProdotti.aggiungiProdotto(prodotto);
		assertTrue(inserito);
	}
	
	@Test
	public void testVerificaEsistenzaProdotto() {
		boolean esistenza = false;
		esistenza = GestioneProdotti.verificaEsistenzaProdotto(prodotto.getNome());
		assertTrue(esistenza);
	}

	@Test
	public void testRicercaProdottoPerId() {
		Prodotto p = GestioneProdotti.ricercaProdottoPerNome(prodotto.getNome());
		Prodotto ricerca = GestioneProdotti.ricercaProdottoPerId(p.getIdProdotto());
		assertEquals(prodotto, ricerca);
	}

	@Test
	public void testRicercaProdottoPerNome() {
		Prodotto ricerca = GestioneProdotti.ricercaProdottoPerNome("nomeProva");
		assertEquals(prodotto, ricerca);
	}

	@Test
	public void testModificaProdotto() {
		Prodotto sostitutivo = GestioneProdotti.ricercaProdottoPerNome(prodotto.getNome());
		sostitutivo.setQuantitaDisponibile(7);
		boolean modificato = GestioneProdotti.modificaProdotto(sostitutivo);
		assertTrue(modificato);
	}
	
	@Test
	public void testRimuoviProdotto() {
		Prodotto p = GestioneProdotti.ricercaProdottoPerNome(prodotto.getNome());
		boolean eliminato = GestioneProdotti.rimuoviProdotto(p);
		assertTrue(eliminato);
	}

}
