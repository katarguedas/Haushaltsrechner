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
		this.counter = this.counter + 1;
	}

	public void decrement() {
		this.counter = this.counter - 1;
	}

	public void reset() {
		this.counter = 0;
	}
}
