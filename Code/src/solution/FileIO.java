package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;


public class FileIO {
	
	/*
	 * Constructor for the FileIO class.
	 */
	public FileIO(){
	}
	
	/*
	 * Checks that all waypoint locations are unique.
	 * If they are not unique a text warning is displayed, and the program continues.
	 */
	boolean waypointsAreUnique(ArrayList<Waypoint> waypoints){
		for(int i=0; i<waypoints.size(); i++){
			Waypoint waypoint = waypoints.get(i);
			for(int j=0; j<waypoints.size(); j++){
				if(i != j){
					if(waypoint.isInTheSameLocation(waypoints.get(j))){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/*
	 * This method takes the name of the input file, processes the file to extract all test cases
	 * and returns an instance of the OTTO class, ready for solving.
	 */
	public OTTO readInputFile(String fileName){
		OTTO otto = new OTTO();
		FileInputStream fileInstream;
		try {
			// Variable Initializations.
			fileInstream = new FileInputStream("input.txt");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInstream));
			String line;
			Factory factory;
			ArrayList<Waypoint> waypoints = new ArrayList<Waypoint>();
			int compoundPenalty = 0;
			int waypointId = 0;
			// The file is read, line by line. Each line is split at the space character.
			while ((line = bufferedReader.readLine()) != null) {
				String[] splitLine = line.split(" ");
				// Line has one word, indicating the number of waypoints and a new test case.
				if(splitLine.length == 1){
					int numberOfWaypoints = Integer.parseInt(splitLine[0]);
					// If an invalid number of waypoints is specified, a warning message is displayed, but the program continues.
					if(numberOfWaypoints > 1000){
						System.out.println("Warning! The number of waypoints exceeds 1000");
					}					
					if(waypoints.size()>0){
						Waypoint waypoint = new Waypoint(waypointId, 100, 100, 0, compoundPenalty);
						waypoints.add(waypoint);
						factory = new Factory(waypoints.size());
						factory.setWaypoints(waypoints);
						otto.testCases.add(factory);
					}
					if(numberOfWaypoints == 0){
						break;
					}
					if(!waypointsAreUnique(waypoints)){
						// If not all waypoints are unique, a warning message is displayed, but the program continues.
						System.out.println("Warning! Not all waypoints are unique.");
					}
					waypoints = new ArrayList<Waypoint>();
					waypointId = 0;
					compoundPenalty = 0;
				}
				// The line has three words, indicating that it describes a waypoint.
				if(splitLine.length == 3){
					Waypoint waypoint = new Waypoint(waypointId, Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]), compoundPenalty);
					waypointId++;
					waypoints.add(waypoint);
					compoundPenalty += Integer.parseInt(splitLine[2]);
				}
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Input File Not Found");
		} catch (IOException e) {
			System.out.println("Input File Not Found");
		}
		return otto;
	}
	
	/*
	 * Writes the String output to the file whose name is provided in the outputFileName String.
	 * If no such file exists, one is created.
	 * If the file exists, it is overwritten.
	 */
	public void writeToFile(String output, String outputFileName){
		try{
		    PrintWriter writer = new PrintWriter(outputFileName, "UTF-8");
		    writer.print(output);
		    writer.close();
		} catch (Exception e) {
		   System.out.println("Output File Cannot Be Created");
		}
	}
}

