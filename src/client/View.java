package client;

public class View {

	
	public void welcome(){
		System.out.println("W  E  L  C  O  M  E  !");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("In order to add, multiply or divide a few numbers, \n"
				+ "please type one of the following commands, followed \nby at least two numbers.");
		System.out.println("--------------------------------------------------------------------------");
		help();
	}
	
	public void help(){
		System.out.println("commands:");
		System.out.println("<add> :		for adding numbers");
		System.out.println("<multiply>:	for multiplying numbers");
		System.out.println("<divide> :	for dividing numbers");
		System.out.println("<help> :	for showing the available commands");
		System.out.println("<exit> :	to exit the program");
	}
	
	public void result(String result){
		System.out.println("RESULT: " + result);
	}
	
	public void goodbye(){
		 System.out.println("Thanks for the conversation. Bye, bye!");
	}
}
