package test;

import static org.junit.Assert.*;

import org.junit.Test;

import solution.Waypoint;

public class WaypointEqualityTest {

	/*
	 * All methods test the isInTheSameLocation(Waypoint waypoint) in the Waypoint class.
	 */
	@Test
	public void testWaypointEqualityTrue() {
		Waypoint testWaypoint1 = new Waypoint(0, 3, 4, 10, 5);
		Waypoint testWaypoint2 = new Waypoint(1, 3, 4, 50, 35);
		boolean testBoolean = testWaypoint1.isInTheSameLocation(testWaypoint2);
		assertTrue(testBoolean);
	}
	
	@Test
	public void testWaypointInequalityX() {
		Waypoint testWaypoint1 = new Waypoint(0, 3, 4, 10, 5);
		Waypoint testWaypoint2 = new Waypoint(1, 4, 4, 50, 35);
		boolean testBoolean = testWaypoint1.isInTheSameLocation(testWaypoint2);
		assertFalse(testBoolean);
	}
	
	@Test
	public void testWaypointInequalityY() {
		Waypoint testWaypoint1 = new Waypoint(0, 3, 4, 10, 5);
		Waypoint testWaypoint2 = new Waypoint(1, 3, 5, 50, 35);
		boolean testBoolean = testWaypoint1.isInTheSameLocation(testWaypoint2);
		assertFalse(testBoolean);
	}

}
