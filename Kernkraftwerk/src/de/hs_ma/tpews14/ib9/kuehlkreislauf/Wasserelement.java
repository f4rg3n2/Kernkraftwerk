package de.hs_ma.tpews14.ib9.kuehlkreislauf;
public class Wasserelement {
	private int temperatur;

	public Wasserelement(int temperatur) {
		this.temperatur = temperatur;
	}

	public int getTemperatur() {
		return temperatur;
	}

	public void setTemperatur(int temperatur) {
		this.temperatur = temperatur;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Temperatur: "+ temperatur;
	}

}
