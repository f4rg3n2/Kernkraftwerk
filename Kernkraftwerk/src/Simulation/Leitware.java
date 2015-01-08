package Simulation;

import java.util.LinkedList;
import java.util.Queue;

import Kreislauf.Pumpe;
import Kreislauf.Reaktor;

public class Leitware {
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
//		queue.add(10);
	    Pumpe p = new Pumpe(queue,1000);
	    Reaktor r = new Reaktor(queue,1000);
	    
	    Thread t1 = new Thread(p,"Pumpe");
	    Thread t2 = new Thread(r,"Reaktor");
	    
	    
	    t2.start();
	    t1.start();
    }
}
