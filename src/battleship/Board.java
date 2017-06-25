//Package Dependency
package battleship;

//Imports
//Class
class Board {
    //Attributes:
    ///Primitive
    private boolean playerOneLost, playerTwoLost;
    ///Objects
    private Player playerOne, playerTwo;
    private MobileObject startUpTransmission, networkingTransmission;
    ///Arrays
    ///Collections
    //Constructor:
    Board(Player playerOne, Player playerTwo) {
        ///Initially Used Setter
        setPlayerOne(playerOne);
        setPlayerTwo(playerTwo);
        setPlayerOneLost(false);
        setPlayerTwoLost(false);
        startUp();
        startingTurn();
        turn();
        ///Initially Used Behavior
    }
    //Setter And Getter:
    ///Private Setter
    private void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }
    private void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }
    void setStartUpTransmission() {
        String[] stats = new String[5];
        stats[0] = "Enemy";
        stats[1] = "n.a";
        stats[2] = "n.a";
        stats[3] = "n.a";
        stats[4] = "n.a";
        int[] shot = new int[2];
        shot[0] = -1;
        shot[1] = -1;
        this.startUpTransmission = new MobileObject(false, shot, stats);
    }
    ///Protected Setter
    void setNetworkingTransmission(MobileObject networkingTransmission) {
        this.networkingTransmission = networkingTransmission;
    }
    void setPlayerOneLost(boolean playerOneLost) {
        this.playerOneLost = playerOneLost;
    }

    void setPlayerTwoLost(boolean playerTwoLost) {
        this.playerTwoLost = playerTwoLost;
    }
    ///Public Setter
    ///Private Getter
    ///Protected Getter
    MobileObject getNetworkingTransmission() {
        return this.networkingTransmission;
    }
    Player getPlayerOne() {
        return playerOne;
    }
    Player getPlayerTwo() {
        return playerTwo;
    }
    public MobileObject getStartUpTransmission() {
        return startUpTransmission;
    }
    ///Public Getter
    //Behavior:
    ///Private Behavior
    void startUp() {
        setStartUpTransmission();
    }
    void transmissionPhaseOneTwo() {
        setNetworkingTransmission(getPlayerOne().getTransmission());
    }
    void transmissionPhaseTwoOne() {
        setNetworkingTransmission(getPlayerOne().getTransmission());
    }
    void startingTurn() {
        while(!getPlayerOne().getGuiObject().isDone()) {
            getPlayerOne().setTransmission(getStartUpTransmission());
            getPlayerOne().handleTransmission(getPlayerOne().getTransmission());
            getPlayerOne().setGui();
            getPlayerOne().getGuiObject().getScreen().setVisible(true);
        }
        getPlayerOne().determineStatistics(getPlayerOne().getLists().getFogTiles());
        getPlayerOne().getGuiObject().changeEnemyTileHitInFog(getPlayerOne().getGuiObject().isHit(), getPlayerOne().getGuiObject().getShotX(), getPlayerOne().getGuiObject().getShotY(), getPlayerOne().getLists().getFogTiles());
        getPlayerOne().getGuiObject().changeFog(getPlayerOne().getLists().getFogTiles());
        getPlayerOne().getGuiObject().getScreen().setVisible(false);
        getPlayerOne().setTransmissionNew();
        transmissionPhaseOneTwo();
        while(!getPlayerTwo().getGuiObject().isDone()) {
            getPlayerTwo().setTransmission(getStartUpTransmission());
            getPlayerTwo().handleTransmission(getPlayerTwo().getTransmission());
            getPlayerTwo().setGui();
            getPlayerTwo().getGuiObject().getScreen().setVisible(true);
        }
        getPlayerTwo().determineStatistics(getPlayerTwo().getLists().getFogTiles());
        getPlayerTwo().getGuiObject().changeEnemyTileHitInFog(getPlayerTwo().getGuiObject().isHit(), getPlayerTwo().getGuiObject().getShotX(), getPlayerTwo().getGuiObject().getShotY(), getPlayerTwo().getLists().getFogTiles());
        getPlayerTwo().getGuiObject().changeFog(getPlayerTwo().getLists().getFogTiles());
        getPlayerTwo().getGuiObject().getScreen().setVisible(false);
        getPlayerTwo().setTransmissionNew();
        transmissionPhaseTwoOne();
    }
    void turn() {
        while(!getPlayerOne().getGuiObject().isDone()) {
            getPlayerOne().setTransmission(getNetworkingTransmission());
            getPlayerOne().handleTransmission(getPlayerOne().getTransmission());
            getPlayerOne().getGuiObject().getScreen().setVisible(true);
        }
        getPlayerOne().determineStatistics(getPlayerOne().getLists().getFogTiles());
        getPlayerOne().getGuiObject().changeEnemyTileHitInFog(getPlayerOne().getGuiObject().isHit(), getPlayerOne().getGuiObject().getShotX(), getPlayerOne().getGuiObject().getShotY(), getPlayerOne().getLists().getFogTiles());
        getPlayerOne().getGuiObject().changeFog(getPlayerOne().getLists().getFogTiles());
        getPlayerOne().getGuiObject().changeScore(getPlayerOne().assembleScoreboardInput());
        getPlayerOne().getGuiObject().getScreen().setVisible(false);
        getPlayerOne().setTransmissionNew();
        if(getPlayerOne().getLists().checkLosingCondition()) {
            return ;
        }
        transmissionPhaseOneTwo();
        while(!getPlayerTwo().getGuiObject().isDone()) {
            getPlayerTwo().setTransmission(getNetworkingTransmission());
            getPlayerTwo().handleTransmission(getPlayerTwo().getTransmission());
            getPlayerTwo().getGuiObject().getScreen().setVisible(true);
        }
        getPlayerTwo().determineStatistics(getPlayerTwo().getLists().getFogTiles());
        getPlayerTwo().getGuiObject().changeEnemyTileHitInFog(getPlayerTwo().getGuiObject().isHit(), getPlayerTwo().getGuiObject().getShotX(), getPlayerTwo().getGuiObject().getShotY(), getPlayerTwo().getLists().getFogTiles());
        getPlayerTwo().getGuiObject().changeFog(getPlayerTwo().getLists().getFogTiles());
        getPlayerTwo().getGuiObject().changeScore(getPlayerOne().assembleScoreboardInput());
        getPlayerTwo().getGuiObject().getScreen().setVisible(false);
        getPlayerTwo().setTransmissionNew();
        if(getPlayerTwo().getLists().checkLosingCondition()) {
            return ;
        }
        transmissionPhaseTwoOne();
        turn();
    }
    ///Protected Behavior
    ///Public Behavior
}
