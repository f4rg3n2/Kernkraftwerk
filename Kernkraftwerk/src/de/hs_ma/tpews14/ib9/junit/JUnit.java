package de.hs_ma.tpews14.ib9.junit;
import static org.junit.Assert.assertEquals;
import de.hs_ma.tpews14.ib9.exception.WaermeException;
import de.hs_ma.tpews14.ib9.kuehlkreislauf.Pumpe;
import de.hs_ma.tpews14.ib9.kuehlkreislauf.Waermetauscher;
import de.hs_ma.tpews14.ib9.kuehlkreislauf.Wasserelement;
import de.hs_ma.tpews14.ib9.reaktor.Reaktor;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
public class JUnit {

	@Test
	public void test() {
		Reaktor r = new Reaktor();
		Pumpe p = new Pumpe(1, r);
		
//		r.start();
//		p.start();
		Wasserelement w1 = new Wasserelement(50);
		Wasserelement w2= new Wasserelement(10);
		Waermetauscher.waermeAusgleichen(w1, w2);
		Wasserelement w3 = new Wasserelement(30);
		
		assertEquals(w1.toString(),w3.toString());
		assertEquals(w2.toString(),w3.toString());
	}
	
	@Test
	public void testKernschmelze(){
	
		try {
			Reaktor r = new Reaktor(new Wasserelement(10000));
			Pumpe p = new Pumpe(1, r);
			p.start();
			r.start();
			fail();
		} catch (WaermeException e) {
			assertTrue(true);
		}

	
	}

}
