/**Main portion of the pathfinding program. Finds a path between a destination room from a starting
room from the user. Floor is modelled off of north portion of 2nd floor Taylor Family Digital Library.
1s are hallway, 0s are walls, 200-series numbers are room names, 9s are rooms themselves, 8 marks starting room,
5 marks destination room, 7s mark path found between rooms. Created by Nicki Lindstrom, Dayan Jayasuriya, and Riley Schaaf
Last Edited by Nicki Feb 28*/

import java.util.Scanner;

public class MapMain {
  private Map mainMap;
  private Path newPath;
  //private int startRow; -- ** get these from Path
  //private int startCol;
  //private int endRow;
  //private int endCol;

  // gets these two variables from input to the GUI
  private int roomStart;
  private int roomDest;

  /* Constructors
  *
  * Create new Map and Path when running main
  */

  public MapMain() {
    mainMap = new Map();
    newPath = new Path(newMap);
  }


  //user input Methods
  //get starting room from user
  public int getStartRoom() {
    System.out.println("Enter the room number nearest to you: ");
    Scanner keyboard = new Scanner(System.in);
    roomStart = keyboard.nextInt();
    return roomStart;
  }

  //get destination room from user
  public int getDestRoom() {
    System.out.println("Enter the room number of your destination: ");
    Scanner keyboard = new Scanner(System.in);
    roomDest = keyboard.nextInt();
    return roomDest;
  }


/*I just got rid of this for the time being. Not sure if still neeede,
but method names currently causing errors.*/
/* public void main(){
    //call method to print the map
    newMap.print();
    //call method to get starting room from user
    Map.getStartRoom();
    //call method to set starting room
    newPath.setStartLoc(roomStart);
    //place the number 8 as a marker for the starting room
    newPath.placeStart();
    //call method to print map again with starting maker
    newPath.printGrid();
    //call method to get destination room from user
    getDestRoom();
    //call method to set destination room
    newPath.setDestLoc(roomDest);
    //place the number 5 as a marker for destination room
    newPath.placeDest();
    System.out.println("With destination.");
    //print the map to show markers for starting and destination rooms
    newPath.printGrid();
    System.out.println(" ");
  //  System.out.println("Current X: "+ newPath.getCurrentX());
  //  System.out.println("Current Y: "+ newPath.getCurrentY());
      //call method to create the path from starting room to destination room.
      newPath.createPath();
    System.out.println("A new grid: ");
    //print the map again with the number 7 showing a path between the rooms
    newPath.printGrid();
  }*/


  public static void main(String[] args){
    MapMain map1 = new MapMain();
    map1.main();
  }
}
