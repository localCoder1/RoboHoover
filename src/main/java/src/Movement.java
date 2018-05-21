package src;

public class Movement
{
    private static final int LOWER_LIMIT = 0;

    public void followInstructions(Scenario scenario)
    {
        String[] directions = scenario.getInstructions().split("");

        for (String direction : directions)
        {
            DirectionsType directionsType = DirectionsType.valueOf(direction);
            directionsType.move(scenario);
        }
    }
}
