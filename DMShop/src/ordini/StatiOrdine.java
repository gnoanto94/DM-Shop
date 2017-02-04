package ordini;

/**
 * Questa classe rappresenta gli stati che può avere un ordine
 * 
 * @author Antonucci Gaetano
 *
 */
public enum StatiOrdine {
	NUOVO(1),
	IN_LAVORAZIONE(2),
	EVASO(3);
	
	private int value;

	/**
	 * Costruttore dello stato dell'ordine con relativo metodo get sul valore
	 * 
	 * @param value - valore dello stato dell'ordine
	 * 
	 * @author Antonucci Gaetano
	 */
	private StatiOrdine(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
