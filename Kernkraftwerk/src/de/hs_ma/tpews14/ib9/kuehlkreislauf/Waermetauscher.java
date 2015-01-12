package de.hs_ma.tpews14.ib9.kuehlkreislauf;




public class Waermetauscher {

	public static void waermeAusgleichen(Wasserelement heisswasser,
			Wasserelement kuehlwasser) {
		int neueTemperatur = (heisswasser.getTemperatur() + kuehlwasser
				.getTemperatur()) / 2;
		heisswasser.setTemperatur(neueTemperatur);
		kuehlwasser.setTemperatur(neueTemperatur);
	}
}
