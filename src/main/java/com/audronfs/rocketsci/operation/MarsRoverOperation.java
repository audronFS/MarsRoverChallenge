package com.audronfs.rocketsci.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.audronfs.rocketsci.model.Plateau;
import com.audronfs.rocketsci.model.Rover;

public class MarsRoverOperation {
	private Plateau plateau = new Plateau();
	private List<Rover> roverList = new ArrayList<Rover>();

	
	public void parseOrders() {
//		retrieveInput();
//	}
//
//	public void retrieveInput() throws MarsRoverInputException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("plateau size (format example: 3,5):");
		setPlateauCoordinates(scanner.next());
		
		Boolean moreRovers = Boolean.TRUE;
		Integer roverIndex = 0;
		while (moreRovers==Boolean.TRUE) {
			roverIndex++;
			System.out.println("rover" + roverIndex + " position (format example: 1,2,N):");
			String roverPosition = scanner.next().toUpperCase();
			System.out.println("rover" + roverIndex + " orders (format example: LLMMMRMLMM):");
			String roverOrders = scanner.next().toUpperCase();
			System.out.println("is there another rover? (Y/N):");
			moreRovers = "Y".equals(scanner.next().toUpperCase()) ? Boolean.TRUE : Boolean.FALSE;			
			Rover rover = initializeRover(roverPosition);			
			roverList.add(rover);
		}		
		scanner.close();		
	}
	
	private void setPlateauCoordinates(final String rawPlateauCoordinates) {
		
	}
	
	private Rover initializeRover(String rawRoverPosition)  {
		return null;
	
	}	

	public void operateRovers() {
		
		}
	}	
	


