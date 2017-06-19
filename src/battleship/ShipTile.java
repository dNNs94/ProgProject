package battleship;

class ShipTile extends Tile {

    private boolean hit;
    
    ShipTile(int xPos, int yPos) {
        super(xPos, yPos);
        setHit(false);
    }
    void setHit(boolean hit) {
        this.hit = hit;
    }
    boolean isHit() {
        return this.hit;
    }
}
