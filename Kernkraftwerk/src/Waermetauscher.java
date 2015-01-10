public class Waermetauscher {

	public static void waermeAusgleichen(Wasserelement heisswasser,
			Wasserelement kuehlwasser) {
		int neueTemperatur = (heisswasser.getTemperatur() + kuehlwasser
				.getTemperatur()) / 2;
		heisswasser.setTemperatur(neueTemperatur);
		kuehlwasser.setTemperatur(neueTemperatur);
	}
}
