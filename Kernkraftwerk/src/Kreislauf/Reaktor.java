package Kreislauf;
import java.util.LinkedList;
import java.util.Queue;


public class Reaktor implements Runnable {
	private static final int erwaermungko = 42;
	private int waerme = 10;
	private int l;
	private Queue<Integer> queue;
	
	public Reaktor(Queue<Integer> queue, int l){
		this.queue = queue;
		this.l = l;

	}
	
	
	public int abwaerme(){

		waerme = queue.poll()+1;
//		list.addFirst(waerme);
		return waerme;
	}


	@Override
    public void run() {
	    try{
	    	while(true){
	    		synchronized(queue){
	    			while(queue.isEmpty()){
	    				queue.wait();
	    			}
	    			
	    			queue.notifyAll();
	    			System.out.println(Thread.currentThread().getName() +": "+abwaerme()+", ");
	    		}
	    		Thread.sleep(l);
	    	}
	    }
	    catch(InterruptedException e){
	    }
	    
    }
	
	
	
}
