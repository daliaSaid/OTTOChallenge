package solution;

import java.util.ArrayList;

public class Factory {

	// The waypoints of a test case.
	ArrayList<Waypoint> waypoints;
	// The table used by the Dynamic Programming Algorithm.
	double [][] timeTable;
	// The amount of time OTTO lingers at a waypoint.
	int waypointWaitTime = 10;
	
	/*
	 * Constructors for the Factory class.
	 */
	public Factory() {
		this.waypoints = new ArrayList<Waypoint>();
	}
	public Factory(int numberOfWaypoints) {
		this.waypoints = new ArrayList<Waypoint>();
		this.timeTable = new double[numberOfWaypoints][numberOfWaypoints];
	}
	
	/*
	 * Calculates the distance, in meters, between the start position (0,0) and a waypoint.
	 */
	public static double getDistance(Waypoint waypoint1) {

		return Math.sqrt(Math.pow(waypoint1.x, 2) + Math.pow(waypoint1.y, 2));

	}
	
	/*
	 * Calculates the Euclidean distance, in meters, between the two input waypoints: waypoint1 and waypoint2.
	 */
	public static double getDistance(Waypoint waypoint1, Waypoint waypoint2) {

		int xDifference = waypoint1.x - waypoint2.x;
		int yDifference = waypoint1.y - waypoint2.y;
		return Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2));

	}
	
	/*
	 * This method returns the time taken to move otto from the origin at (0,0) to a waypoint.
	 * The time penalties of all skipped waypoints are added to the result time.
	 * The time penalty of waiting at the waypoint is added to the result time.
	 */
	public double getTimeToMoveOTTO(Waypoint waypoint) {
		double time = waypoint.compoundPenalty + waypointWaitTime;
		time += getDistance(waypoint)/OTTO.ottoSpeed;
		return time;
	}
	
	/*
	 * This method calculates the time taken by OTTO to go from the first input waypoint1 to the second input waypoint2.
	 * If there are any skipped waypoints, their penalties are added to the result time.
	 * The penalty of waiting at waypoint2 is added to the result time.
	 */
	public double getTimeToMoveOTTO(Waypoint waypoint1, Waypoint waypoint2) {
		double time = 0;
		if(waypoint2.id != waypoint1.id + 1){
			int compoundPenalty = 0;
			for(int i=waypoint2.id-1;i>waypoint1.id;i--){
				compoundPenalty += waypoints.get(i).penalty;
			}
			time += compoundPenalty;
		}
		time += getDistance(waypoint1, waypoint2)/OTTO.ottoSpeed + waypointWaitTime;
		return time;
	}
	
	/*
	 * Getter and Setter methods for the instance and class variables of the Factory class.
	 */
	public ArrayList<Waypoint> getWaypoints() {
		return waypoints;
	}
	public void setWaypoints(ArrayList<Waypoint> waypoints) {
		this.waypoints = waypoints;
	}
	public double[][] getTimeTable() {
		return timeTable;
	}
	public void setTimeTable(double[][] timeTable) {
		this.timeTable = timeTable;
	}
	public int getWaypointWaitTime() {
		return waypointWaitTime;
	}
	public void setWaypointWaitTime(int waypointWaitTime) {
		this.waypointWaitTime = waypointWaitTime;
	}
	

}

