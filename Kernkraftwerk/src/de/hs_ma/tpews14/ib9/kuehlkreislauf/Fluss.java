package de.hs_ma.tpews14.ib9.kuehlkreislauf;

public class Fluss {

	/**
	 * @return die Temperatur des Wassers als Wasserelement. Immer 10 Grad.
	 */
	public static Wasserelement gibWasser() {
		return new Wasserelement(10);

	}
}
