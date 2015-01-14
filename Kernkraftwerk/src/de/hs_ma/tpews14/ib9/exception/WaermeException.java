package de.hs_ma.tpews14.ib9.exception;

public class WaermeException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Wenn Reaktor zu heiß wird, wirft das Programm eine Exception, weil eine
	 * Kernschmelze eintritt.
	 */
	public WaermeException() {
		super("Reaktor ist zu heiß, Kernschmelze!!!!");
	}

	/**
	 * Wirft eine Exception mit der übergebenen Nachricht.
	 * 
	 * @param message
	 */
	public WaermeException(String message) {
		super(message);
	}

}
