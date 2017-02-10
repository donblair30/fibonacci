import java.util.ArrayList; 

/** 
 * The Fibonacci class is for working with the Fibonacci series.  
 */  
public class Fibonacci {

	/* The maximum number of values in the Fibonacci sequence */ 
	public static final int MAX_VALS = 100; 

	/** 
	 * Get the Fibonacci series using iterative algorithm.  
	 * @param numVals - number of values, must be between 1..MAX_VALS.
	 * @throws Exception
	 * @return fixed-length integer array containing the Fibonacci series, with the 0th element having value 1. 
	 */
	public static int[] getSeries(int numVals) throws Exception {
		if (numVals <= 0 || numVals > MAX_VALS) {
			throw new Exception("Illegal numVals argument in constructor for Fibonacci:  " + numVals);
		}
		int[] tmpFib = new int[numVals];
		tmpFib[0] = 0;
		if (numVals >= 2) {
			tmpFib[1] = 1;
			for (int i = 2; i < numVals; i++) {
				tmpFib[i] = tmpFib[i-2] + tmpFib[i-1];
			}
		}
		return tmpFib; 
	}

	/** 
	 * Get the Fibonacci series using recursion. 
	 * @param numVals - number of values, must be between 1..MAX_VALS.
	 * @throws Exception
	 * @return dynamic array containing the Fibonacci series, with the 0th element having value 1. 
	 */
	public static ArrayList<Integer> getSeriesRecursive(int numVals) throws Exception {
		if (numVals <= 0 || numVals > MAX_VALS) {
			throw new Exception("Illegal numVals argument in constructor for Fibonacci:  " + numVals);
		}
		if (numVals >= 3) {
			ArrayList<Integer> series = getSeriesRecursive(numVals - 1);
			series.add(series.get(numVals-2) + series.get(numVals-3));
			return series; 
		} else if (numVals == 2) {
			ArrayList<Integer> series = new ArrayList<Integer>();
			series.add(0);
			series.add(1);
			return series; 
		} else  { // (numVals == 1) 
			ArrayList<Integer> series = new ArrayList<Integer>();
			series.add(0);
			return series;
		}
	}
}

class Tester {	
	/** 
	 * The is simply a test harness for Fibonacci
	 * @param args
	 */
	public static void main(String[] args) {
		// First compute the series recursively. 
		try {
			ArrayList<Integer> fSeries = Fibonacci.getSeriesRecursive(8);
			System.out.println("Here's the Fibonacci series computed recursively for " + fSeries.size() + " numbers:  ");
			for (Integer j : fSeries) {
				System.out.println(j);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return;
		}

		// Next compute the series iteratively. 
		try {
			int[] fSeries = Fibonacci.getSeries(8);
			System.out.println("Here's the Fibonacci series computed iteratively for " + fSeries.length + " numbers:  ");
			for (int i : fSeries) {
				System.out.println(i);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return;
		}

	}
}  
