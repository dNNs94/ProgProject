package battleship;

import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;

class MainWindow {
    //Attributes:
    ///Primitive
    ///Objects
    private Data sizes;
    private JFrame screen;
    ///Arrays
    ///Collections
    private JPanel battleground, fog, shipList, scoreBoard;
    //Constructor:
    MainWindow() {
        ///Initially Used Setter
        setSizes();
        ///Initially Used Behavior
    }
    //Setter And Getter:
    ///Private Setter
    ///Protected Setter
    void setSizes() {
        this.sizes = new Data();
        getSizes().loadSizes();
    }
    void setScreen() {
        this.screen = new JFrame("Main Window");
        getScreen().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getScreen().setSize(getSizes().getMainWindowWidth(), getSizes().getMainWindowHeight());
        getScreen().setLayout(new BorderLayout());
        getFog().setVisible(true);
    }
    void setBattleground(LinkedList<Tile> tiles) {
        this.battleground = new JPanel();
        getBattleground().setSize(getSizes().getBattlegroundEdgeLength() * getSizes().getTileImageEdgeLength(), getSizes().getBattlegroundEdgeLength() * getSizes().getTileImageEdgeLength());
        getBattleground().setLayout(new GridLayout(getSizes().getBattlegroundEdgeLength(), getSizes().getBattlegroundEdgeLength()));
        assembleBattleground(getBattleground(), tiles);
        getBattleground().setVisible(true);
    }
    void setFog(LinkedList<FogTile> fogTiles) {
        this.fog = new JPanel();
        getFog().setSize(getSizes().getBattlegroundEdgeLength() * getSizes().getTileImageEdgeLength(), getSizes().getBattlegroundEdgeLength() * getSizes().getTileImageEdgeLength());
        getFog().setLayout(new GridLayout(getSizes().getBattlegroundEdgeLength(), getSizes().getBattlegroundEdgeLength()));
        assembleFog(getFog(), fogTiles);
        getFog().setVisible(true);
    }
    void setShipList(LinkedList<Ships> ships) {
        this.shipList = new JPanel();
        getShipList().setSize(getSizes().getBattlegroundEdgeLength() * getSizes().getTileImageEdgeLength(), getSizes().getShipListHeight() * getSizes().getTileImageEdgeLength());
        getShipList().setLayout(new GridLayout(10, 6));
        assembleShipList(getShipList(), ships);
        getShipList().setVisible(true);
    }
    void setScoreBoard(LinkedList<Player> players) {
        this.scoreBoard = new JPanel();
        getScoreBoard().setSize(getSizes().getBattlegroundEdgeLength() * getSizes().getTileImageEdgeLength(), getSizes().getScoreBoardHeight() * getSizes().getTileImageEdgeLength());
        getScoreBoard().setLayout(new GridLayout(2, 6));
        assembleScoreBoard(getScoreBoard(), players);
        getScoreBoard().setVisible(true);
    }

    ///Public Setter
    ///Private Getter
    ///Protected Getter
    JFrame getScreen() {
        return this.screen;
    }
    JPanel getBattleground() {
        return this.battleground;
    }
    JPanel getShipList() {
        return this.shipList;
    }
    JPanel getScoreBoard() {
        return this.scoreBoard;
    }
    JPanel getFog() {
        return this.fog;
    }
    Data getSizes() { return this.sizes; }
    ///Public Getter
    //Behavior:
    ///Private Behavior
    private void assembleBattleground(JPanel battleground, LinkedList<Tile> tiles) {
        for(Tile a : tiles) {
            GridBagConstraints c = new GridBagConstraints();
            ImageIcon tileImage = a.getBackgroundImage();
            JLabel tileElement = new JLabel(tileImage);
            tileElement.setPreferredSize(new Dimension(20, 20));
            c.fill = GridBagConstraints.BOTH;
            c.insets = new Insets(0,0,0,0);
            c.gridx = a.getXPos();
            c.gridy = a.getYPos();
            battleground.add(tileElement, c);
        }
    }
    private void assembleFog(JPanel fog, LinkedList<FogTile> fogTiles) {
        for(FogTile a : fogTiles) {
            GridBagConstraints c = new GridBagConstraints();
            ImageIcon tileImage = a.getBackgroundImage();
            JButton tileElement = new JButton(tileImage);
            tileElement.setPreferredSize(new Dimension(20, 20));
            c.fill = GridBagConstraints.BOTH;
            c.insets = new Insets(0,0,0,0);
            c.gridx = a.getXPos();
            c.gridy = a.getYPos();
            fog.add(tileElement, c);
        }
    }
    private void assembleShipList(JPanel shipList, LinkedList<Ships> ships) {
        int index = 0;
        for(Ships a : ships) {
            GridBagConstraints name = new GridBagConstraints();
            JLabel nameCell = new JLabel(a.getName());
            name.fill = GridBagConstraints.HORIZONTAL;
            name.insets = new Insets(0,0,0,0);
            name.gridx = index;
            name.gridy = 0;
            name.gridwidth = 2;
            shipList.add(nameCell, name);
            GridBagConstraints shipClass = new GridBagConstraints();
            JLabel classCell = new JLabel(a.getShipClass());
            shipClass.fill = GridBagConstraints.HORIZONTAL;
            shipClass.insets = new Insets(0,0,0,0);
            shipClass.gridx = index;
            shipClass.gridy = 2;
            shipClass.gridwidth = 2;
            shipList.add(classCell, shipClass);
            GridBagConstraints numberOfHits = new GridBagConstraints();
            JLabel hitsCell = new JLabel(castIntToString(a.getNumberOfHitsTaken()));
            numberOfHits.fill = GridBagConstraints.HORIZONTAL;
            numberOfHits.insets = new Insets(0,0,0,0);
            numberOfHits.gridx = index;
            numberOfHits.gridy = 4;
            numberOfHits.gridwidth = 1;
            shipList.add(hitsCell, numberOfHits);
            GridBagConstraints running = new GridBagConstraints();
            JLabel runningCell = new JLabel(a.getName());
            running.fill = GridBagConstraints.HORIZONTAL;
            running.insets = new Insets(0,0,0,0);
            running.gridx = index;
            running.gridy = 5;
            running.gridwidth = 1;
            shipList.add(runningCell, running);
            index++;
        }
    }
    private void assembleScoreBoard(JPanel scoreBoard, LinkedList<Player> players) {

    }

    ///Protected Behavior
    void assembleWindow(JPanel battleground, JPanel fog, JPanel shipList, JPanel scoreBoard, LinkedList<Player> players, LinkedList<FogTile> fogTiles, LinkedList<Tile> tiles , LinkedList<Ships> ships) {
        assembleBattleground(battleground, tiles);
        assembleFog(fog, fogTiles);
        assembleShipList(shipList, ships);
        assembleScoreBoard(scoreBoard, players);
    }
    String castIntToString(int integer) {
        char tempChar = (char) (integer + 48);
        String tempString = "" + tempChar;
        return tempString;
    }
    ///Public Behavior
}

