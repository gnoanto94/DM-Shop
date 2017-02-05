package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ordini.DettagliOrdine;
import prodotti.Prodotto;

public class DettagliOrdineTest {

	private DettagliOrdine dettagli;
	private Prodotto prodotto;
	private String nome = "name";
	
	@Before
	public void setUp() throws Exception 
	{
		dettagli = new DettagliOrdine();
		dettagli.setIdDettagliOrdine(1);
		prodotto = new Prodotto(nome);
		dettagli.setProdotto(prodotto);
		dettagli.setQuantita(10);
		dettagli.setPrezzo(100);
		dettagli.setImporto(200);
		assertNotNull(dettagli);
	}

	@After
	public void tearDown() throws Exception 
	{
		dettagli = null;
	}

	@Test
	public void testGetIdDettagliOrdine() {
		int id = dettagli.getIdDettagliOrdine();
		assertEquals(1, id);
	}

	@Test
	public void testGetProdotto() {
		Prodotto prodotto =  dettagli.getProdotto();
		assertEquals(new Prodotto(nome), prodotto);
	}

	@Test
	public void testGetQuantita() {
		int quantita = dettagli.getQuantita();
		assertEquals(10, quantita);
	}

	@Test
	public void testGetPrezzo() {
		double prezzo = dettagli.getPrezzo();
		assertEquals(100, prezzo, 100-prezzo);
	}

	@Test
	public void testGetImporto() {
		double importo = dettagli.getImporto();
		assertEquals(1000, importo, 1000-importo);
	}
	
	@Test
	public void testSetIdDettagliOrdine() {
		int id = 3;
		dettagli.setIdDettagliOrdine(id);
		assertEquals(3, dettagli.getIdDettagliOrdine());
	}

	@Test
	public void testSetProdotto() {
		Prodotto prodotto = new Prodotto(nome);
		dettagli.setProdotto(prodotto);
		assertEquals(new Prodotto(nome), dettagli.getProdotto());
	}

	@Test
	public void testSetQuantita() {
		int quantita = 30;
		dettagli.setQuantita(quantita);
		assertEquals(30, dettagli.getQuantita());
	}

	@Test
	public void testSetPrezzo() {
		double prezzo = 750;
		dettagli.setPrezzo(prezzo);
		assertEquals(750, prezzo, 750-prezzo);
	}

	@Test
	public void testSetImporto() {
		double importo = 1500;
		dettagli.setImporto(importo);
		assertEquals(1500, importo, 1500-importo);
	}

}
