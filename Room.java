import java.util.ArrayList;
// Last updated Feb. 29 by Nicki.
public class Room{
  private int roomNumber;
  private Door aDoor = new Door();
  private ArrayList<Tile> tileList = new ArrayList<Tile>();

  //Constructor for Room class that takes an int
  public Room(int num){
    roomNumber = num;
  }
  // Get the room number for the room
  public int getRoomsNumber(){
    return roomNumber;
  }

  //Add a tile to the tile list
  public void addTile(int row, int col){
    tileList.add(new Tile(row,col));
  }

  //Set the door of the room
  public void setDoor(int row, int col){
    aDoor.setDoorX(row);
    aDoor.setDoorY(col);
  }

  //Get the door of the room
  public Door getDoor(){
    return aDoor;
  }

}
