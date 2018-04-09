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
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.Popup;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.ScrollPane;
import javafx.geometry.Insets;
import javafx.scene.paint.Paint;

public class testGrid extends Application{
  private int[][] layout =
  {{0,1,0},
  {1,0,1},
  {0,1,0}};
  private Button[][] layoutButtons = new Button[3][3];
  private Rectangle[][] rectangles = new Rectangle[3][3];

  public void makeGrid(GridPane aGP){
    int row;
    int col;
    for(row = 0; row <3;row++){
      for(col=0;col<3;col++){
        Rectangle rect = new Rectangle();
        if(layout[row][col]==1){
          rect.setFill(Color.BLUE);
        }else if(layout[row][col]==0){
          rect.setFill(Color.GREEN);
        }
        rect.setWidth(50);
        rect.setHeight(50);
        rectangles[row][col] = rect;
        Button b = new Button();
        layoutButtons[row][col] =b;
        VBox v = new VBox();
        v.getChildren().add(rect);
        b.setMinSize(50,50);
        b.setPadding(new Insets(0));
        b.setOnAction(new HandleGridClick(row,col));
        StackPane testStack = new StackPane();
        testStack.getChildren().addAll(b,v);
        v.setMouseTransparent(true);

        aGP.add(testStack,col,row);
      }
    }
  }
  public class HandleGridClick implements EventHandler<ActionEvent>{
    private int row;
    private int col;
    private int count=0;

    public HandleGridClick(int aRow,int aCol){
      row = aRow;
      col = aCol;
    }
    public void handle(ActionEvent event){
      if(count ==0){
        count+=1;
        System.out.println("Clicked the first time");
        Rectangle rect = rectangles[row][col];

        if(rect.getFill().equals(Color.GREEN)){
          System.out.println("that rectangle is coloured green");
        }

      }else if(count == 1){
        System.out.println("Clicked the second time");
        count = 0;
      }
      if(row ==0 && col == 0){
        System.out.println("clicked the top corner!");
      }
    }
  }

  public void start(Stage primaryStage){
    GridPane theGP = new GridPane();
    makeGrid(theGP);
    BorderPane testPane = new BorderPane();
    testPane.setCenter(theGP);
    Scene testScene = new Scene(testPane,200,200);
    primaryStage.setScene(testScene);
    primaryStage.show();

  }






}
