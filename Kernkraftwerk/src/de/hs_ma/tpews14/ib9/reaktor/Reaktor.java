package de.hs_ma.tpews14.ib9.reaktor;
import de.hs_ma.tpews14.ib9.kuehlkreislauf.Wasserelement;

public class Reaktor extends Thread {

	private volatile Wasserelement temperatur;

	public Reaktor() {
		temperatur = new Wasserelement(1850);
	}

	@Override
	public void run() {
		while (true) {
			synchronized (temperatur) {
				temperatur.setTemperatur(temperatur.getTemperatur() + 1);
				//System.out.println(temperatur.getTemperatur());
			}
			try {
				Thread.sleep(1000/42);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public Wasserelement getTemperatur() {
		return temperatur;
	}

}
