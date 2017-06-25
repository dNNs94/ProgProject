package battleship;

import javax.swing.*;
import java.util.LinkedList;
import java.util.ListIterator;

import static java.util.Collections.swap;

class ListAccumulator<Human extends Ships, Board extends Player, Vessel extends ShipTile, Ocean extends OceanTile, Fog extends FogTile, Grid extends Tile> {
    //Attributes:
    ///Primitive
    ///Objects
    ///Arrays
    ///Collections
    private LinkedList<Human> ships;
    private LinkedList<Board> scoreBoard;
    private LinkedList<Vessel> vesselTiles;
    private LinkedList<Ocean> oceanTiles;
    private LinkedList<Fog> fogTiles;
    private LinkedList<Grid> gridList;
    private LinkedList<String> listsNames;
    private int[][][] enemyShipList;
    private Player[] players;
    //Constructor:
    ListAccumulator() {
        ///Initially Used Setter
        ///Initially Used Behavior
    }
    //Setter And Getter:
    ///Private Setter
    ///Protected Setter
    void setScoreBoard(LinkedList<Board> scoreBoard) {
      this.scoreBoard = scoreBoard;
    }
    void setScoreBoardNew() {
        this.scoreBoard = new LinkedList<Board>();
    }
    void setScoreBoardIndex(int index, Board element) {
      getScoreBoard().set(index, element);
    }
    void setScoreBoardAddElement(Board element) {
        getScoreBoard().add(element);
    }
    void setGridList(LinkedList<Grid> gridList) {
        this.gridList = gridList;
    }
    void setGridListNew() {
        this.gridList = new LinkedList<Grid>();
    }
    void setGridListIndex(int index, Grid element) {
        getGridList().set(index, element);
    }
    void setGridListAddElement(Grid element) {
        getGridList().add(element);
    }
    void setOceanListNew() {
        this.oceanTiles = new LinkedList<Ocean>();
    }
    void setOceanListIndex(int index, Ocean tile) {
        getOceanTiles().set(index, tile);
    }
    void setOceanList(LinkedList<Ocean> oceanList) {
        this.oceanTiles = oceanList;
    }
    void setOceanTilesAddElement(int index, Ocean element) {
        getOceanTiles().set(index, element);
    }
    void setFogTiles(LinkedList<Fog> fogTiles) { this.fogTiles = fogTiles; }
    void setFogTilesNew() {
        this.fogTiles = new LinkedList<Fog>();
    }
    void setFogTilesIndex(int index, Fog element) {
        getFogTiles().set(index, element);
    }
    void setFogTilesAddELement() {
        this.fogTiles = new LinkedList<Fog>();
    }
    void setShips(LinkedList<Human> ships) {
        this.ships = ships;
    }
    void setShipsNew() {
        this.ships = new LinkedList<Human>();
    }
    void setShipsIndex(int index, Human element) {
        getShips().set(index, element);
    }
    void setShipsAddElement(Human element) {
        getShips().add(element);
    }
    void setVesselTiles(LinkedList<Vessel> vesselTiles) {
        this.vesselTiles = vesselTiles;
    }
    void setVesselTilesNew() {
        this.vesselTiles = new LinkedList<Vessel>();
    }
    void setVesselTilesIndex(int index, Vessel element) {
        getVesselTiles().set(index, element);
    }
    void setVesselTilesImage(int index, ImageIcon image) {
        getVesselTiles(index).setBackgroundImage(image);
    }
    void setVesselTilesAddElement(Vessel element) {
        getVesselTiles().add(element);
    }
    void setShipNames() {
        this.listsNames = new LinkedList<String>();
        getListsNames().add("Arktika"); getListsNames().add("Sibir"); getListsNames().add("Rossiya"); getListsNames().add("Sovetskiy Soyuz"); getListsNames().add("Yamal");
        getListsNames().add("HMS Endurance"); getListsNames().add("HMS Hydra"); getListsNames().add("HMS Beagle"); getListsNames().add("HMS Egeria"); getListsNames().add("HMS Gleaner");
        getListsNames().add("Vineland"); getListsNames().add("Elk Island"); getListsNames().add("Shinai"); getListsNames().add("Lady Hawkins"); getListsNames().add("Canadolite");
        getListsNames().add("USS Dwight D. Eisenhower"); getListsNames().add("USS George Washington"); getListsNames().add("USS Harry S. Truman"); getListsNames().add("USS Paul Hamilton"); getListsNames().add("USS Roosevelt");
    }
    void setEnemyShipList(int[][][] enemyShipList) {
        this.enemyShipList = enemyShipList;
    }
    void setPlayers(Player[] players) {
        this.players = players;
    }
    void setPlayerNew(){};
    void setPlayersIndex(int index, Player players) {
        this.players[index] = players;
    }
    ///Public Setter
    ///Private Getter
    ///Protected Getter
    LinkedList<Board> getScoreBoard() {
        return scoreBoard;
    }
    LinkedList<Grid> getGridList() {
        return gridList;
    }
    LinkedList<Ocean> getOceanTiles() {
        return oceanTiles;
    }
    LinkedList<Fog> getFogTiles() {
        return fogTiles;
    }
    LinkedList<Human> getShips() {
        return ships;
    }
    LinkedList<Vessel> getVesselTiles() {
        return vesselTiles;
    }
    Vessel getVesselTiles(int index) {
        return getVesselTiles().get(index);
    }
    LinkedList<String> getListsNames() {
        return listsNames;
    }
    int[][][] getEnemyShipList() {
        return enemyShipList;
    }
    ///Public Getter
    //Behavior:
    ///Private Behavior
    ///Protected Behavior
    void sortGridList() {
        boolean done = false;
        int jumps = 0;
        ListIterator<Grid> listIterator = getGridList().listIterator();
        while(!done) {
            for(Tile tile: getGridList()) {
                if(listIterator.hasNext() && tile.compareTo(listIterator.next()) < 0) {
                    swap(getGridList(), getGridList().indexOf(tile), listIterator.nextIndex());
                } else if(listIterator.hasNext() && tile.compareTo(listIterator.next()) > 0) {
                    jumps = jumps + 1;
                } else if(listIterator.hasNext() && tile.compareTo(listIterator.next()) == 0) {
                    jumps = jumps + 1;
                } else if(!listIterator.hasNext()) {
                    if(jumps == getGridList().size() - 1) {
                        done = true;
                    }
                }
            }
        }
    }
    void sortShipList() {
        boolean done = false;
        int jumps = 0;
        ListIterator<Human> listIterator = getShips().listIterator();
        while(!done) {
            for(Ships ship: getShips()) {
                if(listIterator.hasNext() && ship.compareTo(listIterator.next()) < 0) {
                    swap(getShips(), getShips().indexOf(ship), listIterator.nextIndex());
                } else if(listIterator.hasNext() && ship.compareTo(listIterator.next()) > 0) {
                    jumps = jumps + 1;
                } else if(listIterator.hasNext() && ship.compareTo(listIterator.next()) == 0) {
                    jumps = jumps + 1;
                } else if(!listIterator.hasNext()) {
                    if(jumps == getShips().size() - 1) {
                        done = true;
                    }
                }
            }
        }
    }
    void sortScoreBoard() {
        boolean done = false;
        int jumps = 0;
        ListIterator<Grid> listIterator = getGridList().listIterator();
        while(!done) {
            for(Tile tile: getGridList()) {
                if(listIterator.hasNext() && tile.compareTo(listIterator.next()) < 0) {
                    swap(getGridList(), getGridList().indexOf(tile), listIterator.nextIndex());
                } else if(listIterator.hasNext() && tile.compareTo(listIterator.next()) > 0) {
                    jumps = jumps + 1;
                } else if(listIterator.hasNext() && tile.compareTo(listIterator.next()) == 0) {
                    jumps = jumps + 1;
                } else if(!listIterator.hasNext()) {
                    if(jumps == getGridList().size() - 1) {
                        done = true;
                    }
                }
            }
        }
    }
    void changeTileHitByEnemy(boolean isHit, int xPos, int yPos) {
        Data images = new Data();
        images.setHit();
        images.setMiss();
        for(Grid gridTile : getGridList()) {
            for(int i = 0; i < getGridList().size(); i++) {
                if(gridTile.getXPos() == xPos && gridTile.getYPos() == yPos) {
                    if(isHit) {
                        gridTile.setBackgroundImage(images.getHit());
                    } else gridTile.setBackgroundImage(images.getMiss());
                }
            }
        }
    }
    int checkShipForHits(LinkedList<ShipTile> ship) {
        int numberOfHits = 0;
        for(ShipTile a: ship) {
            if(a.isHit()) {
                numberOfHits++;
            }
        }
        return numberOfHits;
    }
    boolean checkLosingCondition() {
        boolean losing = false;
        int tempRunning = 0;
        for(Human ship : getShips()) {
            if(ship.isRunning()) {
                tempRunning++;
            }
        }
        if(tempRunning == 0) {
            losing = true;
        } else if (tempRunning > 0) {
            losing = false;
        }
        return losing;
    }
    void provideCoordinatesToTiles(int[][] coordinates) {
        int index = 0;
        for(Vessel a: getVesselTiles()) {
            if(coordinates[0][index] > 0 && coordinates[1][index] > 0) {
                a.setXPos(coordinates[0][index]);
                a.setYPos(coordinates[1][index]);
                index++;
            }
        }
    }
    void assembleShipTileCoordinates(boolean horizontal, int numberOfTiles, Data images) {
        if(horizontal) {
            for (int i = 0; i < numberOfTiles; i++) {
                setVesselTilesIndex(i, (Vessel) new ShipTile(0, 0));
                if (i == 0) {
                    setVesselTilesImage(i, images.getShipEndLeft());
                } else if (i < numberOfTiles - 1) {
                    setVesselTilesImage(i, images.getShipHullLeftRight());
                } else if (i == numberOfTiles - 1) {
                    setVesselTilesImage(i, images.getShipEndRight());
                }
            }
        } else {
            for (int i = 0; i < numberOfTiles; i++) {
                setVesselTilesIndex(i, (Vessel) new ShipTile(0, 0));
                if (i == 0) {
                    setVesselTilesImage(i, images.getShipEndTop());
                } else if (i < numberOfTiles - 1) {
                    setVesselTilesImage(i, images.getShipHullTopBottom());
                } else if (i == numberOfTiles - 1) {
                    setVesselTilesImage(i, images.getShipEndBottom());
                }
            }
        }
    }
    void assembleShips(int[][][] playerCoords) {
        for(int s = 0; s < playerCoords[s].length; s++) {
            if(s <= 2) {
                setShipsAddElement((Human) new Corvette(playerCoords[s]));
            }
            if(s > 2 && s <= 4) {
                setShipsAddElement((Human) new Frigate(playerCoords[s]));
            }
            if(s > 4 && s <= 6) {
                setShipsAddElement((Human) new Destroyer(playerCoords[s]));
            }
            if(s > 6 && s <= 8) {
                setShipsAddElement((Human) new Cruiser(playerCoords[s]));
            }
        }
    }
    void fillOceanTiles() {
        for (int i = 0; i < 100; i++) {
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 10; y++) {
                    setOceanTilesAddElement(i, (Ocean) new OceanTile(x, y));
                }
            }
        }
    }
    void determineOceanTiles() {
        for(Human ship: getShips()) {
            for(Ocean ocean : getOceanTiles()) {
                for(int i = 0; i < ship.getLists().getVesselTiles().size(); i++) {
                    if(ship.getLists().getVesselTiles(i).getXPos() == ocean.getXPos() &&
                       ship.getLists().getVesselTiles(i).getYPos() == ocean.getYPos()) {
                        getOceanTiles().remove(ocean);
                    }
                }
            }
        }
    }
    void assembleOceanTiles() {
        fillOceanTiles();
        determineOceanTiles();
    }
    void assembleFogList() {
        for (int i = 0; i < 100; i++) {
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 10; y++) {
                    setFogTilesIndex(i, (Fog) new FogTile(x, y));
                }
            }
        }
    }
    void assembleGridList() {
        setGridListNew();
        for(Human ship: getShips()) {
            for(Vessel tile : getVesselTiles()) {
                setGridListAddElement((Grid) tile);
            }
        }
        for(Ocean tile : getOceanTiles()) {
            setGridListAddElement((Grid) tile);
        }
        sortGridList();
    }
    void setPlayerLists(int[][][] shipCoords) {
        setEnemyShipList(shipCoords);
        setShipsNew();
        setOceanListNew();
        setGridListNew();
        setFogTilesNew();
        setScoreBoardNew();
    }
    void assemblePlayerLists() {
        assembleShips(getEnemyShipList());
        assembleOceanTiles();
        assembleFogList();
        assembleGridList();
    }
    ///Public Behavior
}
