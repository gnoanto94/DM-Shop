package ordini;

public enum StatiOrdine {
	NUOVO(1),
	IN_LAVORAZIONE(2),
	EVASO(3);
	
	private int value;

	private StatiOrdine(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
