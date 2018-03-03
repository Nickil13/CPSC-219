/** Last Edited by Riley S
*2 March 2018 20:30
*/

public class FloorPlans {
  // 700s related to elevators.
  private int[][] tfdlOne =
  {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
  {0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1,1,0},
  {0,1,1,1,1,1,1,1,1,1,153,9,0,0,0,1,1,0},
  {0,1,1,1,1,1,1,1,1,1,9,9,0,0,1,1,1,0},
  {0,1,1,1,1,1,1,1,1,1,152,9,0,0,1,1,155,888},
  {0,1,1,1,1,1,1,1,1,1,9,9,0,0,1,1,154,888},
  {0,1,1,1,1,1,1,1,1,1,150,9,0,0,1,1,25,777},
  {0,1,1,9,9,1,1,1,1,1,1,0,0,1,1,1,0,0},
  {0,1,1,9,9,1,1,1,1,1,1,1,1,1,1,1,0,0},
  {0,1,1,151,9,1,1,1,1,1,1,1,1,1,1,1,700,0},
  {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,701,0},
  {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,702,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

  private int[][] tfdlTwo =
  {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,1,1,1,1,1,1,9,9,9,9,1,1,0,0,0,0},
  {0,0,1,1,261,1,260,1,252,9,9,9,1,1,0,0,0,0},
  {0,0,1,1,9,9,9,9,0,0,0,0,1,1,0,0,0,0},
  {0,0,1,1,9,9,9,9,0,0,0,0,1,1,0,0,0,0},
  {0,0,1,1,9,9,9,9,9,9,1,1,1,1,0,0,0,0},
  {0,0,1,1,9,262,9,263,9,264,1,1,1,1,0,0,0,0},
  {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,251,888,9,0},
  {0,0,1,1,1,1,1,1,1,1,1,1,1,1,9,9,9,0},
  {0,0,1,1,9,259,9,9,9,9,1,1,1,1,250,888,9,0},
  {0,0,1,1,9,9,9,9,9,9,1,1,1,1,9,9,9,0},
  {0,0,1,1,1,1,1,1,1,1,1,1,1,1,25,777,0,0},
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

  // constructor with a building and room number
  public FloorPlans(String aBuilding, int theDestNum){
    building = aBuilding;
    destNum = theDestNum;
    setGrid(aBuilding,theDestNum);
  }
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
    if (building.equals("Taylor Family Digital Library")) {
      if (floor == 1) {
        grid = tfdlOne;
      } else if (floor == 2) {
        grid = tfdlTwo;
      }
    }
  }


  }
