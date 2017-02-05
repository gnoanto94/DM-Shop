package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prodotti.Prodotto;

public class ProdottoTest {
	
	private Prodotto prodotto;

	@Before
	public void setUp() throws Exception 
	{
		prodotto = new Prodotto();
		prodotto.setIdProdotto(1);
		prodotto.setMarca("Samsung");
		prodotto.setNome("Galaxy Note 4");
		prodotto.setDescrizione("Telefono Samsung");
		prodotto.setPrezzoVendita(800);
		prodotto.setQuantitaDisponibile(10);
		prodotto.setUrlImmagine("URL");
		assertNotNull(prodotto);
	}

	@After
	public void tearDown() throws Exception 
	{
		prodotto = null;
	}

	@Test
	public void testGetIdProdotto() {
		int id = prodotto.getIdProdotto();
		assertEquals(1, id);
	}

	@Test
	public void testGetMarca() {
		String marca = prodotto.getMarca();
		assertEquals("Samsung", marca);
	}

	@Test
	public void testGetNome() {
		String nome = prodotto.getNome();
		assertEquals("Galaxy Note 4", nome);
	}

	@Test
	public void testGetDescrizione() {
		String descrizione = prodotto.getDescrizione();
		assertEquals("Telefono Samsung", descrizione);
	}

	@Test
	public void testGetQuantitaDisponibile() {
		int quantita = prodotto.getQuantitaDisponibile();
		assertEquals(10, quantita);
	}

	@Test
	public void testGetPrezzoVendita() {
		double prezzo = prodotto.getPrezzoVendita();
		assertEquals(800, prezzo, 800-prezzo);
	}

	@Test
	public void testGetUrlImmagine() {
		String url = prodotto.getUrlImmagine();
		assertEquals("URL", url);
	}

	@Test
	public void testSetIdProdotto() {
		int id = 2;
		prodotto.setIdProdotto(id);
		assertEquals(2, prodotto.getIdProdotto());
	}

	@Test
	public void testSetMarca() {
		String marca = "Apple";
		prodotto.setMarca(marca);
		assertEquals("Apple", prodotto.getMarca());
	}

	@Test
	public void testSetNome() {
		String nome = "Iphone7";
		prodotto.setNome(nome);
		assertEquals("Iphone7", prodotto.getNome());
	}

	@Test
	public void testSetDescrizione() {
		String descrizione = "Telefono Apple";
		prodotto.setDescrizione(descrizione);
		assertEquals("Telefono Apple", prodotto.getDescrizione());
	}

	@Test
	public void testSetQuantitaDisponibile() {
		int quantita = 20;
		prodotto.setQuantitaDisponibile(quantita);
		assertEquals(20, prodotto.getQuantitaDisponibile());
	}

	@Test
	public void testSetPrezzoVendita() {
		double prezzo = 900;
		prodotto.setPrezzoVendita(prezzo);
		assertEquals(900, prezzo, 900-prezzo);
	}

	@Test
	public void testSetUrlImmagine() {
		String url = "URLImage";
		prodotto.setUrlImmagine(url);
		assertEquals("URLImage", prodotto.getUrlImmagine());
	}

}
