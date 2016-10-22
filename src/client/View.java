package client;

public class View {

	
	public void welcome(){
		System.out.println("Welcome. In order to add, multiply or divide a few numbers,"
				+ "please type one of the following commands, followed by at least two numbers. ");
		System.out.println("--------------------------------------------------------------------------");
		help();
	}
	
	public void help(){
		System.out.println("commands:");
		System.out.println("<add> : for adding numbers");
		System.out.println("<multiply>: for multiplying numbers");
		System.out.println("<divide> : for dividing numbers");
	}
	
	public void result(String result){
		System.out.println("The result of the requested arithmetic operation is: " + result);
	}
	
	public void goodbye(){
		 System.out.println("Thanks for the conversation. Bye, bye!");
	}
}
