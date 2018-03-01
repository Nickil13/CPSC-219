/**Class for the creations of the maps, sizing of the maps, and contains the path restriction for the pathfinding.
*Last Edited by Nicki Feb 28*/

public class Map{
  // Instance variables
  private int roomNum;
  //Defaults at TFDL
  private String building = "Taylor Family Digital Library"; //This is probably fine as a string
  //private String endBuilding = "Taylor Family Digital Library";

  private boolean avoidStairs;
  private boolean avoidElevator;
  private FloorPlans currentFloorPlan = new FloorPlans();
  private int avoidRoomNum;
  /*
  * Removed Row and Column, they should not be instances rather variables
  * within the methods below
  */


  // Constructors
  public Map (FloorPlans newFloorPlan){
    currentFloorPlan = newFloorPlan;
  }
  public Map (int newRoomNumber) {
    roomNum = newRoomNumber;
    FloorPlans floorPlan = new FloorPlans();
    //floorPlan.setGrid(building, roomNum);
    //floorGrid = floorPlan.getGrid();
  }

  public Map(){};

  public void setCurrentFloorPlan(FloorPlans newFloorPlan){
    currentFloorPlan = newFloorPlan;
  }
  public FloorPlans getCurrentFloorPlan(){
    return currentFloorPlan;
  }
  /*
  * Printing method for the Grid
  */

  public void printGrid() {
    for (int row = 0; row < 14; row++) {
      for (int column = 0; column <18; column++) {
        System.out.printf("%4d", currentFloorPlan.getGrid()[row][column]);
      }
      System.out.println();
    }
  }

  // place start marker
  public void placeStart(int startRow, int startCol){
    currentFloorPlan.getGrid()[startRow][startCol]=8;
  }

  // place Destination marker
  public void placeDest(int endRow, int endCol){
    currentFloorPlan.getGrid()[endRow][endCol] = 5;
  }

  /*
  * get the room number for each point in the grid
  */
  public int getGridPointNum(int row, int column) {
    int gridPointVal;
    gridPointVal = currentFloorPlan.getGrid()[row][column];
    return gridPointVal;
  }

}
