
public class Extraction {


		public static void main(String[] args) {
	        // Input string
	        String input = "Search appearances45731Recruiter actions1225";

	        // Format the output
	        String formattedOutput = formatText(input);

	        // Print the result
	        System.out.println(formattedOutput);
	    }

	    private static String formatText(String text) {
	       
	        return text.replaceAll("(\\D+)(\\d+)", "$1 : $2   ").trim();
	    }

}
