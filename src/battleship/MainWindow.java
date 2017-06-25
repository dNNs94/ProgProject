//Package Dependency
package battleship;
//Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
//Class
class MainWindow extends JFrame {
    //Attributes:
    ///Primitive
    private boolean done, hit;
    private int shotX, shotY;
    ///Objects
    private ListAccumulator playerLists;
    private Data sizes;
    private JFrame screen;
    ///Arrays
    private JButton[] fogFastAccess;
    private JLabel[] gridFastAccess, scoreFastAccess;
    ///Collections
    private JPanel battleground, fog, shipList, scoreBoard;
    //Constructor:
    MainWindow(ListAccumulator playerLists, String[][] stats) {
        ///Initially Used Setter
        setSizes();
        setPlayerLists(playerLists);
        setFastAccessArrays();
        setScreen(getPlayerLists(), stats);
        ///Initially Used Behavior
    }
    //Setter And Getter:
    ///Private Setter
    ///Protected Setter
    void setDone(boolean done){
        this.done = done;
    }
    void setHit(boolean hit) {
        this.hit = hit;
    }
    void setShotX(int shotX) {
        this.shotX = shotX;
    }
    void setShotY(int shotY) {
        this.shotY = shotY;
    }
    void setPlayerLists(ListAccumulator playerLists) {
        this.playerLists = playerLists;
    }
    void setSizes() {
        this.sizes = new Data();
        getSizes().loadSizes();
        getSizes().loadFogButtonImages();
    }
    void setFastAccessArrays() {
        this.gridFastAccess = new JLabel[getSizes().getGridNumberOfElements()];
        this.fogFastAccess = new JButton[getSizes().getGridNumberOfElements()];
        this.scoreFastAccess = new JLabel[5];
    }
    void setFogFastAccessIndex(int index, JButton element) {
        this.fogFastAccess[index] = element;
    }
    void setGridFastAccessIndex(int index, JLabel element) {
        this.gridFastAccess[index] = element;
    }
    void setScoreFastAccessIndex(int index, JLabel element) {
        this.scoreFastAccess[index] = element;
    }
    void setScreen(ListAccumulator playerLists, String[][] stats) {
        this.screen = new JFrame("Main Window");
        getScreen().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getScreen().setSize(getSizes().getMainWindowWidth(), getSizes().getMainWindowHeight());
        getScreen().setLayout(new BorderLayout());
        setBattleground(playerLists.getGridList());
        getScreen().add(getBattleground(), BorderLayout.CENTER);
        setFog(playerLists.getFogTiles(), playerLists);
        getScreen().add(getFog(), BorderLayout.CENTER);
        setShipList(playerLists.getShips());
        getScreen().add(getShipList(), BorderLayout.SOUTH);
        setScoreBoard(stats);
        getScreen().add(getScoreBoard(), BorderLayout.SOUTH);
        getScreen().setVisible(false);
    }
    void setBattleground(LinkedList<Tile> tiles) {
        this.battleground = new JPanel();
        getBattleground().setSize(getSizes().getBattlegroundEdgeLength() * getSizes().getTileImageEdgeLength(), getSizes().getBattlegroundEdgeLength() * getSizes().getTileImageEdgeLength());
        getBattleground().setLayout(new GridLayout(getSizes().getBattlegroundEdgeLength(), getSizes().getBattlegroundEdgeLength()));
        assembleBattleground(getBattleground(), tiles);
        getBattleground().setVisible(true);
    }
    void setFog(LinkedList<FogTile> fogTiles, ListAccumulator playerLists) {
        this.fog = new JPanel();
        getFog().setSize(getSizes().getBattlegroundEdgeLength() * getSizes().getTileImageEdgeLength(), getSizes().getBattlegroundEdgeLength() * getSizes().getTileImageEdgeLength());
        getFog().setLayout(new GridLayout(getSizes().getBattlegroundEdgeLength(), getSizes().getBattlegroundEdgeLength()));
        assembleFog(getFog(), fogTiles, playerLists);
        getFog().setVisible(true);
    }
    void setShipList(LinkedList<Ships> ships) {
        this.shipList = new JPanel();
        getShipList().setSize(getSizes().getBattlegroundEdgeLength() * getSizes().getTileImageEdgeLength(), getSizes().getShipListHeight() * getSizes().getTileImageEdgeLength());
        getShipList().setLayout(new GridLayout(10, 6));
        assembleShipList(getShipList(), ships);
        getShipList().setVisible(true);
    }
    void setScoreBoard(String[][] s) {
        this.scoreBoard = new JPanel();
        getScoreBoard().setSize(getSizes().getBattlegroundEdgeLength() * getSizes().getTileImageEdgeLength(), getSizes().getScoreBoardHeight() * getSizes().getTileImageEdgeLength());
        getScoreBoard().setLayout(new GridLayout(2, 6));
        assembleScoreBoard(getScoreBoard(), s);
        getScoreBoard().setVisible(true);
    }
    ///Public Setter
    ///Private Getter
    ///Protected Getter
    boolean isDone() {
        return this.done;
    }
    boolean isHit() { return this.hit; }
    int getShotX() {
        return shotX;
    }
    int getShotY() {
        return shotY;
    }
    ListAccumulator getPlayerLists() {
        return this.playerLists;
    }
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
    JButton[] getFogFastAccess() {
        return fogFastAccess;
    }
    JButton getFogFastAccessIndex(int index) {
        return fogFastAccess[index];
    }
    JLabel[] getGridFastAccess() {
        return gridFastAccess;
    }
    JLabel getGridFastAccessIndex(int index) {
        return gridFastAccess[index];
    }
    JLabel[] getScoreFastAccess() {
        return gridFastAccess;
    }
    JLabel getScoreFastAccessIndex(int index) {
        return scoreFastAccess[index];
    }
    ///Public Getter
    //Behavior:
    ///Private Behavior
    private void assembleBattleground(JPanel battleground, LinkedList<Tile> tiles) {
        for(Tile a : tiles) {
            GridBagConstraints c = new GridBagConstraints();
            ImageIcon tileImage = a.getBackgroundImage();
            a.setTileJLabel(new JLabel(tileImage));
            setGridFastAccessIndex(tiles.indexOf(a), a.getTileJLabel());
            getGridFastAccessIndex(tiles.indexOf(a)).setPreferredSize(new Dimension(getSizes().getTileImageEdgeLength(), getSizes().getTileImageEdgeLength()));
            c.fill = GridBagConstraints.BOTH;
            c.insets = new Insets(0,0,0,0);
            c.gridx = a.getXPos();
            c.gridy = a.getYPos();
            battleground.add(getGridFastAccessIndex(tiles.indexOf(a)), c);
        }
    }
    private void assembleFog(JPanel fog, LinkedList<FogTile> fogTiles, ListAccumulator enemyShipList) {
        for(FogTile a : fogTiles) {
            GridBagConstraints c = new GridBagConstraints();
            ImageIcon tileImage = a.getBackgroundImage();
            a.setButton(new JButton(tileImage));
            a.getButton().addActionListener(new ShotAssessment(a, enemyShipList.getEnemyShipList()));
            setFogFastAccessIndex(fogTiles.indexOf(a), a.getButton());
            getFogFastAccessIndex(fogTiles.indexOf(a)).setPreferredSize(new Dimension(getSizes().getTileImageEdgeLength(), getSizes().getTileImageEdgeLength()));
            c.fill = GridBagConstraints.BOTH;
            c.insets = new Insets(0, 0, 0, 0);
            c.gridx = a.getXPos();
            c.gridy = a.getYPos();
            fog.add(getFogFastAccessIndex(fogTiles.indexOf(a)), c);
        }
    }
    private void assembleShipList(JPanel shipList, LinkedList<Ships> ships) {
        int index = 0;
        for(Ships a : ships) {
            GridBagConstraints name = new GridBagConstraints();
            a.setNameCell(new JLabel(a.getName()));
            name.fill = GridBagConstraints.HORIZONTAL;
            name.insets = new Insets(0,0,0,0);
            name.gridx = index;
            name.gridy = 0;
            name.gridwidth = 2;
            shipList.add(a.getNameCell(), name);
            GridBagConstraints shipClass = new GridBagConstraints();
            a.setClassCell(new JLabel(a.getShipClass()));
            shipClass.fill = GridBagConstraints.HORIZONTAL;
            shipClass.insets = new Insets(0,0,0,0);
            shipClass.gridx = index;
            shipClass.gridy = 2;
            shipClass.gridwidth = 2;
            shipList.add(a.getClassCell(), shipClass);
            GridBagConstraints numberOfHits = new GridBagConstraints();
            a.setHitsCell(new JLabel(Integer.toString(a.getNumberOfHitsTaken())));
            numberOfHits.fill = GridBagConstraints.HORIZONTAL;
            numberOfHits.insets = new Insets(0,0,0,0);
            numberOfHits.gridx = index;
            numberOfHits.gridy = 4;
            numberOfHits.gridwidth = 1;
            shipList.add(a.getHitsCell(), numberOfHits);
            GridBagConstraints running = new GridBagConstraints();
            a.setRunningCell(new JLabel(castBooleanToString(a.isRunning())));
            running.fill = GridBagConstraints.HORIZONTAL;
            running.insets = new Insets(0,0,0,0);
            running.gridx = index;
            running.gridy = 5;
            running.gridwidth = 1;
            shipList.add(a.getRunningCell(), running);
            index++;
        }
    }
    private void assembleScoreBoard(JPanel scoreBoard,String[][] s) {
        String[] player = new String[5];
        String[] enemy = new String[5];
        for(int i = 0; i < s[i].length;i++) {
            if(i == 0){
                for(int r = 0; r < s.length;r++) {
                    player[r] = s[i][r];
                }
            }else if(i == 1) {
                for(int r = 0; r < s.length;r++) {
                    enemy[r] = s[i][r];
                }
            }
        }
        GridBagConstraints name = new GridBagConstraints();
        setScoreFastAccessIndex(0, new JLabel(player[0]));
        name.fill = GridBagConstraints.HORIZONTAL;
        name.insets = new Insets(0,0,0,0);
        name.gridx = 0;
        name.gridy = 0;
        name.gridwidth = 2;
        scoreBoard.add(getScoreFastAccessIndex(0), name);
        GridBagConstraints shipNumber = new GridBagConstraints();
        setScoreFastAccessIndex(1, new JLabel(player[1]));
        shipNumber.fill = GridBagConstraints.HORIZONTAL;
        shipNumber.insets = new Insets(0,0,0,0);
        shipNumber.gridx = 0;
        shipNumber.gridy = 2;
        shipNumber.gridwidth = 1;
        scoreBoard.add(getScoreFastAccessIndex(1), shipNumber);
        GridBagConstraints hits = new GridBagConstraints();
        setScoreFastAccessIndex(2, new JLabel(player[0]));
        hits.fill = GridBagConstraints.HORIZONTAL;
        hits.insets = new Insets(0,0,0,0);
        hits.gridx = 0;
        hits.gridy = 3;
        hits.gridwidth = 1;
        scoreBoard.add(getScoreFastAccessIndex(2), hits);
        GridBagConstraints misses = new GridBagConstraints();
        setScoreFastAccessIndex(3, new JLabel(player[0]));
        misses.fill = GridBagConstraints.HORIZONTAL;
        misses.insets = new Insets(0,0,0,0);
        misses.gridx = 0;
        misses.gridy = 4;
        misses.gridwidth = 1;
        scoreBoard.add(getScoreFastAccessIndex(3), misses);
        GridBagConstraints score = new GridBagConstraints();
        setScoreFastAccessIndex(4, new JLabel(player[0]));
        score.fill = GridBagConstraints.HORIZONTAL;
        score.insets = new Insets(0,0,0,0);
        score.gridx = 0;
        score.gridy = 5;
        score.gridwidth = 1;
        scoreBoard.add(getScoreFastAccessIndex(4), score);
        GridBagConstraints nameE = new GridBagConstraints();
        setScoreFastAccessIndex(5, new JLabel(enemy[0]));
        name.fill = GridBagConstraints.HORIZONTAL;
        name.insets = new Insets(0,0,0,0);
        name.gridx = 1;
        name.gridy = 0;
        name.gridwidth = 2;
        scoreBoard.add(getScoreFastAccessIndex(5), name);
        GridBagConstraints shipNumberE = new GridBagConstraints();
        setScoreFastAccessIndex(6, new JLabel(enemy[1]));
        shipNumber.fill = GridBagConstraints.HORIZONTAL;
        shipNumber.insets = new Insets(0,0,0,0);
        shipNumber.gridx = 1;
        shipNumber.gridy = 2;
        shipNumber.gridwidth = 1;
        scoreBoard.add(getScoreFastAccessIndex(6), shipNumberE);
        GridBagConstraints hitsE = new GridBagConstraints();
        setScoreFastAccessIndex(7, new JLabel(enemy[2]));
        hits.fill = GridBagConstraints.HORIZONTAL;
        hits.insets = new Insets(0,0,0,0);
        hits.gridx = 1;
        hits.gridy = 3;
        hits.gridwidth = 1;
        scoreBoard.add(getScoreFastAccessIndex(7), hitsE);
        GridBagConstraints missesE = new GridBagConstraints();
        setScoreFastAccessIndex(8, new JLabel(enemy[3]));
        misses.fill = GridBagConstraints.HORIZONTAL;
        misses.insets = new Insets(0,0,0,0);
        misses.gridx = 1;
        misses.gridy = 4;
        misses.gridwidth = 1;
        scoreBoard.add(getScoreFastAccessIndex(8), missesE);
        GridBagConstraints scoreE = new GridBagConstraints();
        setScoreFastAccessIndex(9, new JLabel(enemy[4]));
        score.fill = GridBagConstraints.HORIZONTAL;
        score.insets = new Insets(0,0,0,0);
        score.gridx = 1;
        score.gridy = 5;
        score.gridwidth = 1;
        scoreBoard.add(getScoreFastAccessIndex(9), scoreE);
    }
    ///Protected Behavior
    void changeBattleGround(LinkedList<Tile> grid) {
        for(int i = 0; i < grid.size();i++) {
            getGridFastAccessIndex(i).setIcon(grid.get(i).getBackgroundImage());
        }
    }
    void changeFog(LinkedList<FogTile> fogTile) {
        for(int i = 0; i < fogTile.size();i++) {
            getFogFastAccessIndex(i).setIcon(fogTile.get(i).getBackgroundImage());
        }
    }
    void changeScore(String s[][]) {
        String[] player = new String[5];
        String[] enemy = new String[5];
        for(int i = 0; i < s[i].length;i++) {
            if(i == 0){
                for(int r = 0; r < s.length;r++) {
                    player[r] = s[i][r];
                }
            }else if(i == 1) {
                for(int r = 0; r < s.length;r++) {
                    enemy[r] = s[i][r];
                }
            }
        }
        for(int i = 0; i < getScoreFastAccess().length;i++) {
            if(i < 6) {
                getFogFastAccessIndex(i).setText(player[i]);
            }else getFogFastAccessIndex(i).setText(player[i]);
        }
    }
    void changeEnemyTileHitInFog(boolean isHit, int xPos, int yPos, LinkedList<FogTile> fogTiles) {
        Data images = new Data();
        images.setHit();
        images.setMiss();
        for(FogTile fogTile : fogTiles) {
            for(int i = 0; i < fogTiles.size(); i++) {
                if(fogTile.getXPos() == xPos && fogTile.getYPos() == yPos) {
                    if(isHit) {
                        fogTile.setBackgroundImage(images.getHit());
                    } else fogTile.setBackgroundImage(images.getMiss());
                }
            }
        }

    }
    String castBooleanToString(boolean castBoolean) {
        String tempString;
        if(castBoolean) {
            tempString = "Operational!";
        } else {
            tempString = "Sinking!";
        }
        return tempString;
    }
    ///Public Behavior
    class ShotAssessment implements ActionListener {
        //Attributes:
        ///Primitive
        ///Objects
        private JButton fire;
        private FogTile carry;
        ///Arrays
        private int[][][] enemyShipList;
        ///Collections
        //Constructor:
        ShotAssessment(FogTile carry, int[][][] enemyShipList) {
            ///Initially Used Setter
            setCarry(carry);
            setFire(getCarry().getButton());
            setEnemyShipList(enemyShipList);
            ///Initially Used Behavior
        }
        //Setter And Getter:
        ///Private Setter
        private void setCarry(FogTile carry) {
            this.carry = carry;
        }
        private void setEnemyShipList(int[][][] enemyShipList) {
            this.enemyShipList = enemyShipList;
        }
        private void setFire(JButton fire) {
            this.fire = fire;
        }
        ///Protected Setter
        ///Public Setter
        ///Private Getter
        ///Protected Getter
        JButton getFire() {
            return fire;
        }
        FogTile getCarry() {
            return carry;
        }
        int[][][] getEnemyShipList() {
            return enemyShipList;
        }
        ///Public Getter
        //Behavior:
        ///Private Behavior
        private boolean checkEnemyShipsForHit(int buttonXPos, int buttonYPos){
            for(int ships = 0; ships < getEnemyShipList()[ships].length; ships++) {
                for(int coord = 0; coord < getEnemyShipList().length; coord++) {
                    if(getEnemyShipList()[ships][0][coord] == buttonXPos && getEnemyShipList()[ships][1][coord] == buttonYPos) {
                        return true;
                    }
                }
            }
            return false;
        }
        ///Protected Behavior
        ///Public Behavior
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == getFire() && checkEnemyShipsForHit(getCarry().getXPos(), getCarry().getYPos())) {
                getFire().setIcon(getSizes().getHit());
                getFire().setEnabled(false);
                setShotX(getCarry().getXPos());
                setShotY(getCarry().getYPos());
                setHit(true);
                setDone(true);
            }else if(e.getSource() == getFire() && !checkEnemyShipsForHit(getCarry().getXPos(), getCarry().getYPos())) {
                getFire().setIcon(getSizes().getMiss());
                getFire().setEnabled(false);
                setShotX(getCarry().getXPos());
                setShotY(getCarry().getYPos());
                setHit(false);
                setDone(true);
            }
        }
    }
}