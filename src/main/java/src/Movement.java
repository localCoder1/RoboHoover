package src;

public class Movement
{
    private final String INVALID_DIRECTION_MESSAGE = "Invalid direction. Trying next direction.";

    public void followInstructions(Scenario scenario)
    {
        String[] directions = scenario.getInstructions().split("");

        for (String direction : directions)
        {
            try
            {
                DirectionsType directionsType = DirectionsType.valueOf(direction.toUpperCase());
                directionsType.move(scenario);
            }
            catch (IllegalArgumentException e)
            {
                System.out.print(INVALID_DIRECTION_MESSAGE);
            }
        }
    }
}
