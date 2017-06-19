package battleship;

abstract class Ships implements Comparable<Ships> {
    private boolean running, horizontal;
    private String name, shipClass;
    private int numberOfTiles, numberOfHitsTaken;
    private ListAccumulator Lists;
    private Data images;
    Ships(int numberOfTiles, int[][] coordinates) {
        setLists();
        setData();
        setNumberOfTiles(numberOfTiles);
        setTiles(coordinates);
    }
    void setNumberOfTiles(int number) {
        this.numberOfTiles = number;
    }
    void setTiles(int[][] coordinates) {
        getLists().setVesselTilesNew();
        determineHorizontal(coordinates);
        getLists().assembleShipTileCoordinates(isHorizontal(), getNumberOfTiles(), getImages());
        getLists().provideCoordinatesToTiles(coordinates);
    }
    void setData() {
        this.images = new Data();
        getImages().loadImages();
    }
    void setLists() {
        this.Lists = new ListAccumulator();
    }
    void setRunning(boolean running) {
        this.running = running;
    }
    void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }
    void setNumberOfHitsTaken() {
        this.numberOfHitsTaken = getLists().checkShipForHits(getLists().getVesselTiles());
    }
    void setName() {
        getLists().setShipNames();
        int random = (int) ((Math.random() * getLists().getVesselTiles().size() + 0));
        this.name = (String) getLists().getListsNames().get(random);
    }
    void setShipClass(String shipClass) {
        this.shipClass = shipClass;
    }
    Data getImages() {
        return this.images;
    }
    String getName() {
        return this.name;
    }
    String getShipClass() {
        return this.shipClass;
    }
    ListAccumulator getLists() {
        return this.Lists;
    }
    boolean isRunning() {
        return this.running;
    }
    boolean isHorizontal() { return this.running; }
    int getNumberOfHitsTaken() {
        return this.numberOfHitsTaken;
    }
    int getNumberOfTiles() { return this.numberOfTiles; }
    void determineHorizontal(int[][] coordinates) {
        int tempIntegerHorizontal = 0;
        int tempIntegerVertical = 0;
        for(int i = 0; i <= coordinates[0].length; i++){
            tempIntegerHorizontal = tempIntegerHorizontal + coordinates[0][i];
        }
        tempIntegerHorizontal = tempIntegerHorizontal / coordinates[0].length;
        for(int i = 0; i <= coordinates[1].length; i++){
            tempIntegerHorizontal = tempIntegerHorizontal + coordinates[1][i];
        }
        tempIntegerVertical = tempIntegerVertical / coordinates[1].length;
        if(tempIntegerHorizontal == coordinates[0][1]) {
            setHorizontal(true);
        } else if (tempIntegerVertical == coordinates[1][1]) {
            setHorizontal(false);
        }
    }
    @Override
    public int compareTo(Ships ship) {
        if(getNumberOfHitsTaken() < ship.getNumberOfHitsTaken()){
            return -1;
        }else if(getNumberOfHitsTaken() > ship.getNumberOfHitsTaken()) {
            return 1;
        }
        return 0;
    }
}
