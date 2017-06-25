package battleship;

import javax.swing.*;

abstract class Tile implements Comparable<Tile> {
    //Attributes:
    ///Primitive
    private int xPos, yPos;
    ///Objects
    private JLabel tileJLabel;
    ///Arrays
    ///Collections
    ///Files
    private ImageIcon backgroundImage;
    //Constructor:
    Tile(int xPos, int yPos) {
        ///Initially Used Setter
        setXPos(xPos);
        setYPos(yPos);
        ///Initially Used Behavior
    }
    //Setter And Getter:
    ///Private Setter
    ///Protected Setter
    void setXPos(int xPos) {
        this.xPos = xPos;
    }
    void setYPos(int yPos) {
        this.yPos = yPos;
    }
    void setBackgroundImage(ImageIcon image) {
        this.backgroundImage = image;
    }
    void setTileJLabel(JLabel label) {
        this.tileJLabel = label;
    }
    ///Public Setter
    ///Private Getter
    ///Protected Getter
    int getXPos() {
        return this.xPos;
    }
    int getYPos() {
        return this.yPos;
    }
    ImageIcon getBackgroundImage() {
        return this.backgroundImage;
    }
    JLabel getTileJLabel() {
        return this.tileJLabel;
    }
    ///Public Getter
    //Behavior:
    ///Private Behavior
    ///Protected Behavior
    ///Public Behavior
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
