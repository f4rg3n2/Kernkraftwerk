package de.hs_ma.tpews14.ib9.simulation;
import de.hs_ma.tpews14.ib9.kuehlkreislauf.Pumpe;
import de.hs_ma.tpews14.ib9.reaktor.Reaktor;




public class Leitware {

	public static void main(String[] args) {
		Reaktor reaktor = new Reaktor();
//		Reaktor reaktor1 = new Reaktor(new Wasserelement(1000000));
		reaktor.start();
		new Pumpe(1, reaktor).start();
	}
}
