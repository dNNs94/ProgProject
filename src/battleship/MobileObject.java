//Package Dependency
package battleship;
//Imports
//Class
class MobileObject {
    //Attributes:
    ///Primitive
    ///Objects
    ///Arrays
    private boolean hit;
    private int[] playerShot;
    private String[] playerStats;
    ///Collections
    //Constructor:
    MobileObject(boolean hit,int[] playerShot,String[] playerStats) {
        ///Initially Used Setter
        setHit(hit);
        setPlayerShot(playerShot);
        setPlayerStats(playerStats);
        ///Initially Used Behavior
    }
    //Setter And Getter:
    ///Private Setter
    private void setHit(boolean hit) {
        this.hit = hit;
    }
    private void setPlayerShot(int[] playerShot) {
        this.playerShot = playerShot;
    }
    private int[] getPlayerShot() {
        return playerShot;
    }
    private void setPlayerStats(String[] playerStats) {
        this.playerStats = playerStats;
    }
    ///Protected Setter
    ///Public Setter
    ///Private Getter
    ///Protected Getter
    boolean isHit() {
        return hit;
    }
    int getPlayerShotX() {
        return getPlayerShot()[0];
    }
    int getPlayerShotY() {
        return getPlayerShot()[1];
    }
    String[] getPlayerStats() {
        return playerStats;
    }
    ///Public Getter
    //Behavior:
    ///Private Behavior
    ///Protected Behavior
    ///Public Behavior
}