// Define a location in the house as a combination of X and Y Coordinates

public class Location
{
	private int XCoordinate;
	private int YCoordinate;
	
	// Constructor with no parameters
	// Set the Location to 0,0
	public Location()
	{
		this(0,0);
	}

	// Constructor with a Location parameter  
	// Copy the location from the parameter
	public Location(Location newLocation)
	{
		this (newLocation.getX(), newLocation.getY());
	}
	
	// Constructor with 2 integer parameters
	// Set the location to these coordinates
	public Location(int newXCoordinate, int newYCoordinate)
	{
		setXY(newXCoordinate, newYCoordinate);
	}

	public int getX()
	{
		return XCoordinate;
	}

	public int getY()
	{
		return YCoordinate;
	}

	public void setXY(int newXCoordinate, int newYCoordinate)
	{
		XCoordinate = newXCoordinate;
		YCoordinate = newYCoordinate;
	}

	public void setLocation(Location myLocation)
	{
		setXY(myLocation.getX(), myLocation.getY());
	}
}

