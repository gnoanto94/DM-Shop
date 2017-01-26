package prodotti;

public class Prodotto {
	
	
	public Prodotto(String marca, String nome, String descrizione, String quantitaDisponibile, double prezzoVendita) {
		this.marca = marca;
		this.nome = nome;
		this.descrizione = descrizione;
		this.quantitaDisponibile = quantitaDisponibile;
		this.prezzoVendita = prezzoVendita;
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
	public String getQuantitaDisponibile() {
		return quantitaDisponibile;
	}
	public double getPrezzoVendita() {
		return prezzoVendita;
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
	public void setQuantitaDisponibile(String quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	}
	public void setPrezzoVendita(double prezzoVendita) {
		this.prezzoVendita = prezzoVendita;
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

	private int idProdotto;
	private String marca, nome, descrizione, quantitaDisponibile;
	private double prezzoVendita;

}
