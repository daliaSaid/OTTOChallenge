package test;

import static org.junit.Assert.*;

import org.junit.Test;

import solution.Factory;
import solution.Waypoint;

public class DistanceTest {

	/*
	 * Tests the getDistance(Waypoint waypoint) method in the Factory class.
	 */
	@Test
	public void testDistanceToOrigin() {
		Factory testFactory = new Factory();
		Waypoint testWaypoint = new Waypoint(0, 3, 4, 10, 5);
		testFactory.getWaypoints().add(testWaypoint);
		double testResult = Factory.getDistance(testWaypoint);
		assertEquals(5.0, testResult, 0);
	}
	
	/*
	 * Tests the getDistance(Waypoint waypoint1, Waypoint waypoint2) method in the Factory class.
	 */
	@Test
	public void testDistanceToWaypoint() {
		Factory testFactory = new Factory();
		Waypoint testWaypoint1 = new Waypoint(0, 3, 4, 10, 5);
		Waypoint testWaypoint2 = new Waypoint(1, 6, 8, 20, 5);
		testFactory.getWaypoints().add(testWaypoint1);
		testFactory.getWaypoints().add(testWaypoint2);
		double testResult = Factory.getDistance(testWaypoint1, testWaypoint2);
		assertEquals(5.0, testResult, 0);
	}

}
