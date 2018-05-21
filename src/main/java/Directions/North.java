package Directions;

import src.Point;
import src.Scenario;

public class North implements Directions
{
    @Override
    public void moveDirections(Scenario scenario)
    {
        staticMoveMethod(scenario);
    }

    public static void staticMoveMethod(Scenario scenario)
    {
        Point currentCoords = scenario.getCurrentCoords();
        if (currentCoords.getY() == scenario.getRoomSize().getY())
        {
            System.out.print(OUT_OF_BOUND_MESSAGE);
            return;
        }

        currentCoords.incrementY();
        scenario.getPatches().stream()
            .filter(point -> point.equals(currentCoords))
            .forEach(p -> scenario.appendPatchesCovered(p));
    }
}
