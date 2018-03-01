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



public class guiGrid extends Application {

  /*
  * There needs to be an argument for the new map creation to work with the
  * changes I made, ideally this would come from a button click that would
  * take in a room number - Dayan 22 Feb 2018
  * Last updated Feb 28 by Nicki.
  */

  private int rowNum = 14;
  private int colNum = 18;
  private Map map1 = new Map();
  private GridPane gridPane = new GridPane();
  private int roomNumbers = 0;


  public void makeGUI(int[][] aGrid, GridPane aGridPane){
    // clear the gridPane
    aGridPane.getChildren().clear();
    // set up the map grid
    for (int row = 0; row < rowNum; row++){
      for(int col = 0; col < colNum; col++){
        Rectangle rect = new Rectangle();
        if (aGrid[row][col] == 0){
          rect.setFill(Color.BLACK);
        } else if (aGrid[row][col] == 1){
          rect.setFill(Color.TRANSPARENT);
        } else if (aGrid[row][col] == 9){
          rect.setFill(Color.GREY);
        } else if (aGrid[row][col] == 5){
          rect.setFill(Color.YELLOW);
        } else if (aGrid[row][col] == 8){
          rect.setFill(Color.RED);
        } else if (aGrid[row][col] == 7){
          rect.setFill(Color.GREEN);
        }else{
          rect.setFill(Color.LIGHTBLUE);
        }
        int roomNumbers = 0;
        roomNumbers = aGrid[row][col];
        Label rooms = new Label("");

        //conditional to add room numbers to the grid map.
        if (roomNumbers != 0 && roomNumbers != 1 && roomNumbers != 9 &&
        roomNumbers !=8 && roomNumbers !=5 && roomNumbers !=7){
          rooms.setFont(Font.font("Times New Roman", FontWeight.BOLD, 10));
          rooms.setText("" + roomNumbers);
        } else if (roomNumbers == 8){
          rooms.setFont(Font.font("Times New Roman", FontWeight.BOLD, 10));
          rooms.setText("" + "S");
        } else if (roomNumbers == 5){
          rooms.setFont(Font.font("Times New Roman", FontWeight.BOLD, 10));
          rooms.setText("" + "D");
        }
        rect.setStroke(Color.BLACK);
        rect.setWidth(30);
        rect.setHeight(30);
        StackPane stack = new StackPane();
        stack.getChildren().addAll(rect, rooms);
        GridPane.setRowIndex(stack, row);
        GridPane.setColumnIndex(stack, col);
        aGridPane.getChildren().addAll(stack);
        //https://stackoverflow.com/questions/35367060/gridpane-of-squares-in-javafx
      }
    }
    // place start and destination markers

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
    destText, startButton);


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

    // new submit button for scene 2
    Button submitB = new Button("Submit");
    //handle when submit button (in scene 2) is clicked
    submitB.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent event){
        String buildingSubmit = "Taylor Family Digital Library";
        int roomNumberSub1 = Integer.parseInt(enterStartRoom.getText());
        int roomNumberSub2 = Integer.parseInt(enterDestRoom.getText());
        FloorPlans updatedPlan2 = new FloorPlans();
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

    VBox topVBox = new VBox(15);
    topRow.getChildren().addAll(buildingDropDown, enterStartRoom,
    enterDestRoom, submitB);
    topVBox.getChildren().addAll(topRow2,topRow);
    // set the alignment of the grid pane
    gridPane.setAlignment(Pos.CENTER);

    //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html
    BorderPane borderPanes2 = new BorderPane();
    borderPanes2.setCenter(gridPane);
    borderPanes2.setTop(topVBox);

    Scene scene2 = new Scene(borderPanes2,700,700);

    //handle when start button (in scene 1) is clicked
    startButton.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(ActionEvent event){
        String building2 = buildingText.getText();
        int roomNumber1 = Integer.parseInt(startText.getText());
        int roomNumber2 = Integer.parseInt(destText.getText());
        FloorPlans updatedPlan = new FloorPlans();
        updatedPlan.setGrid("Taylor Family Digital Library", roomNumber2);
        map1.setCurrentFloorPlan(updatedPlan);

        // add markers for the destination (yellow)
        Path testPath = new Path(updatedPlan);
        testPath.setDestLoc(roomNumber2);
        map1.placeDest(testPath.getEndRow(),testPath.getEndCol());
        testPath.setStartLoc(roomNumber1);
        map1.placeStart(testPath.getStartRow(),testPath.getStartCol());

        testPath.createPath();
        // Create the GUI for the map
        makeGUI(updatedPlan.getGrid(),gridPane);
        primaryStage.setScene(scene2);
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
