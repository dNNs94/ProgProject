class FogTile extends Tile {

    private boolean fired, hit, miss;
    
    private Data image;
    
    FogTile(int xPos, int yPos) {
        super(xPos, yPos);
        setImage();
        setBackgroundImage(getImage().getFog());
        setFired(false);
        setHit(false);
        setMiss(false);
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
}
