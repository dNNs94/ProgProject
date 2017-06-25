//Package Dependency
package battleship;
//Imports
import javax.swing.*;
//Class
class Data {
    //Attributes:
    ///Primitive
    private int mainWindowWidth, mainWindowHeight, gridNumberOfElements, battlegroundEdgeLength, tileImageEdgeLength, shipListHeight, scoreBoardHeight;
    ///Objects
    private ListAccumulator lists;
    private ImageIcon ocean, fog, hit, miss, shipHullTopBottom, shipHullLeftRight, shipEndTop, shipEndBottom, shipEndLeft, shipEndRight;
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
        this.gridNumberOfElements = getBattlegroundEdgeLength() * getBattlegroundEdgeLength();
    }
    void setTileImageEdgeLength() {
        this.tileImageEdgeLength = 20;
    }
    void setOcean() {
        this.ocean = new ImageIcon(getClass().getClassLoader().getResource("resources/images/oceanImage.png")); //exception
    }
    void setFog() {
        this.fog = new ImageIcon(getClass().getClassLoader().getResource("resources/images/fogImage.png")); //exception
    }
    void setHit() {
        this.hit = new ImageIcon(getClass().getClassLoader().getResource("resources/images/hitImage.png"));
    }
    void setMiss() {
        this.miss = new ImageIcon(getClass().getClassLoader().getResource("resources/images/missImage.png")); //exception
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
    int getGridNumberOfElements() {
        return this.gridNumberOfElements;
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
    ImageIcon getFog() { return this.fog; }
    ImageIcon getHit() {
        return hit;
    }
    ImageIcon getMiss() {
        return miss;
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
        setFog();
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
    void loadFogButtonImages() {
        setHit();
        setMiss();
    }
    ///Public Behavior
}
