package application;

/**
 * Counter
 * 
 * @author katharina
 *
 */
public class Counter {

	private int counter;

	// **
	// Constructor
	// **
	Counter() {
		this.counter = 0;
	}

	// **
	// Getter
	// **
	public int getCounter() {
		return this.counter;
	}

	// Increases the value of the counter by 1.
	public void increment() {
		this.counter = this.counter + 1;
	}

	// Decreases the value of the counter by 1.
	public void decrement() {
		this.counter = this.counter - 1;
	}

	// Resets the counter
	public void reset() {
		this.counter = 0;
	}
}
