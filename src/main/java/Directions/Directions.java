package Directions;

import src.Scenario;

public interface Directions
{
    final int LOWER_LIMIT = 0;
    final String OUT_OF_BOUND_MESSAGE = "Can not move, edge of grid. Trying next direction.";

    void moveDirections(Scenario scenario);
}
