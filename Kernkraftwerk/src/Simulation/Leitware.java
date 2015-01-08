package Simulation;

import java.util.LinkedList;

import Kreislauf.Pumpe;
import Kreislauf.Reaktor;

public class Leitware {
	
	public static void main(String[] args) {
	    LinkedList<Integer> list = new LinkedList<Integer>();
	    list.add(10);
	    
	    Pumpe p = new Pumpe(list,1000);
	    Reaktor r = new Reaktor(list,1000);
	    
	    Thread t1 = new Thread(p,"Pumpe");
	    Thread t2 = new Thread(r,"Reaktor");
	    
	    t1.start();
	    t2.start();
    }
}
