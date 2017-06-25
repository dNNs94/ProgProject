package battleship;

class ShipTile extends Tile {
    //Attributes:
    ///Primitive
    private boolean hit;
    ///Objects
    ///Arrays
    ///Collections
    //Constructor:
    ShipTile(int xPos, int yPos) {
        ///Initially Used Setter
        super(xPos, yPos);
        setHit(false);
        ///Initially Used Behavior
    }
    //Setter And Getter:
    ///Private Setter
    ///Protected Setter
    void setHit(boolean hit) {
        this.hit = hit;
    }
    ///Public Setter
    ///Private Getter
    ///Protected Getter
    boolean isHit() {
        return this.hit;
    }
    ///Public Getter
    //Behavior:
    ///Private Behavior
    ///Protected Behavior
    ///Public Behavior
}
