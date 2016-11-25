package solution;

import java.awt.Point;


public class Waypoint extends Point{
	
	// The id of a waypoint. Ids of waipoints start at 0 and increase at increments of 1.
	int id;
	// The time penalty of skipping a waypoint.
	int penalty;
	// The time penalty of skipping all previous waypoints to get to this one (to be subtracted from other waypoints' penalties 
	// to get the total penalty of skipped waypoints assuming more than one waypoint was skipped at a time).
	int compoundPenalty; 
	
	/*
	 * Constructors for the Waypoint Class.
	 */
	public Waypoint(){
		this.x = 0;
		this.y = 0;
		this.penalty = 0;
	}
	
	public Waypoint( int id, int x, int y, int penalty, int compoundPenalty ){
		this.id = id;
		this.x = x;
		this.y = y;
		this.penalty = penalty;
		this.compoundPenalty = compoundPenalty;
	}
	
	/*
	 * Getters and Setter methods for the instance and class variables of the Waypoint class.
	 */
	public int getPenalty() {
		return penalty;
	}

	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

	public int getCompoundPenalty() {
		return compoundPenalty;
	}

	public void setCompoundPenalty(int compoundPenalty) {
		this.compoundPenalty = compoundPenalty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/*
	 * This method checks whether 2 waypoints are at the same location.
	 */
	public boolean isInTheSameLocation(Waypoint waypoint) {

		if (this.x == waypoint.x && this.y == waypoint.y){
			return true;		
		}else{
			return false;
		}


	}
	
	
	
}

