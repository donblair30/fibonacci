/** 
 * The Fibonacci class is for working with the Fibonacci series.  This version doesn't use recursion. 
 */  
public class Fibonacci {

	/* The maximum number of values in the Fibonacci sequence */ 
	public static final int MAX_VALS = 100; 

	/** 
	 * Get the Fibonacci series.  
	 * @param numVals - number of values, must be between 1..MAX_VALS.
	 * @throws Exception
	 * @return integer array containing the Fibonacci series, with the 0th element having value 1. 
	 */
	public static int[] getSeries(int numVals) throws Exception {
		if (numVals <= 0 || numVals > MAX_VALS) {
			throw new Exception("Illegal numVals argument in constructor for Fibonacci:  " + numVals);
		}
		int[] tmpFib = new int[numVals];
		tmpFib[0] = 1;
		if (numVals >= 2) {
			tmpFib[1] = 2;
			for (int i = 2; i < numVals; i++) {
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
			int[] fSeries = Fibonacci.getSeries(12);
			System.out.println("Here's the Fibonacci series for " + fSeries.length + " numbers:  ");
			for (int i : fSeries) {
				System.out.println(i);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return;
		}
	}
}  
