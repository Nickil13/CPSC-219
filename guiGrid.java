import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;





public class guiGrid extends Application {

  /*
  * There needs to be an argument for the new map creation to work with the
  * changes I made, ideally this would come from a button click that would
  * take in a room number - Dayan 22 Feb 2018
  * Last updated March 3 by Nicki.
  */

  private int rowNum = 14;
  private int colNum = 18;
  private Map map1 = new Map();
  private GridPane gridPane = new GridPane();
  private int roomNumbers = 0;
  private Label invalidEntry = new Label ("");
  private Label invalidEntry2 = new Label("");

  private final int RECTD =30;
  private final int HALL = 1;
  private final int WALL = 0;
  private final int ROOM = 9;
  private final int START = 8;
  private final int DEST = 5;
  private final int PATH = 7;
  private final int REST = 888;
  private final int EL = 555;
  private final int STAIR = 777;
  private final int COFF = 999;
  private int[] notMap = {WALL,HALL,ROOM,START,DEST,PATH,REST,EL,STAIR,COFF};


  // For confirming whether an array contains a value.
  public boolean contains(int[] anArray, int aValue){
    boolean result = false;
    for(int i : anArray){
      if(i == aValue){
        result = true;
      }
    }
    return result;
  }

  public void makeGUI(int[][] aGrid, GridPane aGridPane){
    // clear the gridPane
    aGridPane.getChildren().clear();
    Image imgRestroom = new Image("RestroomImage.png",RECTD,RECTD, true, false);
    //Image source: http://maxpixel.freegreatpicture.com/Rest-Room-Restroom-Ladies-Restroom-Public-Restroom-99226
    Image imgCoffee = new Image("Coffee.png",RECTD,RECTD,true,false);
    //Image source: https://www.freepik.com/free-icon/hot-coffee-rounded-cup-on-a-plate-from-side-view_732944.htm
    Image imgStairs = new Image("Stairs.png", RECTD, RECTD, true, false); //Image source:https://pixabay.com/en/stairs-climb-levels-descend-44071/
    Image imgElevator = new Image("Elevator.png", RECTD, RECTD, true, false); //Image source: https://pixabay.com/en/elevator-people-silhouette-down-44013//
    // set up the map grid
    for (int row = 0; row < rowNum; row++){
      for(int col = 0; col < colNum; col++){
        Rectangle rect = new Rectangle();
        if (aGrid[row][col] == 0){
          rect.setFill(Color.BLACK);
        } else if (aGrid[row][col] == HALL){
          rect.setFill(Color.TRANSPARENT);
        } else if (aGrid[row][col] == ROOM){
          rect.setFill(Color.GREY);
        } else if (aGrid[row][col] == DEST){
          rect.setFill(Color.YELLOW);
        } else if (aGrid[row][col] == START){
          rect.setFill(Color.RED);
        } else if (aGrid[row][col] == PATH){
          rect.setFill(Color.GREEN);
        } else if(aGrid[row][col] == REST){
          rect.setFill(new ImagePattern(imgRestroom));
          //https://stackoverflow.com/questions/22848829/how-do-i-add-an-image-inside-a-rectangle-or-a-circle-in-javafx
        } else if(aGrid[row][col] == STAIR){
          rect.setFill(new ImagePattern(imgStairs));
        } else if(aGrid[row][col] == EL){
          rect.setFill(new ImagePattern(imgElevator));
        } else if(aGrid[row][col] == COFF){
          rect.setFill(new ImagePattern(imgCoffee));
        }else{
          rect.setFill(Color.LIGHTBLUE);
        }
        int roomNumbers = 0;
        roomNumbers = aGrid[row][col];
        Label rooms = new Label("");


        //Conditional to add room numbers to the grid map.
          if (contains(notMap,roomNumbers) == false){
            rooms.setFont(Font.font("Times New Roman", FontWeight.BOLD, 10));
            rooms.setText("" + roomNumbers);
          } else if (roomNumbers == START){
            rooms.setFont(Font.font("Times New Roman", FontWeight.BOLD, 10));
            rooms.setText("" + "S");
          } else if (roomNumbers == DEST){
            rooms.setFont(Font.font("Times New Roman", FontWeight.BOLD, 10));
            rooms.setText("" + "D");
          }
        rect.setStroke(Color.BLACK);
        rect.setWidth(RECTD);
        rect.setHeight(RECTD);

        StackPane stack = new StackPane();

        stack.getChildren().addAll(rect,rooms);
        GridPane.setRowIndex(stack, row);
        GridPane.setColumnIndex(stack, col);
        aGridPane.getChildren().add(stack);
        //aGridPane.getChildren().add(stack);
        //https://stackoverflow.com/questions/35367060/gridpane-of-squares-in-javafx
      }
    }
  }

  //check if entered valid start
  public boolean isValidStartRoom (int aStartRoom){
    boolean isValidStart = true;
    if(aStartRoom != 25 && aStartRoom != 150&&  aStartRoom != 151&&
    aStartRoom != 152&&  aStartRoom != 153&& aStartRoom != 154&&
    aStartRoom != 155&&  aStartRoom != 250&&  aStartRoom != 251&&
    aStartRoom != 252&&  aStartRoom != 259&& aStartRoom != 260&&
    aStartRoom != 261&&  aStartRoom != 262&& aStartRoom != 263&&
    aStartRoom != 264){
      System.out.println("Please enter a valid start room. Example: 162 or 164");
      invalidEntry.setText("Please enter a valid start room. Example: 162 or 164");
      invalidEntry2.setText("Please enter a valid start room. Example: 162 or 164");
      isValidStart = false;
    }return isValidStart;
  }

  //check if entered valid destination
  public boolean isValidDestRoom (int aDestRoom){
    boolean isValidDest = true;
    if(aDestRoom != 25 && aDestRoom != 150&&  aDestRoom != 151&&
    aDestRoom != 152&&  aDestRoom != 153&& aDestRoom != 154&&
    aDestRoom != 155&&  aDestRoom != 250&&  aDestRoom != 251&&
    aDestRoom != 252&&  aDestRoom != 259&& aDestRoom != 260&&
    aDestRoom != 261&&  aDestRoom != 262&& aDestRoom != 263&&
    aDestRoom != 264){
      System.out.println("Please enter a valid end room. Example: 151 or 161");
      invalidEntry.setText("Please enter a valid end room. Example: 151 or 161");
      invalidEntry2.setText("Please enter a valid end room. Example: 151 or 161");
      isValidDest = false;
    }return isValidDest;
  }

  @Override
  public void start(Stage primaryStage){
    //**
    // Start screen (first scene)
    //**

    BorderPane borderPanes1 = new BorderPane();

    Label appTitle = new Label("Room-Finder App!");
    appTitle.setFont(Font.font("Verdana", FontWeight.BOLD,20));

    Button startButton = new Button("Start");

    TextField buildingText = new TextField("Taylor Family Digital Library");

    TextField destText = new TextField("Enter the room number you want to find.");

    TextField startText = new TextField("Enter the number of the room you are at.");


    VBox startVBox = new VBox(10);

    startVBox.getChildren().addAll(appTitle, buildingText, startText,
    destText, invalidEntry2, startButton);


    //add all boxes to borderPane1
    borderPanes1.setCenter(startVBox);
    startVBox.setAlignment(Pos.CENTER);


    // create the scene itself
    Scene scene1 = new Scene(borderPanes1,700,700);


    //**
    // Main screen (second scene)
    //**

    HBox topRow = new HBox();
    topRow.setAlignment(Pos.CENTER);

    Label appName = new Label ("Taylor Family Digital Library Pathfinder");
    appName.setFont(Font.font("Verdana", FontWeight.BOLD,15));

    HBox topRow2 = new HBox();
    topRow2.setAlignment(Pos.CENTER);
    topRow2.getChildren().add(appName);

    //https://docs.oracle.com/javafx/2/ui_controls/combo-box.htm
    ComboBox<String> buildingDropDown = new ComboBox<String>();
    buildingDropDown.getItems().addAll("Taylor Family Digital Library");

    TextField enterStartRoom = new TextField("Enter the start room");
    TextField enterDestRoom= new TextField("Enter destination room");


    // New submit button for Scene 2
    Button submitB = new Button("Submit");

    // Handle when submit button (in scene 2) is clicked.
    submitB.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent event){
        invalidEntry.setText("");
        String buildingSubmit = buildingDropDown.getValue();
        int roomNumberSub1 = Integer.parseInt(enterStartRoom.getText());
        int roomNumberSub2 = Integer.parseInt(enterDestRoom.getText());
        FloorPlans updatedPlan2 = new FloorPlans();
        isValidStartRoom(roomNumberSub1);
        isValidDestRoom(roomNumberSub2);
        updatedPlan2.setGrid("Taylor Family Digital Library",
        roomNumberSub2);
        map1.setCurrentFloorPlan(updatedPlan2);

        // add markers for the destination (yellow)
        Path testPathSub = new Path(updatedPlan2);
        testPathSub.setDestLoc(roomNumberSub2);
        map1.placeDest(testPathSub.getEndRow(),testPathSub.getEndCol());
        testPathSub.setStartLoc(roomNumberSub1);
        map1.placeStart(testPathSub.getStartRow(),testPathSub.getStartCol());

        testPathSub.createPath();
        // Create the updated GUI for the map
        makeGUI(updatedPlan2.getGrid(),gridPane);

      }
    });
    // Create the layout boxes for Scene 2.
    VBox topVBox = new VBox(15);

    HBox invalidHBox = new HBox(10);
    invalidHBox.getChildren().add(invalidEntry);
    invalidHBox.setAlignment(Pos.CENTER);

    topRow.getChildren().addAll(buildingDropDown, enterStartRoom,
    enterDestRoom, submitB);

    topVBox.getChildren().addAll(topRow2,topRow,invalidHBox);

    // Set the alignment of the grid pane.
    gridPane.setAlignment(Pos.CENTER);

    //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html
    BorderPane borderPanes2 = new BorderPane();
    borderPanes2.setCenter(gridPane);
    borderPanes2.setTop(topVBox);

    // Create Scene 2.
    Scene scene2 = new Scene(borderPanes2,700,700);

    //Handle when start button (in scene 1) is clicked
    startButton.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent event){
        invalidEntry2.setText("");
        String building2 = buildingText.getText();
        int roomNumber1 = Integer.parseInt(startText.getText());
        int roomNumber2 = Integer.parseInt(destText.getText());
        FloorPlans updatedPlan = new FloorPlans();

        if(isValidStartRoom(roomNumber1) && isValidDestRoom(roomNumber2)){
        updatedPlan.setGrid(building2, roomNumber2);
        map1.setCurrentFloorPlan(updatedPlan);

        // add markers for the destination (yellow)
        Path testPath = new Path(updatedPlan);
        testPath.setDestLoc(roomNumber2);
        map1.placeDest(testPath.getEndRow(),testPath.getEndCol());
        testPath.setStartLoc(roomNumber1);
        map1.placeStart(testPath.getStartRow(),testPath.getStartCol());

        testPath.createPath();
        invalidEntry.setText("");
        // Create the GUI for the map
        makeGUI(updatedPlan.getGrid(),gridPane);
        primaryStage.setScene(scene2);}
      }
    });

    primaryStage.setTitle("GUI");
    primaryStage.setScene(scene1);
    primaryStage.show();

  }
  public static void main(String[] args) {
     launch(args);
   }
}
