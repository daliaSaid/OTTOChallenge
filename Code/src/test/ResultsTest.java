package test;

import static org.junit.Assert.*;

import org.junit.Test;

import solution.Factory;
import solution.OTTO;
import solution.Waypoint;

public class ResultsTest {

	/*
	 * Tests the getMinTime(Factory factory) in the OTTO class.
	 */
	@Test
	public void test() {
		Factory testFactory = new Factory(2);
		Waypoint testWaypoint = new Waypoint(0, 50, 50, 20, 0);
		Waypoint endWaypoint = new Waypoint(1, 100, 100, 0, 20);
		testFactory.getWaypoints().add(testWaypoint);
		testFactory.getWaypoints().add(endWaypoint);
		double testResult = OTTO.getMinTime(testFactory);
		System.out.println(testResult);
		assertEquals(90.711, testResult, 0);
	}

}
