package application;

public class Counter {

	private int counter;

	Counter() {
		this.counter = 0;
	}
	
	public int getCounter() {
		return this.counter;
	}
	
	public void increment() {
		this.counter=this.counter+1;
	}
}
