package Kreislauf;

public class Waermetauscher {
	
	private int te;
	private int tk;
	
	public Waermetauscher(int te, int tk){
		this.te = te;
		this.tk = tk;
	}
	
	public int waerme(){
		return (te+tk)/2;
	}
}
