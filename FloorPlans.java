/** Last Edited by Nicki Feb 29
*/
import java.util.ArrayList;

public class FloorPlans {
  private int[][] tfdlOne =
  {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,1,1,1,1,1,1,9,9,9,9,1,1,0,0,0,0},
  {0,0,1,1,161,1,160,1,152,9,9,9,1,1,0,0,0,0},
  {0,0,1,1,9,9,9,9,0,0,0,0,1,1,0,0,0,0},
  {0,0,1,1,9,9,9,9,0,0,0,0,1,1,0,0,0,0},
  {0,0,1,1,9,9,9,9,9,9,1,1,1,1,0,0,0,0},
  {0,0,1,1,9,9,9,9,9,9,1,1,1,1,0,0,0,0},
  {0,0,1,1,162,1,163,1,164,1,1,1,1,1,1,151,9,9,0},
  {0,0,1,1,1,159,1,1,1,1,1,1,1,1,9,9,9,0},
  {0,0,1,1,9,9,9,9,9,9,1,1,1,1,150,9,9,0},
  {0,0,1,1,9,9,9,9,9,9,1,1,1,1,9,9,9,0},
  {0,0,1,1,1,1,1,1,1,1,1,1,1,1,25,9,0,0},
  {0,0,1,1,1,1,1,1,1,1,1,1,1,1,9,9,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

  private int[][] tfdlTwo =
  {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,1,1,1,1,1,1,9,9,9,9,1,1,0,0,0,0},
  {0,0,1,1,261,1,260,1,252,9,9,9,1,1,0,0,0,0},
  {0,0,1,1,9,9,9,9,0,0,0,0,1,1,0,0,0,0},
  {0,0,1,1,9,9,9,9,0,0,0,0,1,1,0,0,0,0},
  {0,0,1,1,9,9,9,9,9,9,1,1,1,1,0,0,0,0},
  {0,0,1,1,9,262,9,263,9,264,1,1,1,1,0,0,0,0},
  {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1251,251,251,0},
  {0,0,1,1,1,1,1,1,1,1,1,1,1,1,9,9,9,0},
  {0,0,1,1,9,259,9,9,9,9,1,1,1,1,250,9,9,0},
  {0,0,1,1,9,9,9,9,9,9,1,1,1,1,9,9,9,0},
  {0,0,1,1,1,1,1,1,1,1,1,1,1,1,25,9,0,0},
  {0,0,1,1,1,1,1,1,1,1,1,1,1,1,9,9,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

  private int[][] grid =
  {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
  //private int row;
  //private int column;
  private int destNum;
  private String building;
  private ArrayList<Room> roomList = new ArrayList<Room>();


  // default constructor
  public FloorPlans(){}

  // copy constructor for FloorPlans
  public FloorPlans(FloorPlans fPToBeCopied){
    destNum = fPToBeCopied.getDestNumber();
    building = fPToBeCopied.getBuildingName();
    for (int row = 0; row <3; row++){
      for(int column = 0; column <3; column++){
        grid[row][column] = fPToBeCopied.grid[row][column];
      }
    }
  }

  // constructor with rooms & doors
  public FloorPlans(String theBuilding, int theDestNum){
    building = theBuilding;
    destNum = theDestNum;
    setGrid(theBuilding,theDestNum);
    makeRooms();
    populateRooms();
  }

  /*// constructor with a building and room number
  public FloorPlans(String aBuilding, int theDestNum){
    building = aBuilding;
    destNum = theDestNum;
    setGrid(aBuilding,theDestNum);
  }*/

  // getter for destinaton number
  public int getDestNumber(){
    return destNum;
  }
  // getter for building name
  public String getBuildingName(){
    return building;
  }
  // calculate the floor the destination room is on
  public int getFloorNum(int newRoomNumber) {
    int floorNum;
    int numDigits;
    numDigits = (int) Math.log10(newRoomNumber) + 1;
    if (numDigits < 3) {
      floorNum = 0;
    }
    // get floor number from first digit of room number
    else {
      floorNum = newRoomNumber;
      while (floorNum > 9) {
        floorNum /= 10;
      }
    }
    return floorNum;
  }

  // get the current grid
  public int[][] getGrid(){
    return grid;
  }

  /*
  * Method to set the appropriate grid
  *
  * NUMBERS       CORRESPONDING ROOM
  *    0          Wall
  *    1          Hallway - only thing path can move through
  *    9          Portions of rooms, WILL NEED TO CHANGE THIS
  *    25         Stairs that can be used later
  *   >= 100        Room Numbers, represent doors
  */

  public void setGrid(String building, int roomNum) {
    int floor = getFloorNum(roomNum);
    if (building == "Taylor Family Digital Library") {
      if (floor == 1) {
        grid = tfdlOne;
      } else if (floor == 2) {
        grid = tfdlTwo;
      }
    }
  }
  // get room method
  public Room getRoom(int gridNum){
    Room room = null;
    for(int i = 0; i <roomList.size();i++){
      if (roomList.get(i).getRoomsNumber() == gridNum){
        room = roomList.get(i);
      }
    }
    return room;
  }

  // add a room to the roomlist in the floorplan
  public void addRoom(int gridNum){
    // if number is not in roomlist... **
    roomList.add(new Room(gridNum));
  }
  // make a room for each corresponding room on a grid
  // meant to be used in a for-loop
  public void makeRooms(){
    int gridNum;
    for (int row = 0; row<14; row++ ){
      for(int col = 0; col<18; col++){
        gridNum = grid[row][col];
        if(gridNum>9 && gridNum!=25 & gridNum<1000){
          if (getRoom(gridNum)== null){
            addRoom(gridNum);
          }
        }
      }
    }
  }

  // populate each room within the floorplan with tiles and a door
  // meant to be used in a for-loop
  public void populateRooms(){
    int gridNum;
    for (int row = 0; row<14;row++){
      for (int col =0; col<18; col++){
        gridNum = grid[row][col];
        if (getRoom(gridNum) != null){
          getRoom(gridNum).addTile(row,col);
        }
        if(gridNum > 1000){
            // get the room for a door (1000+ item) and subtract 1000 to find
            // which room it is for. Set the door as the current tile in the loop.
            Room tempRoom = getRoom(gridNum-1000);
            tempRoom.setDoor(row,col);
        }

      }
    }
  }

}
