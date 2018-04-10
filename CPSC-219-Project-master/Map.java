/**
* Class for the creations of the maps, sizing of the maps, and contains the path restriction for the pathfinding.
*/
import java.io.Serializable;
import resources.Constants;
public class Map implements Serializable{

  private int roomNum;
  private String building;
  private FloorPlans currentFloorPlan = new FloorPlans();
  private Building currentBuilding;
  private int startX;
  private int startY;
  private int endX;
  private int endY;

  /**
  * Constructor with a provided FloorPlans.
  * @param: newFloorPlan a floorplan of type FloorPlans.
  */
  public Map (FloorPlans newFloorPlan){
    currentFloorPlan = newFloorPlan;
  }

  /**
  * Constructor with a provided room number that generates a new floorplan.
  * @param: newRoomNumber a room number of interest as an int.
  */
  public Map (int newRoomNumber) {
    roomNum = newRoomNumber;
    FloorPlans floorPlan = new FloorPlans();
  }

  /**
  * Default constructor for Map
  */
  public Map(){};

  /**
  * Method that sets the current floorplan.
  * @param: newFloorPlan the currently being used floorplan as type FloorPlans.
  */
  public void setCurrentFloorPlan(FloorPlans newFloorPlan){
    currentFloorPlan = newFloorPlan;
  }

  public Building getCurrentBuilding(){
    return new Building(currentBuilding);
  }

  public void setCurrentBuilding(Building newBuilding){
    currentBuilding = new Building(newBuilding);
  }

  /**
  * Method that gets the current floorplan.
  * @return: currentFloorPlan the current floorplan as type FloorPlans.
  */
  public FloorPlans getCurrentFloorPlan(){
    return currentFloorPlan;
  }

  /**
  * Printing method for the floorplan as a 2-dimensional grid.
  */
  public void printGrid() {
    for (int row = 0; row < currentFloorPlan.getRowLength(); row++) {
      for (int column = 0; column <currentFloorPlan.getColLength(row); column++) {
        System.out.printf("%4d", currentFloorPlan.getGrid()[row][column]);
      }
      System.out.println();
    }
  }

  /**
  * Method that sets the coordinate values startX and startY for the starting room.
  * @param: aFP a floorPlan; startRoom the current start Room.
  */
  public void setStartValues(FloorPlans aFP,int startRoom){
    int row;
    int col;
    for(row=0;row<aFP.getRowLength();row++){
      for(col=0;col<aFP.getColLength(row);col++){
        if(aFP.getGrid()[row][col]==startRoom){
          startX = row;
          startY = col;
        }
      }
    }
  }

  /**
  * Method that sets the coordinate values endX and endY for the end/destination room.
  * @param: aFP a floorPlan; endRoom the current end Room.
  */
  public void setEndValues(FloorPlans aFP, int endRoom){
    int row;
    int col;
    for(row=0;row<aFP.getRowLength();row++){
      for(col=0;col<aFP.getColLength(row);col++){
        if(aFP.getGrid()[row][col]==endRoom){
          endX = row;
          endY = col;
        }
      }
    }
  }

  /**
  * Method to place start marker at the starting room on the grid.
  * @param: aGrid a chosen int[][] grid.
  *
  */
  public void placeStart(int[][] aGrid){
    aGrid[startX][startY]=Constants.START;
  }

  /**
  * Method to place the Destination marker on the destination room.
  * @param: aGrid a chosen int[][] grid.
  */
  public void placeDest(int[][] aGrid){
    aGrid[endX][endY] = Constants.DEST;
  }

  /**
  * Getter method to get the associated number for each point in the grid.
  * @param: row the row of the point as an int. column the column of the point as an int.
  * @return: gridPointVal the value off the grid for the point as an int.
  */
  public int getGridPointNum(int row, int column) {
    int gridPointVal;
    gridPointVal = currentFloorPlan.getGrid()[row][column];
    return gridPointVal;
  }

}
