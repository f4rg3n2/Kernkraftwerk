package Kreislauf;
import java.util.LinkedList;


public class Reaktor implements Runnable {
	private static final int erwaermungko = 42;
	private int waerme = 10;
	private int l;
	private LinkedList<Integer> list;
	
	public Reaktor(LinkedList<Integer> list, int l){
		this.list = list;
		this.l = l;
	}
	
	
	public int abwaerme(){
		waerme = list.getFirst() + 1;
		list.addFirst(waerme);
		return waerme;
	}


	@Override
    public void run() {
	    try{
	    	while(true){
	    		synchronized(list){
	    			while(list.isEmpty()){
	    				list.wait();
	    			}
	    			list.notifyAll();
	    			System.out.print(Thread.currentThread().getName() +": "+abwaerme()+", ");
	    		}
	    		Thread.sleep(l);
	    	}
	    }
	    catch(InterruptedException e){
	    }
	    
    }
	
	
	
}
