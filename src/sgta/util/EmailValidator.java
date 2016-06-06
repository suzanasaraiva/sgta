package sgta.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private static String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
    
    public static boolean isValid(String email) {
    	Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
    	
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
    }  
}
