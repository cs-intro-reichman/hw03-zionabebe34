/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter;    // Monitors the efficiency of the calculation
	static int n; // number of periods
	static double g; // periodical payment
	static double loan; // sum of the loan
	static double rate; // periodical interest rate (as a percentage)
	static double payment; // periodical payment
	static double eb; // ending balance of the loan
	static double low; // lower bound of the periodical payment
	static double high; // upper bound of the periodical payment
	
    /** 
     * Gets the loan data and computes the periodical payment.
     * Expects to get three command-line arguments: sum of the loan (double),
     * interest rate (double, as a percentage), and number of payments (int).  
     */
	public static void main(String[] args) {		
		// Gets the loan data
		loan = Double.parseDouble(args[0]);
		rate = Double.parseDouble(args[1]);
		n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	//compute the periodical payment in brute force algorithm
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
    	g = loan / n; 
		iterationCounter = 0;
    	while (endBalance(loan, rate, n, g ) > epsilon ){
			g+= epsilon; 
			iterationCounter++; 
		}
    	return g;
    }

    //compute the periodical payment in Bi-section algorithm
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
    	iterationCounter = 0;
        high = loan; 
		low = loan /n; 
		g = (high + low) / 2; 
		while ( (high - low) > epsilon ) {
			iterationCounter++;
			if ( (endBalance(loan, rate , n , g) * endBalance(loan, rate , n , low)) > 0){
				low = g;
			} else {
				high = g; 
			}
			g = ( low + high ) / 2;
			
		}
    	return g;
    }

	//compute the remaining from the loan after payments and rates
	private static double endBalance(double loan, double rate, int n, double payment) {	
		eb = loan; 
		for ( int i = 0; i < n; i++ ) {
			eb = (eb - payment) * ( 1 + (rate / 100));
		}
    	return eb;
		//
	}
}