/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String str = " "; 

        for ( int i = 0; i < s.length(); i++) {
            if ( s.charAt(i) == ' ') {
                str += s.charAt(i); 
            } else {
                int index = s.indexOf(s.charAt(i)); 
                if ( index != i) {
                    continue;
                } else {
                    char newChar = s.charAt(index); 
                    str += newChar;

                }
                 
            }
        }
        return str; 
        
    }
}