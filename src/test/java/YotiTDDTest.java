import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import src.Point;
import org.junit.Before;
import org.junit.Test;
import src.RoboticHooverService;
import src.RoboticHooverServiceImpl;
import src.Scenario;

import static org.junit.Assert.*;

public class YotiTDDTest
{
    RoboticHooverService roboticHooverService;

    @Before
    public void before()
    {
        roboticHooverService = new RoboticHooverServiceImpl();
    }

    @Test
    public void roboticHooverTest()
    {
        //create scenario
        Scenario scenario = scenarioFactoryBuilder();

        //create class
        Scenario resultScenario = roboticHooverService.runRoboticHoover(scenario);

        //Assert result
        assertEquals(resultScenario.getCurrentCoords().toString(), "1, 3");
        assertEquals(resultScenario.getPatchesCoveredCount(), 1);
    }

    @After
    public void after()
    {
        roboticHooverService = null;
    }

    private Scenario scenarioFactoryBuilder()
    {
        // Output: {"patches":1,"coords":[1, 3]}
        return new Scenario(
            new Point(5, 5),
            new Point(1, 2),
            new ArrayList<Point>(
                Arrays.asList(
                    new Point(1, 0),
                    new Point(2, 2),
                    new Point(2, 3)
                )),
            "NNESEESWNWW"
        );
    }
}
