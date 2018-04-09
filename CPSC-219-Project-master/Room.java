import java.util.ArrayList;
import java.io.Serializable;

/**
 * Class that handles everything related to the rooms of the grid map.
 * Last Edited by Dayan - 27 Mar 2018
 */
public class Room implements Serializable{
  private int roomNumber = 0;
  private Door aDoor = new Door();
  //no door in tileList
  private ArrayList<Tile> tileList = new ArrayList<Tile>();


  /**
   * Constructor for Room class that takes an int
   *
   * @param num the number of the room as type int
   */
  public Room(int num) {
    roomNumber = num;
  }

  /**
   * Copy constructor for Room class.
   *
   * @param roomToCopy the room to be copied.
   */
  public Room(Room toBeCopied) {
    roomNumber = toBeCopied.getRoomsNumber();
    aDoor = toBeCopied.getDoor();
    tileList = toBeCopied.getTileList();
  }

  /**
   * Method to get the room number for the room
   *
   * @return roomNumber the number of the room as an int
   */
  public int getRoomsNumber() {
    return roomNumber;
  }

  public ArrayList<Tile> getTileList() {
    ArrayList<Tile> newList = new ArrayList<Tile>();
    for (int i = 0; i < tileList.size(); i++) {
      newList.add(new Tile(tileList.get(i)));
    }
    return newList;
  }

  /**
   * Method to add a Tile to the tile list
   *
   * @param row the row the tile is on the grid as an int.
   * @param col the column the tile is on the grid as an int.
   */
  public void addTile(int row, int col) {
    tileList.add(new Tile(row, col));
  }


  /**
   * Method to set the door of the room on the grid
   *
   * @param row the row the door is in on the grid as an int.
   * @param col the column the door is in on the grid as an int.
   */
  public void setDoor(int row, int col) {
    aDoor.setDoorX(row);
    aDoor.setDoorY(col);
  }


  /**
   * Method to Get the door of the room
   *
   * @return aDoor the door of the room of type Door
   */
  public Door getDoor() {
    return new Door(aDoor);
  }

}
