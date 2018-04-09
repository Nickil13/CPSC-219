/**
 * This Class to run the room finder application on the console as a text-version.
 */

import java.util.Scanner;

public class MapMain {
  private int roomStart;
  private int roomDest;


  /**
   * Default constructor for MapMain
   */
  public MapMain() {
  }

  ;

  /**
   * Method to get starting room from user keyboard input
   *
   * @return roomStart the starting room number as an int
   */
  public int getStartRoom() {
    System.out.println("Enter the room number nearest to you: ");
    Scanner keyboard = new Scanner(System.in);
    roomStart = keyboard.nextInt();
    return roomStart;
  }

  /**
   * Method to get destination room from user keyboard input
   *
   * @return roomDest the destination room number as an int
   */
  public int getDestRoom() {
    System.out.println("Enter the room number of your destination: ");
    Scanner keyboard = new Scanner(System.in);
    roomDest = keyboard.nextInt();
    return roomDest;
  }


  public void main() {
    Map newMap = new Map();
    //call method to print the map
    newMap.printGrid();
    //call method to get starting room from user
    int roomStart = getStartRoom();

    //call method to get destination room from user
    int roomDest = getDestRoom();


    // Make a new floorplan
    FloorPlans floorPlan = new FloorPlans("Taylor Family Digital Library", roomDest);
    newMap.setCurrentFloorPlan(floorPlan);
    // make a new path
    Path path = new Path(floorPlan.getGrid(), roomStart, roomDest);
    newMap.setStartValues(floorPlan, roomStart);
    newMap.setEndValues(floorPlan, roomDest);


    //call method to create the path from starting room to destination room.
    int[][] endGrid = path.createPath();
    //place the number 8 as a marker for the starting room
    newMap.placeStart(endGrid);
    newMap.printGrid();

    //place the number 5 as a marker for destination room
    newMap.placeDest(endGrid);
    newMap.printGrid();

    System.out.println("A new grid: ");
    //print the map again with the number 7 showing a path between the rooms
    newMap.printGrid();
  }


  public static void main(String[] args) {
    MapMain mapMain = new MapMain();
    mapMain.main();

  }
}
