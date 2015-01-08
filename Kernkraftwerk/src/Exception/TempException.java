package Exception;

public class TempException extends Exception {

	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    public TempException(){
    	super("Temperatur zu hoch!!!");
    }
    
    public TempException(String message){
    	super(message);
    }

}
