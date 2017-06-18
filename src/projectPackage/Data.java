package battleship;

import javax.swing.*;

public class Data {
    //Attributes:
    ///Primitive
    private int mainWindowWidth, mainWindowHeight, battlegroundEdgeLength, tileImageEdgeLength, shipListHeight, scoreBoardHeight;
    ///Objects
    private ListAccumulator lists;
    private ImageIcon ocean, shipHullTopBottom, shipHullLeftRight, shipEndTop, shipEndBottom, shipEndLeft, shipEndRight;
    ///Arrays
    ///Collections
    //Constructor:
    Data() {
        ///Initially Used Setter
        ///Initially Used Behavior
    }
    //Setter And Getter:
    ///Private Setter
    ///Protected Setter
    void setShipListHeight() {
        this.shipListHeight = 150;
    }
    void setScoreBoardHeight() {
        this.scoreBoardHeight = 50;
    }
    void setMainWindowWidth() {
        this.mainWindowWidth = 300;
    }
    void setMainWindowHeight() {
        this.mainWindowHeight = 600;
    }
    void setBattlegroundEdgeLength() {
        this.battlegroundEdgeLength = 10;
    }
    void setTileImageEdgeLength() {
        this.tileImageEdgeLength = 20;
    }
    void setOcean() {
        this.ocean = new ImageIcon(getClass().getClassLoader().getResource("resources/images/oceanImage.png")); //exception
    }
    void setShipHullTopBottom() {
        this.shipHullTopBottom = new ImageIcon(getClass().getClassLoader().getResource("resources/images/shipHullTopBottom.png"));
    }
    void setShipHullLeftRight() {
        this.shipHullLeftRight = new ImageIcon(getClass().getClassLoader().getResource("resources/images/shipHullLeftRight.png"));
    }
    void setShipEndTop() {
        this.shipEndTop = new ImageIcon(getClass().getClassLoader().getResource("resources/images/topEndShip.png"));
    }
    void setShipEndBottom() {
        this.shipEndBottom = new ImageIcon(getClass().getClassLoader().getResource("resources/images/bottomEndShip.png"));
    }
    void setShipEndLeft() {
        this.shipEndLeft = new ImageIcon(getClass().getClassLoader().getResource("resources/images/leftEndShip.png"));
    }
    void setShipEndRight() {
        this.shipEndRight = new ImageIcon(getClass().getClassLoader().getResource("resources/images/rightEndShip.png"));
    }
    ///Public Setter
    ///Private Getter
    ///Protected Getter
    int getMainWindowWidth() {
        return mainWindowWidth;
    }
    int getMainWindowHeight() {
        return mainWindowHeight;
    }
    int getBattlegroundEdgeLength() {
        return battlegroundEdgeLength;
    }
    int getTileImageEdgeLength() {
        return tileImageEdgeLength;
    }
    int getShipListHeight() {
        return shipListHeight;
    }
    int getScoreBoardHeight() {
        return scoreBoardHeight;
    }
    ListAccumulator getLists() {
        return lists;
    }
    ImageIcon getOcean() {
        return ocean;
    }
    ImageIcon getShipHullTopBottom() {
        return shipHullTopBottom;
    }
    ImageIcon getShipHullLeftRight() {
        return shipHullLeftRight;
    }
    ImageIcon getShipEndTop() {
        return shipEndTop;
    }
    ImageIcon getShipEndBottom() {
        return shipEndBottom;
    }
    ImageIcon getShipEndLeft() {
        return shipEndLeft;
    }
    ImageIcon getShipEndRight() {
        return shipEndRight;
    }
    ///Public Getter
    //Behavior:
    ///Private Behavior
    ///Protected Behavior
    void loadImages() {
        setOcean();
        setShipHullTopBottom();
        setShipHullLeftRight();
        setShipEndTop();
        setShipEndBottom();
        setShipEndLeft();
        setShipEndRight();
    }
    void loadSizes() {
        setMainWindowHeight();
        setMainWindowWidth();
        setBattlegroundEdgeLength();
        setShipListHeight();
        setScoreBoardHeight();
        setTileImageEdgeLength();
    }
    ///Public Behavior
}
