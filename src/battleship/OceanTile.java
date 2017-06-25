//Package Dependency
package battleship;
//Imports
//Class
class OceanTile extends Tile {
    //Attributes:
    ///Primitive
    ///Objects
    private Data image;
    ///Arrays
    ///Collections
    //Constructor:
    OceanTile(int xPos, int yPos) {
        ///Initially Used Setter
        super(xPos, yPos);
        setImage();
        setBackgroundImage(getImage().getOcean());
        ///Initially Used Behavior
    }
    //Setter And Getter:
    void setImage() {
        this.image = new Data();
        getImage().setOcean();
    }
    ///Private Setter
    ///Protected Setter
    ///Public Setter
    ///Private Getter
    ///Protected Getter
    Data getImage() {
        return this.image;
    }
    ///Public Getter
    //Behavior:
    ///Private Behavior
    ///Protected Behavior
    ///Public Behavior
}
