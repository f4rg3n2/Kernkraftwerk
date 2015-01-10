

public class Leitware {

	public static void main(String[] args) {
		Reaktor reaktor = new Reaktor();
		reaktor.start();
		new Pumpe(1000, reaktor).start();
	}
}
