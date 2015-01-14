package de.hs_ma.tpews14.ib9.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.hs_ma.tpews14.ib9.kuehlkreislauf.Fluss;
import de.hs_ma.tpews14.ib9.kuehlkreislauf.Pumpe;
import de.hs_ma.tpews14.ib9.kuehlkreislauf.Waermetauscher;
import de.hs_ma.tpews14.ib9.kuehlkreislauf.Wasserelement;
import de.hs_ma.tpews14.ib9.reaktor.Reaktor;

public class JUnit {

	@Test
	public void test() {
		Reaktor r = new Reaktor();
		Pumpe p = new Pumpe(1, r);

		Wasserelement w1 = new Wasserelement(50);
		Wasserelement w2 = new Wasserelement(10);
		Waermetauscher.waermeAusgleichen(w1, w2);

		assertEquals(w1.getTemperatur(), 30);
		assertEquals(w2.getTemperatur(), 30);
		assertEquals(Fluss.gibWasser().getTemperatur(), 10);

		Wasserelement w3 = new Wasserelement(10);
		assertEquals(w3.getTemperatur(), 10);

		assertEquals(p.getReaktorZuFluss().size(), 6);
		assertEquals(p.getFlussZuReaktor().size(), 6);

		assertEquals(r.getTemperatur().getTemperatur(), 10);
	}
}
