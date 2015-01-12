package de.hs_ma.tpews14.ib9.kuehlkreislauf;

import java.util.LinkedList;
import java.util.Queue;

import de.hs_ma.tpews14.ib9.reaktor.Reaktor;

public class Pumpe extends Thread {

	private Queue<Wasserelement> reaktorZuFluss;
	private Queue<Wasserelement> flussZuReaktor;
	private int pumpFrequenz;
	private Reaktor reaktor;

	public Pumpe(int pumpFrequenz, Reaktor reaktor) {
		this.reaktor = reaktor;
		this.pumpFrequenz = pumpFrequenz;
		reaktorZuFluss = new LinkedList<Wasserelement>();
		flussZuReaktor = new LinkedList<Wasserelement>();
		for (int i = 0; i < 6; i++) {
			reaktorZuFluss.add(new Wasserelement(10));
			flussZuReaktor.add(new Wasserelement(10));
		}
	}

	@Override
	public void run() {
		while (true) {
			synchronized (reaktor.getTemperatur()) {
				Waermetauscher.waermeAusgleichen(reaktor.getTemperatur(),
						flussZuReaktor.peek());
			}
			System.out.print("Reaktor: "
					+ flussZuReaktor.peek().getTemperatur());
			reaktorZuFluss.add(flussZuReaktor.poll());
			
			Waermetauscher.waermeAusgleichen(reaktorZuFluss.peek(),
					Fluss.gibWasser());
			System.out.print(" Fluss: " + reaktorZuFluss.peek().getTemperatur() + "\n");

			flussZuReaktor.add(reaktorZuFluss.poll());
			
		
			try {
				Thread.sleep(pumpFrequenz);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
