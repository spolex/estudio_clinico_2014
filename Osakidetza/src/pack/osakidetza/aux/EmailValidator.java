package pack.osakidetza.aux;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator 
{
	 private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 
	    /**
	     * pre:recibe por parámetros el email a validar.
	     * post: se comprueba que cumple el formato email con la expresión regular, devuelve false en caso de no cumplirse.
	     * 
	     * @param email email a validar
	     * @return true email valido, en otro caso false
	     */
	    public static boolean validateEmail(String email) {
	 
	        // Compiles the given regular expression into a pattern.
	        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
	 
	        // Match the given input against this pattern
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	 
	    }	 
	
}
