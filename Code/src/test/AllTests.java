package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DistanceTest.class, OTTOMoveTimeCalculationTest.class,
		ResultsTest.class, WaypointEqualityTest.class })
public class AllTests {

}
