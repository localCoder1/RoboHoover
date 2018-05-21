package Directions;

import src.Point;
import src.Scenario;

public class East implements Directions
{
    @Override
    public void moveDirections(Scenario scenario)
    {
        staticMoveMethod(scenario);
    }
    public static void staticMoveMethod(Scenario scenario)
    {
        Point currentCoords = scenario.getCurrentCoords();
        if (currentCoords.getX() == scenario.getRoomSize().getX())
        {
            System.out.print(OUT_OF_BOUND_MESSAGE);
            return;
        }

        currentCoords.incrementX();
        scenario.getPatches().stream()
            .filter(point -> point.equals(currentCoords))
            .forEach(p -> scenario.appendPatchesCovered(p));
    }
}
