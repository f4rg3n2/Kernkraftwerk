package de.hs_ma.tpews14.ib9.exception;

public class WaermeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WaermeException(){
		super("Reaktor ist zu heiﬂ, Kernschmelze!!!!");
	}
	
	public WaermeException(String message){
		super(message);
	}

}
