package de.hs_ma.tpews14.ib9.reaktor;

import java.util.Date;

import de.hs_ma.tpews14.ib9.exception.WaermeException;
import de.hs_ma.tpews14.ib9.kuehlkreislauf.Wasserelement;

public class Reaktor extends Thread {

	private volatile Wasserelement temperatur;
	private boolean leben;
	private long zeit;

	/**
	 * Initialisiert eine Temperatur(temperatur), die die Temperatur der
	 * Flusswassers darstellt. Initialisiert eine Variable(leben), die die
	 * Laufzeit des Threads beendet und eine Variable(zeit), die das aktuelle
	 * Datum besitzt.
	 * 
	 */
	public Reaktor() {
		temperatur = new Wasserelement(10);
		leben = true;
		zeit = new Date().getTime();
	}

	/**
	 * Ruft dein oberen Konstruktor auf.
	 * 
	 * @param w
	 *            Mann kann eine Temperatur des Wassers einstellen um eine
	 *            Kernschmelze zu simulieren.
	 */
	public Reaktor(Wasserelement w) {
		this();
		temperatur = w;
	}

	@Override
	public void run() {

		while (leben) {
			synchronized (temperatur) {
				temperatur.setTemperatur(temperatur.getTemperatur() + 1);
			}
			if (temperatur.getTemperatur() >= 2878
					|| new Date().getTime() - zeit >= 20000) {
				leben = false;
			} else {
				try {
					Thread.sleep(1000 / 42);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public Wasserelement getTemperatur() {
		return temperatur;
	}

	public long getZeit() {
		return zeit;
	}

}
