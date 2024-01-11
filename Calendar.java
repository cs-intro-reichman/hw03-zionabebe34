
public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int DaysInMonth = 31; // Number of days in January
	static int daycountr = 2; //count the days untill is sunday 
	//
 

	//print the calendar of specific year 
	public static void main(String args[]) {
		int yearlast = Integer.parseInt(args[0]);
		advance(yearlast);
		//
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 //the function get a year as argument and print the calendar of the year 
	 private static void advance( int yearChose ) {
		while ( year < (yearChose + 1)) {
			daycountr++; 

			if ( year == yearChose) {
				if ( daycountr  % 7 == 0) {
					System.out.println( dayOfMonth + "/" + month +  "/" + year + " " + "Sunday");
					System.out.println(daycountr); 	

				} else {
					System.out.println(dayOfMonth + "/" + month +  "/" + year);
				}

				dayOfMonth++; 
				if ( (dayOfMonth - 1 ) == (nDaysInMonth(month, yearChose)) ) {
					month++;
					dayOfMonth = 1; 
					if ( month > 12 ) {
						break;
					}
				}	
		    } else {
				year++; 
			}
		
		}
			
		}
		
	 




		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    boolean isLeapYear = false; 

	    //check if the year is divisible by 400
	    boolean yearLeap = ((year % 400) == 0); 

	    //check if the year is divisible by 4 and not by 100
	    isLeapYear = yearLeap || ((( year % 4) == 0) && ((year % 100) != 0));
		return isLeapYear;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		int days = 0; 
		switch (month) {
			case 1:
			    days = 31;
				break;
			case 2:
			     days = (isLeapYear(year))?(29):(28); 
				 break;
			case 3:
			    days = 31;
				break;
			case 4:
			    days = 30;
				break; 
			case 5:
			    days = 31;
				break;
			case 6: 
			    days = 30;
				break; 
			case 7:
			    days = 31;
				break;
			case 8:
			    days = 31;
				break;
			case 9:
			    days = 30;
				break; 
			case 10:
			    days = 31;
				break;
			case 11:
			    days = 30;
				break; 
			case 12:
			    days = 31;
				break;

		}
		return days;
	}
	
}
