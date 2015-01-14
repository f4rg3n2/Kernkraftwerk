package de.hs_ma.tpews14.ib9.kuehlkreislauf;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import de.hs_ma.tpews14.ib9.exception.WaermeException;
import de.hs_ma.tpews14.ib9.reaktor.Reaktor;

public class Pumpe extends Thread {

	private Queue<Wasserelement> reaktorZuFluss;
	private Queue<Wasserelement> flussZuReaktor;
	private int pumpFrequenz;
	private Reaktor reaktor;
	private boolean laeuft = true;
	private long zeit;

	/**
	 * Initialisiert 2 Queues, die den Wasserkreislauf simulieren. Einmal von
	 * Reaktor zu fluss und von Fluss zu Reaktor mit jeweils 6 Wasserelementen.
	 * Initialisiert eine Variable (zeit), die die aktuelle Zeit vom Reaktor dar
	 * stellt.
	 * 
	 * @param pumpFrequenz
	 *            stellt die Leistung dar, wie schnell die Pumpe in der Sekunde
	 *            pumpt.
	 * @param reaktor
	 *            , welcher der von der Pumpe gekuehlt werden soll.
	 */
	public Pumpe(int pumpFrequenz, Reaktor reaktor) {
		this.reaktor = reaktor;
		this.pumpFrequenz = 1000 / pumpFrequenz;
		reaktorZuFluss = new LinkedList<Wasserelement>();
		flussZuReaktor = new LinkedList<Wasserelement>();
		zeit = reaktor.getZeit();

		for (int i = 0; i < 6; i++) {
			reaktorZuFluss.add(new Wasserelement(10));
			flussZuReaktor.add(new Wasserelement(10));
		}
	}

	@Override
	public void run() {

		while (laeuft && new Date().getTime() - zeit <= 20000) {
			synchronized (reaktor.getTemperatur()) {
				Waermetauscher.waermeAusgleichen(reaktor.getTemperatur(),
						flussZuReaktor.peek());
			}
			System.out.print("Reaktor: "
					+ flussZuReaktor.peek().getTemperatur());

			reaktorZuFluss.add(flussZuReaktor.poll());

			Waermetauscher.waermeAusgleichen(reaktorZuFluss.peek(),
					Fluss.gibWasser());

			System.out.print(" Fluss: " + reaktorZuFluss.peek().getTemperatur()
					+ "\n");

			flussZuReaktor.add(reaktorZuFluss.poll());

			if (reaktor.getTemperatur().getTemperatur() >= 2878) {
				try {
					laeuft = false;
					throw new WaermeException();

				} catch (WaermeException e) {
					e.printStackTrace();
				}
			} else {
				try {
					Thread.sleep(pumpFrequenz);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public Queue<Wasserelement> getReaktorZuFluss() {
		return reaktorZuFluss;
	}

	public Queue<Wasserelement> getFlussZuReaktor() {
		return flussZuReaktor;
	}

	@Override
	public String toString() {
		return "Reaktor: " + flussZuReaktor.peek().getTemperatur() + " Fluss: "
				+ reaktorZuFluss.peek().getTemperatur() + "\n";
	}

}
