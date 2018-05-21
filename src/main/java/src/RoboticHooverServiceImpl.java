package src;

public class RoboticHooverServiceImpl implements RoboticHooverService
{
    @Override
    public Scenario runRoboticHoover(Scenario scenario)
    {
        Movement movement = new Movement();

        movement.followInstructions(scenario);

        return scenario;
    }
}
