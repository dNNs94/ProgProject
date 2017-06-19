package battleship;

import javax.swing.*;

abstract class Tile implements Comparable<Tile> {

    private int xPos, yPos;
    private ImageIcon backgroundImage;
    
    Tile(int xPos, int yPos) {
        setXPos(xPos);
        setYPos(yPos);
    }
    
    void setXPos(int xPos) {
        this.xPos = xPos;
    }
    void setYPos(int yPos) {
        this.yPos = yPos;
    }
    void setBackgroundImage(ImageIcon image) {
        this.backgroundImage = image;
    }
    int getXPos() {
        return this.xPos;
    }
    int getYPos() {
        return this.yPos;
    }
    ImageIcon getBackgroundImage() {
        return this.backgroundImage;
    }
    @Override
    public int compareTo(Tile tile) {
        if (getXPos() < tile.getXPos() && getYPos() <= tile.getYPos()
                || getXPos() < tile.getXPos() && getYPos() > tile.getYPos()
                || getXPos() == tile.getXPos() && getYPos() < tile.getYPos()) {
            return -1;
        } else if (getXPos() > tile.getXPos() && getYPos() <= tile.getYPos()
                || getXPos() > tile.getXPos() && getYPos() > tile.getYPos()
                || getXPos() == tile.getXPos() && getYPos() > tile.getYPos()) {
            return 1;
        }
        return 0;
    }
}
