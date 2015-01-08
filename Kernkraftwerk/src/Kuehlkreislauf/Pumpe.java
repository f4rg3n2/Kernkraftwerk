package Kuehlkreislauf;

import java.util.LinkedList;

import Exception.PumpException;

public class Pumpe {
	private int l;
	private LinkedList<Integer> list= new LinkedList<>();
	private Waermetauscher w;

	public Pumpe(int l) {
		this.l = l;
	}

	public void Wasserkreislauf() throws PumpException {
		if (list.size() == 12) {
			w.waerme();
		} else {
			while (list.size() < 12) {
				list.add(10);
			}
			if (list.size() > 12) {
				throw new PumpException();
			}
		}

	}
}
