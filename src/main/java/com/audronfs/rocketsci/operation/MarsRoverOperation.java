package com.audronfs.rocketsci.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.audronfs.rocketsci.model.Plateau;
import com.audronfs.rocketsci.model.Rover;
import com.audronfs.rocketsci.util.Constants;

public class MarsRoverOperation {
	private Plateau plateau = new Plateau();
	private List<Rover> roverList = new ArrayList<Rover>();

	
	public void parseOrders() {		
		Scanner scanner = new Scanner(System.in);	
		String plateauCoordinates;
		String roverPosition;
		int id=0;
		do {
		System.out.println("Plateau dimentions (format example: 20,20).Coordinate must be greater than 0: ");		
		plateauCoordinates=scanner.next();
		}while(!checkInput(plateauCoordinates, id));
		setPlateauCoordinates(plateauCoordinates);
		
		Boolean moreRovers = Boolean.TRUE;
		Integer roverIndex = 0;
		while (moreRovers==Boolean.TRUE) {
			id=1;
			roverIndex++;
			do {
			System.out.println("Rover" + roverIndex + " position (format example: 1,2,N). Cardinal points are N, W, E or S:");
			roverPosition = scanner.next().toUpperCase();
			}while(!checkInput(roverPosition, id));			
			Rover rover = initializeRover(roverPosition);	
			
			System.out.println("Rover" + roverIndex + " Orders (format example: LLMMMRMLMM):");
			String roverOrders = scanner.next().toUpperCase();
			System.out.println("Is there another rover? (Y/N):");
			moreRovers = "Y".equals(scanner.next().toUpperCase()) ? Boolean.TRUE : Boolean.FALSE;			
			rover.setCommands(roverOrders);
			roverList.add(rover);
		}
		
		scanner.close();		
	}
	
	public static Boolean checkInput(String input, int id){
		 Pattern pattern;
		if(id==0) {
			pattern = Pattern.compile("([0-9]+),([0-9]+)$");
		}else {
			pattern = Pattern.compile("([0-9]+),([0-9]+)(,[NSEW])$");
		}     
		Matcher matcher = pattern.matcher(input);
       if(matcher.matches()){       
       	return Boolean.TRUE;
       }else { 
       	System.out.println("Invalid input format. Please, try again");
       	return Boolean.FALSE;
       	}     	        	
       }        
	
	private void setPlateauCoordinates(String rawPlateauCoordinates) {
		String[] tokens;
		tokens = rawPlateauCoordinates.split(Constants.SEPARATOR_SPLIT_CHARACTER);				
		int right = Integer.parseInt(tokens[0]);
		int top = Integer.parseInt(tokens[1]);
		plateau.setCoordinates(right, top);
		}
	
	private Rover initializeRover(String rawRoverPosition) {
		Rover rover;
		String[] tokens;
		tokens = rawRoverPosition.split(Constants.SEPARATOR_SPLIT_CHARACTER);		
		int x = Integer.parseInt(tokens[0]);
		int y = Integer.parseInt(tokens[1]);
		String orientation = tokens[2];
		rover = new Rover(x, y, orientation, plateau);
		return rover;		
	}	
		
		
}	
	


