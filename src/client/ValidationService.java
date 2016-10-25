package client;

public class ValidationService {
	
	private static ValidationService validationService;

	//Singleton
	private ValidationService(){
		
	}
	
	public static ValidationService getInstance(){
		if(validationService == null){
			return new ValidationService();
		}
		
		return validationService;
	}
	
	/**validates that the user inputs contains at least three words and checks that all words (but the first) are numbers.
	the first word (command) is only checked/validated on the server-side. This is to ensure that new commands can easily
	be created and only the Server will have to be adapted.**/
	
	public String checkInput(String input){
		String [] arr = input.split(" ");
		if(arr[0].equals("help")){
			return "help";
		}
		if(arr[0].equals("exit")){
			return "exit";
		}
		if (arr.length < 3){
			return "Please type a command and at least two numbers.";
		}
		
		for (int i = 1; i < arr.length; i++) {
			if(! isInteger(arr[i])){
				return "Please only type numbers after entering the command.";
			}
		}
		return "";
	}
	
	
	private static boolean isInteger(String str) {
	    int length = str.length();
	    for (int i = 0; i < length; i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	}
	

}
