/** The Fibonacci class is for working with the Fibonacci series without using recursion. */  
public class Fibonacci {

	/* The maximum number of values in the Fibonacci sequence */ 
	public static final int MAX_VALS = 100; 

	int numVals; 
	
	/**
	 * Constructor for Fibonacci
	 * @param numVals - number of values, must be between 1..MAX_VALS.
	 * @throws Exception
	 */
	public Fibonacci(int numVals) throws Exception {
		if (numVals <= 0 || numVals > MAX_VALS) {
			throw new Exception("Illegal numVals argument in constructor for Fibonacci:  " + numVals);
		}
		this.numVals = numVals; 
	}

	/** 
	 * Get the Fibonacci series.  
	 * @return integer array containing the Fibonacci series, with the 0th element value 1. 
	 */
	public int[] getFib() {
		int[] tmpFib = new int[this.numVals];
		tmpFib[0] = 1;
		if (this.numVals >= 2) {
			tmpFib[1] = 2;
			for (int i = 2; i < this.numVals; i++) {
				tmpFib[i] = tmpFib[i-2] + tmpFib[i-1];
			}
		}
		return tmpFib; 
	}
}

class Tester {	
	/** 
	 * The main routine is simply a test harness for Fibonacci
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Fibonacci f = new Fibonacci(10);
			int[] fSeries = f.getFib();
			System.out.println("Here's the fibonacci sequence for " + fSeries.length + " numbers:  ");
			for (int i : fSeries) {
				System.out.println(i);;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return;
		}
	}
}  
