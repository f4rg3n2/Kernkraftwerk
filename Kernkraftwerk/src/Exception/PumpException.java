package Exception;

public class PumpException extends Exception {

	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    public PumpException(){
    	super("Zu viel Wasser im Reaktor.");
    }
    
    public PumpException(String message){
    	super(message);
    }

}
