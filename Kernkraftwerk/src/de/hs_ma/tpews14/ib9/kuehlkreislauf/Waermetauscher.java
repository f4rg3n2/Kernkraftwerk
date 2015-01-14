package de.hs_ma.tpews14.ib9.kuehlkreislauf;

public class Waermetauscher {

	/**
	 * Rechnet 2 unterschiedliche Wassertemperaturen zusammen und gleicht die
	 * Temperatur beider Wasserelemente an.
	 * 
	 * @param heisswasser
	 *            , erste Wasserelement zum verrechnen.
	 * @param kuehlwasser
	 *            , zweites Wasserelement zum verrechnen.
	 */
	public static void waermeAusgleichen(Wasserelement heisswasser,
			Wasserelement kuehlwasser) {
		int neueTemperatur = (heisswasser.getTemperatur() + kuehlwasser
				.getTemperatur()) / 2;
		heisswasser.setTemperatur(neueTemperatur);
		kuehlwasser.setTemperatur(neueTemperatur);
	}
}
