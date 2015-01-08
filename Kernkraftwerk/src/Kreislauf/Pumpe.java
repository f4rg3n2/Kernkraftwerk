package Kreislauf;

import java.util.LinkedList;
import java.util.Queue;

import Exception.PumpException;

public class Pumpe implements Runnable {
	private int l;
	private LinkedList<Integer> list;
	private Waermetauscher ersterw;
	private Waermetauscher zweiterw;

	public Pumpe(LinkedList<Integer> list, int l) {
		this.list = list;
		this.l = l;
		ersterw = new Waermetauscher(list.getLast(), 10);
		zweiterw = new Waermetauscher(list.getFirst(), ersterw.waerme());
	}

	public int ersterWaermetauscher() {
		list.removeLast();
		list.addFirst(ersterw.waerme());
		return list.getFirst();
	}

	@Override
	public void run() {
		//int i = 0;
		try {
			while(true) {
				synchronized (list) {
					while (list.size() > 12) {
						list.wait();
					}

				
					list.add(10);
					list.notifyAll();

//					if (list.size() == 12) {
//						ersterWaermetauscher();
//						list.removeFirst();
//						list.addFirst(zweiterw.waerme());
//					}
					System.out.print(Thread.currentThread().getName() + ":"
					        + ersterWaermetauscher() + "\t");
					//++i;

				}
				Thread.sleep(l);
			}

			
		} catch (InterruptedException e) {

		}
	}
}
