import java.util.Scanner;

import com.audronfs.rocketsci.exception.InvalidInputException;
import com.audronfs.rocketsci.operation.MarsRoverOperation;
import com.audronfs.rocketsci.util.Constants;

public class MarsRoverMain {

	static MarsRoverOperation marsRoverOperation = new MarsRoverOperation();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws InvalidInputException {

		System.out.println("WELCOME TO MARS ROVER - TECH CHALLENGE\n");
		System.out.println("PARSING ORDERS:");
		marsRoverOperation.parsePlateau(scanner);
		marsRoverOperation.parseRover(scanner);
		scanner.close();
		marsRoverOperation.displayAnalysis(Constants.INITIAL);
		marsRoverOperation.operateRovers();
		marsRoverOperation.displayAnalysis(Constants.FINAL);
		System.out.println("\nTHANK YOU FOR USING MARS ROVER - TECH CHALLENGE");
	}
}
