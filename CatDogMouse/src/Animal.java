public class Animal extends HouseObject
	{
		public Animal()
		{
			super();
		}

		public Animal(Location newLocation)
		{
			super(newLocation);
		}
		
		public Animal(int newXCoordinate, int newYCoordinate)
		{
			super(newXCoordinate, newYCoordinate);
		}

//		public void moveNorth()
//		{
//			setXY(getX()-1, getY());
//		}
//
//		public void moveSouth()
//		{
//			setXY(getX()+1, getY());
//		}
//
//		public void moveWest()
//		{
//			setXY(getX(), getY()-1);
//		}
//
//		public void moveEast()
//		{
//			setXY(getX(), getY()+1);
//		}

	}

