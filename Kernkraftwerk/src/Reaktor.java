
public class Reaktor {
	private int temp;
	private static final int erwaermungko = 42;
	private int waerme = 10;
	
	public int abwaerme(){
		++waerme;
		return waerme;
	}
	
}
