package utenti;

public class Utente {
	

	public Utente(String nome, String cognome, String email, String password, String indirizzo, String citta,
			String provincia, String telefono) 
	{
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.provincia = provincia;
		this.telefono = telefono;
	}
	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public String getProvincia() {
		return provincia;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

	@Override
	public String toString() {
		return getClass().getName()+" [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", password="
				+ password + ", indirizzo=" + indirizzo + ", citta=" + citta + ", provincia=" + provincia
				+ ", telefono=" + telefono + "]";
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		if (this.email.equals(other.email))
			return true;
		else
			return false;
	}





	private int id;
	private String nome, cognome, email, password, indirizzo, citta, provincia, telefono;

}
