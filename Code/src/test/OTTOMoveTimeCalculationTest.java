package test;

import static org.junit.Assert.*;

import org.junit.Test;

import solution.Factory;
import solution.Waypoint;

public class OTTOMoveTimeCalculationTest {

	/*
	 * Tests the getTimeToMoveOTTO(Waypoint waypoint) in the Factory class.
	 */
	@Test
	public void testTimeToOrigin() {
		Factory testFactory = new Factory();
		Waypoint testWaypoint = new Waypoint(0, 3, 4, 10, 5);
		testFactory.getWaypoints().add(testWaypoint);
		double testResult = testFactory.getTimeToMoveOTTO(testWaypoint);
		assertEquals(17.5, testResult, 0);
	}
	
	/*
	 * Tests the getTimeToMoveOTTO(Waypoint waypoint1, Waypoint waypoint2) in the Factory class.
	 */
	@Test
	public void testTimeToWaypoint() {
		Factory testFactory = new Factory();
		Waypoint testWaypoint1 = new Waypoint(0, 3, 4, 10, 5);
		Waypoint testWaypoint2 = new Waypoint(1, 6, 8, 10, 35);
		testFactory.getWaypoints().add(testWaypoint1);
		testFactory.getWaypoints().add(testWaypoint2);
		double testResult = testFactory.getTimeToMoveOTTO(testWaypoint1, testWaypoint2);
		System.out.println(testResult);
		assertEquals(12.5, testResult, 0);
	}

}
