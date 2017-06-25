package battleship;

import javax.swing.*;

class FogTile extends Tile {
    //Attributes:
    ///Primitive
    private boolean fired, hit, miss;
    ///Objects
    private Data image;
    private JButton tileJButton;
    ///Arrays
    ///Collections
    //Constructor:
    FogTile(int xPos, int yPos) {
        ///Initially Used Setter
        super(xPos, yPos);
        setImage();
        setBackgroundImage(getImage().getFog());
        setFired(false);
        setHit(false);
        setMiss(false);
        ///Initially Used Behavior
    }
    //Setter And Getter:
    ///Private Setter
    ///Protected Setter
    void setButton(JButton button) {
        this.tileJButton = button;
    }
    void setImage() {
        this.image = new Data();
        getImage().setFog();
    }
    void setFired(boolean fired) {
        this.fired = fired;
    }
    void setHit(boolean hit) {
        this.hit = hit;
    }
    void setMiss(boolean miss) {
        this.miss = miss;
    }
    ///Public Setter
    ///Private Getter
    ///Protected Getter
    JButton getButton() {
      return this.tileJButton;
    }
    Data getImage() {
        return image;
    }
    boolean isFired() {
        return fired;
    }
    boolean isHit() {
        return hit;
    }
    boolean isMiss() {
        return miss;
    }
    ///Public Getter
    //Behavior:
    ///Private Behavior
    ///Protected Behavior
    ///Public Behavior
}
