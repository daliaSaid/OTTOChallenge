package solution;

import java.util.ArrayList;

public class OTTO {

	// The factory setups that OTTO needs to solve
	ArrayList<Factory> testCases;
	// OTTO's speed.
	static int ottoSpeed = 2;
	
	/*
	 * Constructor for the OTTO class.
	 */
	public OTTO() {
		this.testCases = new ArrayList<Factory>();
	}

	/*
	 * This method calculates the minimum time taken by OTTO to complete/solve a test case,
	 * provided as a Factory object.
	 * It uses a bottom-up Dynamic Programming approach that stores the solutions of subproblems (the time taken to reach
	 * waypoints from other waypoints) to deduce the optimal minimum time taken by OTTO to solve the test case.
	 * The time table is filled as follows: the table's diagonal elements, representing the time taken to reach each waypoint
	 * with penalties from the origin, are filled out first. Then the table is traversed so that elements adjacent to the 
	 * diagonal are filled out first and so on till the upper-right-most corner of the table is reached. Each cell represents a 
	 * waypoint. For each cell, the minimum of the cell underneath it is compared to the times taken to reach the waypoint that
	 * it represents from all other waypoints represented by cells to its left.  
	 * 
	 */
	public static double getMinTime(Factory factory) {
		// The table's diagonal elements, are filled out first.
		for (int i = 0; i < factory.getWaypoints().size(); i++) {
			factory.getTimeTable()[i][i] = factory
					.getTimeToMoveOTTO(factory.getWaypoints().get(i));
		}
		// The table is traversed diagonally till the upper right-most corner.
		for (int l = 1; l < factory.getWaypoints().size(); l++) {
			for (int i = 0; i < (factory.getWaypoints().size() - l); i++) {
				int j = i + l;
				double cellBelowTime = factory.getTimeTable()[i + 1][j];
				for (int k = i; k < j; k++) {
					double cellToTheLeftTime = factory.getTimeTable()[i][k]
							+ factory.getTimeToMoveOTTO(
									factory.getWaypoints().get(k),
									factory.getWaypoints().get(j));
					if (cellBelowTime < cellToTheLeftTime) {
						factory.getTimeTable()[i][j] = cellBelowTime;
					} else {
						factory.getTimeTable()[i][j] = cellToTheLeftTime;
						cellBelowTime = cellToTheLeftTime;
					}
				}
			}
		}
		double roundedResult = (double) Math.round(factory.getTimeTable()[0][factory.getTimeTable().length-1] * 1000) / 1000;
		return roundedResult;
	}

	/*
	 * The main method that runs the application.
	 * The input and output file names are provided as the first and second arguments respectively.
	 * All test cases (i.e. factory setups) are processed using the getMinTime method and the output is
	 * consolidated into a String. That String is written to the output file.
	 */
	public static void main(String[] args) {
		if(args.length < 2){
			System.out.println("The Input File Name and Output File Name are Required to Run the OTTO Challenge Solution.");
		}else{
			FileIO fileIO = new FileIO();
			String solution = "";
			OTTO otto = fileIO.readInputFile(args[0]);
			for(int i=0;i<otto.testCases.size(); i++){
				solution += getMinTime(otto.testCases.get(i));
				solution += "\n";
			}
			fileIO.writeToFile(solution, args[1]);
		}
	}
}

