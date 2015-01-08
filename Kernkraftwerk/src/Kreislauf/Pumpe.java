package Kreislauf;

import java.util.LinkedList;
import java.util.Queue;

import Exception.PumpException;

public class Pumpe implements Runnable {
	private int l;
	private Queue<Integer> queue;
	private Waermetauscher ersterw;
	private Waermetauscher zweiterw;

	public Pumpe(Queue<Integer> queue, int l) {
		this.queue = queue;
		this.l = l;
//		ersterw = new Waermetauscher(queue.peek(), 10);
//		zweiterw = new Waermetauscher(queue.peek(), ersterw.waerme());
	}

	public int ersterWaermetauscher() {
//		list.removeLast();
//		list.addFirst(ersterw.waerme());
		return queue.peek();
	}

	@Override
	public void run() {
		//int i = 0;
		try {
			while(true) {
				synchronized (queue) {
					while (queue.size() > 12) {
						queue.wait();
					}

				
					queue.add(10);
					queue.notifyAll();

//					if (list.size() == 12) {
//						ersterWaermetauscher();
//						list.removeFirst();
//						list.addFirst(zweiterw.waerme());
//					}
					int i = queue.peek();
					System.out.println(Thread.currentThread().getName() + ":"
					        + i + "\t");
					//++i;

				}
				Thread.sleep(l);
			}

			
		} catch (InterruptedException e) {

		}
	}
}
