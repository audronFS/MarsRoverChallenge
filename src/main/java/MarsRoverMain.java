import com.audronfs.rocketsci.operation.MarsRoverOperation;

public class MarsRoverMain {	

	static MarsRoverOperation marsRoverOperation = new MarsRoverOperation();

	public static void main(String[] args) {
		
		
			
			System.out.println("WELCOME TO MARS ROVER - TECH CHALLENGE\n");
			System.out.println("PARSING ORDERS:");
			marsRoverOperation.parseOrders();
			
			System.out.println("\nTHANK YOU FOR USING MARS ROVER - TECH CHALLENGE");
	}
}
		
