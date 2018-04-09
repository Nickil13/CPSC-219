import java.util.ArrayList;
import resources.BuiltFloorPlans;
import java.io.Serializable;
public class Building implements Serializable{

  private ArrayList<FloorPlans> floorList = new ArrayList<FloorPlans>();
  private String buildingName;


  public Building(){}

  public Building(String bName){
    buildingName = bName;
    addFloors();
  }

  public Building(Building toCopy){
    buildingName = toCopy.getName();
    floorList = toCopy.getFloorList();
  }

  public String getName(){
    return buildingName;
  }

  public void addFloors(){
    if(buildingName.equals("Taylor Family Digital Library")){ //stairs, elevator
      String name = "Taylor Family Digital Library";
      floorList.add(new FloorPlans(name,BuiltFloorPlans.TFDLGROUND,0,23,18));
      floorList.add(new FloorPlans(name, BuiltFloorPlans.TFDLONE, 1, 125,170));
      floorList.add(new FloorPlans(name,BuiltFloorPlans.TFDLTWO, 2, 225, 270));
      floorList.add(new FloorPlans(name,BuiltFloorPlans.TFDLTHREE, 3,370,366));
      floorList.add(new FloorPlans(name,BuiltFloorPlans.TFDLFOUR, 4,450,470));//add real stairs and ele nums
      floorList.add(new FloorPlans(name,BuiltFloorPlans.TFDLFIVE, 5,552,517));//add real stairs and ele nums
      floorList.add(new FloorPlans(name,BuiltFloorPlans.TFDLSIX, 6,603,679));
      System.out.println("Floors added.");
      System.out.println("Length of plans1: " + floorList.size());
    }
  }
  public FloorPlans getFloorPlan(int roomNumber){
    int floorNum=0;
    int numDigits;
    numDigits = (int) Math.log10(roomNumber) + 1;
    /* if the provided room number has less than three digits it will be on the
    basement floor.*/
    if (numDigits < 3) {
      floorNum = 0;
    }
    /*get floor number from first digit of room number if it is not the basement*/
    else {
      floorNum = roomNumber;
      while (floorNum > 9) {
        floorNum /= 10;
      }
    }
    System.out.println("Length of plans2: " + floorList.size());
    FloorPlans toReturn = new FloorPlans();
    for(FloorPlans floor : getFloorList()){
      System.out.println(floor.getFlNum());
      if(floor.getFlNum() == floorNum) return new FloorPlans(floor);
    }
    return new FloorPlans();
  }

  public ArrayList<FloorPlans> getFloorList(){
    return floorList;
  }


}
