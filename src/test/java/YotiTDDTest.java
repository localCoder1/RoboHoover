import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import Directions.Directions;
import org.junit.After;
import src.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class YotiTDDTest
{
    RoboticHooverService roboticHooverService;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void before()
    {
        roboticHooverService = new RoboticHooverServiceImpl();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void roboticHoover_NominalTest()
    {
        //create scenario
        Scenario scenario = scenarioFactoryBuilder();

        Point expectedEndPoint = new Point(1, 3);

        //create class
        Scenario resultScenario = roboticHooverService.runRoboticHoover(scenario);

        //Assert result
        assertEquals(resultScenario.getCurrentCoords(), expectedEndPoint);
        assertEquals(resultScenario.getPatchesCoveredCount(), 1);
    }

    @Test
    public void roboticHoover_MoveNorth()
    {
        //create scenario
        Scenario scenario = new Scenario(
            new Point(5, 5),
            new Point(1, 2),
            new ArrayList<Point>(),
            "N"
        );

        Point expectedEndPoint = new Point(1, 3);
        //create class
        Scenario result = roboticHooverService.runRoboticHoover(scenario);

        //Assert result
        assertEquals(result.getCurrentCoords(), expectedEndPoint);
    }

    @Test
    public void roboticHoover_MoveEast()
    {
        //create scenario
        Scenario scenario = new Scenario(
            new Point(5, 5),
            new Point(1, 2),
            new ArrayList<Point>(),
            "E"
        );

        Point expectedEndPoint = new Point(2, 2);

        //create class
        Scenario resultScenario = roboticHooverService.runRoboticHoover(scenario);

        //Assert result
        assertEquals(resultScenario.getCurrentCoords(), expectedEndPoint);
    }

    @Test
    public void roboticHoover_MoveSouth()
    {
        //create scenario
        Scenario scenario = new Scenario(
            new Point(5, 5),
            new Point(1, 2),
            new ArrayList<Point>(),
            "S"
        );

        Point expectedEndPoint = new Point(1, 1);

        //create class
        Scenario resultScenario = roboticHooverService.runRoboticHoover(scenario);

        //Assert result
        assertEquals(resultScenario.getCurrentCoords(), expectedEndPoint);
    }

    @Test
    public void roboticHoover_MoveWest()
    {
        //create scenario
        Scenario scenario = new Scenario(
            new Point(5, 5),
            new Point(1, 2),
            new ArrayList<Point>(),
            "w"
        );

        Point expectedEndPoint = new Point(0, 2);

        //create class
        Scenario resultScenario = roboticHooverService.runRoboticHoover(scenario);

        //Assert result
        assertEquals(resultScenario.getCurrentCoords(), expectedEndPoint);
    }

    @Test
    public void roboticHoover_CantMoveOffGrid()
    {
        //create scenario
        Scenario scenario = new Scenario(
            new Point(5, 5),
            new Point(5, 5),
            new ArrayList<Point>(),
            "N"
        );

        Point expectedEndPoint = new Point(5, 5);

        //create class
        Scenario resultScenario = roboticHooverService.runRoboticHoover(scenario);

        //Assert result
        assertEquals(Directions.OUT_OF_BOUND_MESSAGE, outContent.toString());
        assertEquals(resultScenario.getCurrentCoords(), expectedEndPoint);
    }

    @Test
    public void roboticHoover_ClearDirtPatch()
    {
        //create scenario
        Scenario scenario = new Scenario(
            new Point(5, 5),
            new Point(1, 2),
            new ArrayList<Point>(
                Arrays.asList(
                    new Point(1, 3)
                )),
            "N"
        );

        //create class
        Scenario resultScenario = roboticHooverService.runRoboticHoover(scenario);

        //Assert result
        assertEquals(resultScenario.getPatchesCoveredCount(), 1);
    }

    @Test
    public void roboticHoover_InvalidDirection()
    {
        //create scenario
        Scenario scenario = new Scenario(
            new Point(5, 5),
            new Point(1, 2),
            new ArrayList<Point>(),
            "qN");

        Point expectedEndPoint = new Point(1, 3);

        //create class
        Scenario resultScenario = roboticHooverService.runRoboticHoover(scenario);

        //Assert result
        assertEquals("Invalid direction. Trying next direction.", outContent.toString());
        assertEquals(resultScenario.getCurrentCoords(), expectedEndPoint);
    }

        @After
    public void after()
    {
        roboticHooverService = null;
        System.setOut(System.out);
    }

    // To update to accommodate all scenarios
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
