package com.audronfs.rocketsci.util;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	public static final String SEPARATOR_SPLIT_CHARACTER = ",";
	
	public static final char LEFT = 'L';
	public static final char RIGHT = 'R';
	public static final char MOVE = 'M';	
	
	public static final String EAST = "E";
	public static final String WEST = "W";
	public static final String NORTH = "N";
	public static final String SOUTH = "S";	
	
	public static final String[] CARDINAL_POINTS = { Constants.NORTH,
			Constants.EAST, Constants.SOUTH, Constants.WEST };
			
		public static final Map<String, Integer> CARDINAL_POINTS_MAP = new HashMap<String, Integer>();
		public static final Map<Integer, String> CARDINAL_INDEX_MAP = new HashMap<Integer, String>();
		
		static {
			for(int i=0; i<CARDINAL_POINTS.length;i++) {
				CARDINAL_POINTS_MAP.put(CARDINAL_POINTS[i], i);
				CARDINAL_INDEX_MAP.put(i, CARDINAL_POINTS[i]);
			}	
		}

}
