package resources;

/**
* This class contains the text for the messages in the GUI FinderApp.
* The messages included are for the Help? and About buttons, as well as for the
* invalid entries by the user messaging.
*/

public class GUIText{

  // Message for when the user clicks the Help? button
  public static final String HELP_MESSAGE =     "To use this app: Select a building from the dropdown box, enter a starting room\n" +
      "number in the first textbox and a destination room in the second textbox. Then press\n" +
      "the submit button. If you enter an invalid room, example room numbers will be provided\n" +
      "in a message. Or, click a starting room label and a destination room label on the map and \n"+
      "follow the dialogue box instructions.";

  //Message for when the user clicks the About button
  public static final String ABOUT_MESSAGE = "This app allows the user to select a building and \n" +
  "enter a starting room location and a desired destination location. The user also\n"+
  "has the option to click the labelled room numbers instead of entering a room number.\n"+
  "The app will then highlight the path between these two destinations.\n" +
  "To use this app: Select a building from the dropdown box, enter a starting room\n" +
  "number in the first textbox and a destination room in the second textbox. Then press\n" +
  "the submit button. Or, click a starting room label and a destination room label on the map.\n" +
  "Creators: Nicki, Dayan, and Riley. Created Winter 2018 for CPSC 219.";

  //Message for when the destination is on a different floor from the start room and the use of the stairs or elevator is needed.
  public static final String INVALID_ENTRY_DIFFERENT_FLOOR = "Your destination is on a different floor. Use the elevator and stair buttons"+
  "on the right to choose which path you want to take to the next floor.";

  //Message for when the user inputs a start room number that does not exist.
  public static final String INVALID_ENTRY_INVALID_START = "Please enter a valid start room. Example: 262 or 264";

  //Message for when the user inputs a destination room number that does not exist.
  public static final String INVALID_ENTRY_INVALID_DEST = "Please enter a valid destination room. Example: 262 or 264";

  //Message for when the user inputs the room number not as an integer, such as by trying to type the number as a String.
  public static final String INVALID_ENTRY_WRONG_FORMAT = "Please enter the room number as an integer.";

}
