package battleship;

import javax.swing.*;
import java.util.LinkedList;

class Player implements Comparable<Player> {
    //Attributes:
    ///Primitive
    private String name;
    private int numberOfShips, score, hits, misses;
    ///Objects
    private MobileObject transmission;
    private Data details;
    private ListAccumulator lists;
    private JLabel nameCell, numberCell, scoreCell, hitsCell, missesCell;
    private MainWindow gui;
    ///Arrays
    ///Collections
    //Constructor:
    Player(String name, int[][][] shipCoords) {
        ///Initially Used Setter
        setName(name);
        setNumberOfShips(8);
        setLists(shipCoords);
        setScore(0);
        setHits(0);
        setMisses(0);
        ///Initially Used Behavior
        determineStatistics(getLists().getFogTiles());
    }
    //Setter And Getter:
    ///Private Setter
    private void setName(String name) {
        this.name = name;
    }
    private void setLists(int[][][] shipCoords) {
        this.lists = new ListAccumulator();
        getLists().setPlayerLists(shipCoords);
        getLists().assemblePlayerLists();
    }
    ///Protected Setter
    void setTransmission(MobileObject transmission) {
        this.transmission = transmission;
    }
    void setTransmissionNew() {
        this.transmission = new MobileObject(getGuiObject().isHit(), returnShot(), returnStatistics());
    }
    void setDetails() {
        this.details = new Data();
    }
    void setNameCell(JLabel nameCell) {
        this.nameCell = nameCell;
    }
    void setNumberCell(JLabel numberCell) {
        this.numberCell = numberCell;
    }
    void setScoreCell(JLabel scoreCell) {
        this.scoreCell = scoreCell;
    }
    void setHitsCell(JLabel hitsCell) {
        this.hitsCell = hitsCell;
    }
    void setMissesCell(JLabel missesCell) {
        this.missesCell = missesCell;
    }
    void setNumberOfShips(int numberOfShips) {
        this.numberOfShips = numberOfShips;
    }
    void setScore(int score) {
        this.score = score;
    }
    void setHits(int hits) {
        this.hits = hits;
    }
    void setMisses(int misses) {
        this.misses = misses;
    }
    void setGui() {
        this.gui = new MainWindow(getLists(), assembleScoreboardInput());
    }
    ///Public Setter
    ///Private Getter
    ///Protected Getter
    Data getDetails() {
        return details;
    }
    MobileObject getTransmission() {
        return transmission;
    }
    ListAccumulator getLists() {
        return lists;
    }
    JFrame getGuiJFrame() {
        return this.gui;
    }
    MainWindow getGuiObject() {
        return this.gui;
    }
    JLabel getNameCell() {
        return nameCell;
    }
    JLabel getNumberCell() {
        return numberCell;
    }
    JLabel getScoreCell() {
        return scoreCell;
    }
    JLabel getHitsCell() {
        return hitsCell;
    }
    JLabel getMissesCell() {
        return missesCell;
    }
    String getName() {
        return name;
    }
    int getNumberOfShips() {
        return this.numberOfShips;
    }
    int getHits() {
        return hits;
    }
    int getMisses() {
        return misses;
    }
    int getScore() {
        return this.score;
    }
    ///Public Getter
    //Behavior:
    ///Private Behavior
    ///Protected Behavior
    String[][] assembleScoreboardInput() {
        String[][] board = new String[2][5];
        String[] stats1 = returnStatistics();
        board[0] = stats1;
        board[1] = getTransmission().getPlayerStats();
        return board;
    }
    void determineHits(LinkedList<FogTile> fogTiles) {
        int turnHits = 0;
        int turnMisses = 0;
        for(FogTile fogButton : fogTiles) {
            if(fogButton.isHit()) {
                turnHits++;
            } else if(fogButton.isMiss()) {
                turnMisses++;
            }
        }
        int tempHits = turnHits - getHits();
        if(tempHits > getHits()) {
            setHits(tempHits);
        }
        int tempMisses = turnMisses - getMisses();
        if(tempMisses > getMisses()) {
            setMisses(tempMisses);
        }

    }
    void determineScore() {
        setScore(getHits() * 15);
    }
    void determineStatistics(LinkedList<FogTile> fogTiles) {
        determineHits(fogTiles);
        determineScore();
    }
    void handleTransmission(MobileObject trans) {
        if(trans.getPlayerShotX() > 0 && trans.getPlayerShotY() > 0) {
            getLists().changeTileHitByEnemy(trans.isHit(), trans.getPlayerShotX(), trans.getPlayerShotY());
            getGuiObject().changeBattleGround(getLists().getGridList());
            getGuiObject().changeScore(assembleScoreboardInput());
        }else if (!trans.isHit() && trans.getPlayerShotX() > 0 && trans.getPlayerShotY() > 0) {

        }
    }
    int[] returnShot() {
        int[] shot = new int[2];
        shot[0] = getGuiObject().getShotX();
        shot[1] = getGuiObject().getShotY();
        return shot;
    }
    String[] returnStatistics() {
        String[] stats = new String[5];
        stats[0] = getName();
        stats[1] = "" + getNumberOfShips();
        stats[2] = "" + getScore();
        stats[3] = "" + getHits();
        stats[4] = "" + getMisses();
        return stats;
    }
    ///Public Behavior
    @Override
   public int compareTo(Player player) {
        if(getScore() < player.getScore()){
            return -1;
        }else if(getScore() > player.getScore()) {
            return 1;
        }
        return 0;
    }
}