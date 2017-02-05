package prodotti;

/**
 * Questa classe rappresenta un oggetto prodotto
 * 
 * @author Pagliarulo Salvatore
 */
public class Prodotto {
	
	/**
	 * Costruttore dell'oggetto prodotto con relativi metodi getter e setter
	 * 
	 * @param marca - marca del prodotto
	 * @param nome - nome del prodotto
	 * @param descrizione - descrizione del prodotto
	 * @param quantitaDisponibile - quantità disponibile del prodotto
	 * @param prezzoVendita - prezzo di vendita del prodotto
	 * @param urlImmagine - URL dell'immagine del prodotto
	 * 
	 * @author Pagliarulo Salvatore
	 */
	public Prodotto(String marca, String nome, String descrizione, int quantitaDisponibile, double prezzoVendita, String urlImmagine) {
		this.marca = marca;
		this.nome = nome;
		this.descrizione = descrizione;
		this.quantitaDisponibile = quantitaDisponibile;
		this.prezzoVendita = prezzoVendita;
		this.urlImmagine = urlImmagine;
	}
	
	
	public Prodotto(String nome) {
		this.nome = nome;
	}
	
	public Prodotto() {
	}

	public int getIdProdotto() {
		return idProdotto;
	}
	public String getMarca() {
		return marca;
	}
	public String getNome() {
		return nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public int getQuantitaDisponibile() {
		return quantitaDisponibile;
	}
	public double getPrezzoVendita() {
		return prezzoVendita;
	}
	public String getUrlImmagine() {
		return urlImmagine;
	}
	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public void setQuantitaDisponibile(int quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	}
	public void setPrezzoVendita(double prezzoVendita) {
		this.prezzoVendita = prezzoVendita;
	}
	public void setUrlImmagine(String urlImmagine) {
		this.urlImmagine = urlImmagine;
	}
	
	
	@Override
	public String toString() {
		return getClass().getName()+" [idProdotto=" + idProdotto + ", marca=" + marca + ", nome=" + nome + ", descrizione="
				+ descrizione + ", quantitaDisponibile=" + quantitaDisponibile + ", prezzoVendita=" + prezzoVendita
				+ "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prodotto other = (Prodotto) obj;
		if (this.nome.equals(other.nome))
			return true;
		else
			return false;
	}

	private int idProdotto, quantitaDisponibile;
	private String marca, nome, descrizione, urlImmagine;
	private double prezzoVendita;

}
