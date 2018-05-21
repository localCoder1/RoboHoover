package src;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Scenario
{
    private final Point roomSize;

    private List<Point> patches;

    private String instructions;

    private Point currentCoords;

    private Set<Point> patchesCovered = new HashSet<>();

    public Scenario(Point room, Point coords, List<Point> dirtyPatches, String path)
    {
        this.roomSize =room;
        this.patches = dirtyPatches;
        this.instructions = path.toUpperCase();
        this.currentCoords = coords;
    }

    public Point getRoomSize()
    {
        return roomSize;
    }

    public List<Point> getPatches()
    {
        return patches;
    }

    public String getInstructions()
    {
        return instructions;
    }

    public int getPatchesCoveredCount()
    {
        return patchesCovered.size();
    }

    public void appendPatchesCovered(Point patchesCovered)
    {
        this.patchesCovered.add(patchesCovered);
    }

    public Point getCurrentCoords()
    {
        return currentCoords;
    }

    public void setCurrentCoords(Point currentCoords)
    {
        this.currentCoords = currentCoords;
    }
}
