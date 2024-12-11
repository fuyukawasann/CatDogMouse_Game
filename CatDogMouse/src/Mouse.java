// Mouse.java 				Written by David Wagner
// This Class Describes a Mouse

import java.util.Random;

public class Mouse extends Animal {

    /////////////////////////////////////////////////////////////////////////
    //
    // Write this class
    //
    /////////////////////////////////////////////////////////////////////////

    // mouseNumberAtLocation
    // mouseIndexAtLocation

    boolean isCaught;
    Random randomNum;

    static final int NORTHSOUTH = 0;
    static final int SOUTHWEST = 1;

    // Constructor
    public Mouse() {
        super();
        isCaught = false;
        randomNum = new Random();
    }

    public void changeLocation(int x, int y, House house) {
        house.setChar(this.getX(), this.getY(), ' ');
        house.setChar(x, y, getChar());
        this.setXY(x, y);
    }

    // atLocation() -> mouseNumberAtLocation
    // mouseIndexAtLocation(x, y) -> 만약 쥐가 있다면 쥐 넘버를 반환, 아니면 NOMOUSEINDEX를 반환

    public boolean moveNS(House house, Animal player) {
        int newX = this.getX();
        int newY = this.getY();

        if (newX > player.getX()) newX++;
        else if (newX < player.getX()) newX--;

        if (house.emptyLocation(newX, newY) ||
                CatDogMouse.playerLocation(newX, newY)) {
            this.changeLocation(newX, newY, house);
            return true;
        }
        return false;
    }

    public boolean moveEW(House house, Animal player) {
        int newX = this.getX();
        int newY = this.getY();

        if (newY > player.getY()) newY++;
        else if (newY < player.getY()) newY--;

        if (house.emptyLocation(newX, newY) || CatDogMouse.playerLocation(newX, newY)) {
            this.changeLocation(newX, newY, house);
            return true;
        }

        return false;
    }

    public boolean moveOnAxis(House house, Animal player, int axis)
    {
        boolean moved = false;

        if(axis == NORTHSOUTH)
            moved = moveNS(house, player);
        else if(axis == SOUTHWEST)
            moved = moveEW(house, player);

        return moved;
    }

    public void moveMouse(House house, Animal player)
    {
        boolean moved;
        int axis;

        axis = randomNum.nextInt(2);

        moved = moveOnAxis(house, player, axis);

        if(!moved)
        {
            axis++;
            axis %= 2;
            moveOnAxis(house, player, axis);
        }
    }

}

