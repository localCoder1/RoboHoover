package Directions;

import src.Point;
import src.Scenario;

public class West implements Directions
{
    @Override
    public void moveDirections(Scenario scenario)
    {
        staticMoveMethod(scenario);
    }

    public static void staticMoveMethod(Scenario scenario)
    {
        Point currentCoords = scenario.getCurrentCoords();
        currentCoords.decrementX();
        scenario.getPatches().stream()
            .filter(point -> point.equals(currentCoords))
            .forEach(p -> scenario.appendPatchesCovered(p));
    }
}
