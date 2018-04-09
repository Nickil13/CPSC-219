import java.util.ArrayList;
/**
* This class is an extension of Room and
* is used with the Bathroom button in the FinderApp.
*/
public class Bathroom extends Room{

  /**
   * Constructor for Bathroom class that takes an int
   * @param num the number of the room as type int
   */
  public Bathroom(int num){
    super(num);
  }

  public Bathroom(Bathroom toCopy){
    super(toCopy);
  }


}
