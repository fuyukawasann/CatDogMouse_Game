// HouseObject.java
// A HouseObject instance can be any object in the house.
//
// Every HouseObject has a character and a location
//
// Examples:
// 	Up or Down Stair
// 	Helicopter
// 	Dog or Mouse


public class HouseObject
	{
		// Data about the HouseObject
		private char houseObjectChar;
		private Location location;
		
		// Constructor with no parameters
		// Set the Location to 0,0
		public HouseObject()
		{
			this(0,0);
		}

		// Constructor with a Location parameter  
		// Copy the location from the parameter
		public HouseObject(Location newLocation)
		{
			this (newLocation.getX(), newLocation.getY());
		}

		// Constructor with 2 integer parameters
		// Set the location to these coordinates
		public HouseObject(int newXCoordinate, int newYCoordinate)
		{
			location = new Location(newXCoordinate, newYCoordinate);
		}

		public char getChar()
		{
			return houseObjectChar;
		}

		public void setChar(char newChar)
		{
			houseObjectChar = newChar;
		}
			
		public int getX()
		{
			return location.getX();
		}

		public int getY()
		{
			return location.getY();
		}

		public void setXY(int newXCoordinate, int newYCoordinate)
		{
			location.setXY(newXCoordinate, newYCoordinate);
		}

		public void setLocation(Location myLocation)
		{
			location.setLocation(myLocation);
		}

		public Location getLocation()
		{
			return location;
		}

		public boolean isLocation(int x, int y)
		{
			return (x == location.getX() && y == location.getY());
		}
	}

