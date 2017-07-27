package collectionsfun.validation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExValidation {
	public static void main(String[] args) {

		String number = "012-1234567";
		Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
		Matcher matcher = pattern.matcher(number); 
		 if (matcher.matches()) {
		      System.out.println("Phone Number Valid");
		 }

	}
}
