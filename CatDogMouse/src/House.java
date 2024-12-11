// House.java
// This class contains information about a house
//
// A house is really a 2 dimensional array of characters

import java.util.Random;

public class House
{
	// The house is a square and this is the length of each side 
	static final int HOUSESIZE = 30;
	
	// This is the smallest possible size of the house
	static final int MINHOUSESIZE=18;
	
	// This is the starting floor of the house
	static final int MINFLOOR=1;
	
	static final char OBSTACLECHAR='.';
	
	// Define the size of an obstacle free center region
	// This also defines the region where the cat must start
	// And where no dogs can start
	static final int TOOCLOSE=4;

	// Define the size of an obstructed external region on the top floor
	static final int TOOFAR=8;
	
	
	private char [][] houseChar;

	// This is the count of how many dogs and mice are currently in the house
	private int numDogs;
	private int numMice;
	
	// This is the current size of the house
	private int houseSize;
	
	// These are the current min and max coordinates of the house
	private int minCoord;
	private int maxCoord;
	private float midCoord;
	
	// This is how much smaller the house becomes after every level
	private int sizeIncrement;
	
	// This is the current number of the house
	private int houseNumber;
	
	// This is the current floor number where the player is located
	private int floorNumber;
	
	// This is the highest floor reached by the player
	private int maxFloorReached;
	

	// Constructor with no parameters

	public House()
	{
		this(HOUSESIZE);
	}

	// Constructor with one size parameter

	public House(int size)
	{
		houseChar = new char [size][size];
	}
	
	// Getters
	
	public char getChar(int x, int y)
	{
		return houseChar[x][y];
	}

	public int getHouseSize()
	{
		return houseSize;
	}

	public int getSizeIncrement()
	{
		return sizeIncrement;
	}

	public int getHouseNumber()
	{
		return houseNumber;
	}

	public int getFloorNumber()
	{
		return floorNumber;
	}

	public int getMaxFloorReached()
	{
		return maxFloorReached;
	}

	public int getMinCoord()
	{
		return minCoord;
	}

	public int getMaxCoord()
	{
		return maxCoord;
	}

	public float getMidCoord()
	{
		return midCoord;
	}

	// Setters

	public void setChar(int x, int y, char newChar)
	{
		houseChar[x][y] = newChar;
	}

	public void setHouseSize(int newSize)
	{
		houseSize = newSize;
	}

	public void setSizeIncrement(int newIncrement)
	{
		sizeIncrement = newIncrement;
	}

	public void setHouseNumber(int newNumber)
	{
		houseNumber = newNumber;
	}

	public void setFloorNumber(int newNumber)
	{
		floorNumber = newNumber;
	}

	public void setMaxFloorReached(int newNumber)
	{
		maxFloorReached = newNumber;
	}

	public void setMinCoord(int newMinCoord)
	{
		minCoord = newMinCoord;
	}

	public void setMaxCoord(int newMaxCoord)
	{
		maxCoord = newMaxCoord;
	}

	public void setMidCoord(int newMidCoord)
	{
		midCoord = newMidCoord;
	}

	/////////////////////////////////////////////////////////////////////////
	//
	// This function changes the size of the house
	//
	/////////////////////////////////////////////////////////////////////////
	
	public void changeHouseSize(int newHouseSize)
	{
		setHouseSize(newHouseSize);
		setMinCoord((HOUSESIZE-getHouseSize())/2);
		setMaxCoord(HOUSESIZE-(HOUSESIZE-getHouseSize())/2);
		setMidCoord((getMinCoord() + getMaxCoord()-1)/2);
	}
	

	/////////////////////////////////////////////////////////////////////////
	//
	// This function starts the player in a new house
	//
	/////////////////////////////////////////////////////////////////////////
	
	public void startHouse(int number)
	{
		setHouseNumber(number);
		setSizeIncrement((HOUSESIZE - MINHOUSESIZE) / number);
		// Start each house with the biggest possible house
		changeHouseSize(HOUSESIZE);
		// Start on the bottom floor, and reset the highest visited floor
		setFloorNumber(1);
		setMaxFloorReached(getFloorNumber());
	
	}

	/////////////////////////////////////////////////////////////////////////
	//
	// Add walls to the four sides of the house
	//
	/////////////////////////////////////////////////////////////////////////

	public void buildWalls()
	{
		int i;
		for (i=minCoord; i<maxCoord; i++)
		{
			setChar(getMinCoord(),i,'-');
			setChar(getMaxCoord()-1,i,'-');
			setChar(i,getMinCoord(),'|');
			setChar(i,getMaxCoord()-1,'|');
	
		}

	}

	/////////////////////////////////////////////////////////////////////////
	//
	// Add some obstacles and empty spaces to the house at random
	// The center of the house should have no obstacles
	// The region away from the center of the top floor should be all obstacles
	//
	/////////////////////////////////////////////////////////////////////////
	
	public void buildObstacles(Random randomNum)
	{
		int i, j;
		for (i=0; i<HOUSESIZE; i++)
		{
			for (j=0; j<HOUSESIZE; j++)
			{
				if (outside(i,j)) 
				{
					setChar(i,j,' ');
				}
	
				else if (inside(i,j))
				{
					if (closerToCenter(i,j, TOOCLOSE))
					{
						setChar(i,j,' ');
					} 
					else if (topFloor() &&
						!closerToCenter(i,j, TOOFAR))
					{
						setChar(i,j,OBSTACLECHAR);
					} 
					else if (randomNum.nextInt(5) == 0) 
					{
						setChar(i,j,OBSTACLECHAR);
					} 
					else
					{
						setChar(i,j,' ');
					}
				}
			}
		}
	}
	
	/////////////////////////////////////////////////////////////////////////
	//
	// Return the square of the distance from the coords to the house center 
	//
	/////////////////////////////////////////////////////////////////////////
	
	public float centerDistSquared(int i, int j)
	{
		float iDist = i - getMidCoord();
		float jDist = j - getMidCoord();
	
		return (iDist * iDist) + (jDist * jDist);
	}
	
	/////////////////////////////////////////////////////////////////////////
	//
	// This is a boolean function.  It can return true or false
	//
	// This funcation returns true if the coords (i,j) are closer
	// to the house center than the given distance 
	//
	/////////////////////////////////////////////////////////////////////////
	
	public boolean closerToCenter(int i, int j, float distance)
	{
		if (centerDistSquared(i,j) < distance * distance)
		{
			return true;
		}
		return false;
	}
	


	/////////////////////////////////////////////////////////////////////////
	//
	// This is a boolean function.  It can return true or false
	//
	// Return true if the given coordinates are inside the house
	//
	/////////////////////////////////////////////////////////////////////////

	public boolean inside(int i, int j)
	{
		if (i > getMinCoord() && i < getMaxCoord()-1 && j > getMinCoord() && j < getMaxCoord()-1)
		{
			return true;
		} else {
			return false;
		}
	}

	/////////////////////////////////////////////////////////////////////////
	//
	// This is a boolean function.  It can return true or false
	//
	// Return true if the given coordinates are outside the house
	//
	/////////////////////////////////////////////////////////////////////////
	
	public boolean outside(int i, int j)
	{
		if (i < getMinCoord() || i > getMaxCoord()-1 || j < getMinCoord() || j > getMaxCoord()-1)
		{
			return true;
		} else {
			return false;
		}
	}

	/////////////////////////////////////////////////////////////////////////
	//
	// Pick a random location in the house, and assign that location to myLocation
	//
	// This function changes the value of myLocation in the parameter
	//
	/////////////////////////////////////////////////////////////////////////
	
	public void chooseRandomLocation(Location myLocation, Random randomNum)
	{
		int randomX = randomNum.nextInt(maxCoord-minCoord);
		int randomY = randomNum.nextInt(maxCoord-minCoord);
		myLocation.setXY(minCoord + randomX, minCoord + randomY);
	}

	/////////////////////////////////////////////////////////////////////////
	//
	// This is a boolean function.  It can return true or false
	//
	// This function checks if the house is empty at location x,y
	// If the house is empty at this location it returns true
	//
	/////////////////////////////////////////////////////////////////////////
	
	public boolean emptyLocation(int x, int y)
	{
		if (getChar(x,y) == ' ')
		{
			return true;
		}
		return false;
	}
	
	public boolean emptyLocation(Location myLocation)
	{
		return emptyLocation(myLocation.getX(), myLocation.getY());
	}
	
	/////////////////////////////////////////////////////////////////////////
	//
	// Pick an empty location in the house at random, 
	// and assign that location to myLocation
	//
	// This function changes the value of myLocation in the parameter
	//
	/////////////////////////////////////////////////////////////////////////
	
	public void chooseEmptyLocation(Location myLocation, Random randomNum)
	{
		chooseRandomLocation(myLocation, randomNum);
	
		while (!emptyLocation(myLocation))
		{
			chooseRandomLocation(myLocation, randomNum);
		}
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////
	//
	// This is a boolean function.  It can return true or false
	//
	// This funcation returns true if the player is on the bottom floor
	//
	/////////////////////////////////////////////////////////////////////////
	
	public boolean bottomFloor()
	{
		if (getFloorNumber() <= MINFLOOR)
		{
			return true;
		}
		return false;
	}
	
	
	/////////////////////////////////////////////////////////////////////////
	//
	// This is a boolean function.  It can return true or false
	//
	// This funcation returns true if the player is on the top floor of the house
	//
	/////////////////////////////////////////////////////////////////////////
	
	public boolean topFloor()
	{
		if (getHouseSize() <= MINHOUSESIZE)
		{
			return true;
		}
		return false;
	}


	/////////////////////////////////////////////////////////////////////////
	//
	// Print out the house
	//
	/////////////////////////////////////////////////////////////////////////
	
	public void printHouse()
	{
		int i,j;
	
		for (i=0; i<HOUSESIZE; i++)
		{
			for (j=0; j<HOUSESIZE; j++)
			{
				System.out.printf("%c", getChar(i,j));
			}
			System.out.printf("\n");
		}
	}

	
}
