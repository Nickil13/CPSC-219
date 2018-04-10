/**
 * A class that contains the data for the points on a grid and makes them usable within arraylists for
 * various tasks
 */
 
public class Node extends Tile {
  private boolean startNodeVal = false;
  private boolean endNodeVal = false;
  private double startDistance = Double.POSITIVE_INFINITY;
  private Node connectedNode = null;


  /**
   * Constructor used when provided with various arguments
   *
   * @param initX            the x coordinate of the node
   * @param initY            the y coordinate of the node
   * @param newStartDistance the initial distance from the start point
   */
  public Node(int initX, int initY, double newStartDistance) {
    super(initX, initY);
    setStartDistance(newStartDistance);
    setStartNodeVal(true);
  }

  /**
   * Constructor used for setting the node with an x and y coordinate as well as the endnode value
   *
   * @param initX xcoordinate integer
   * @param initY ycoordinate integer
   * @param val   boolean value whether it is an end point node or not
   */
  public Node(int initX, int initY, boolean val) {
    super(initX, initY);
    setEndNodeVal(val);
  }

  /**
   * Constructor used for setting the node with an x and y coordinate as well as the endnode value
   *
   * @param initX xcoordinate integer
   * @param initY ycoordinate integer
   */
  public Node(int initX, int initY) {
    super(initX, initY);
  }

  /**
   * Copy Constuctor for the node
   *
   * @param copyNode
   */
  public Node(Node copyNode) {
    super(copyNode.getXCoord(), copyNode.getYCoord());
    setStartNodeVal(copyNode.getStartNodeVal());
    setEndNodeVal(copyNode.getEndNodeVal());
    setStartDistance(copyNode.getStartDistance());
    setConnectedNode(copyNode.getConnectedNode());
  }


  /**
   * Setter method for whether the node is a start node
   *
   * @param value boolean
   */
  public void setStartNodeVal(boolean value) {
    startNodeVal = value;
  }

  /**
   * Getter method for whether node is a start node
   *
   * @return start node value boolean
   */
  public boolean getStartNodeVal() {
    return startNodeVal;
  }

  /**
   * Setter method for whether the node is a end node
   *
   * @param value boolean
   */
  public void setEndNodeVal(boolean value) {
    endNodeVal = value;
  }

  /**
   * Getter method for whether node is a end node
   *
   * @return end node value boolean
   */
  public boolean getEndNodeVal() {
    return endNodeVal;
  }

  /**
   * Getter method for the distance from the startnode
   *
   * @return the startnode distance
   */
  public double getStartDistance() {
    return startDistance;
  }

  /**
   * Getter method for the distance from the startnode
   *
   * @param newDistance double
   */
  public void setStartDistance(double newDistance) {
    startDistance = newDistance;
  }

  /**
   * Setter method for the node
   *
   * @param: prevNode a node that will be set as the connected node
   */
  public void setConnectedNode(Node prevNode) {
    if (prevNode != null) {
      connectedNode = new Node(prevNode);
    } else {
      connectedNode = null;
    }
  }

  /**
   * Getter method for the connected node
   *
   * @return: the connected node
   */
  public Node getConnectedNode() {
    Node newConnectedNode = null;
    if (connectedNode != null) {
      newConnectedNode = new Node(connectedNode);
    } else {
      newConnectedNode = null;
    }
    return newConnectedNode;
  }

  /**
   * Checks the direction of the movement from the connected node
   * @return: the direction as a string
   */
  public String getDirection() {
    Node connectedNode = getConnectedNode();
    String currentDirection = null;
    double nonDiagonalMove = 1;
    //Check if diagonal
    if (calcDistance(connectedNode) <= nonDiagonalMove) {
      //Check if same column
      if (getYCoord() == connectedNode.getYCoord()) {
        //Check row
        if (getXCoord() < connectedNode.getXCoord()) {
          currentDirection = "N";
        }
        else {
          currentDirection = "S";
        }
      }
      else {
        if (getYCoord() < connectedNode.getYCoord()) {
          currentDirection = "W";
        }
        else {
          currentDirection = "E";
        }
      }
    }
    else {
      if (getXCoord() < connectedNode.getXCoord()) {
        //Check row
        if (getYCoord() < connectedNode.getYCoord()) {
          currentDirection = "NW";
        }
        else {
          currentDirection = "NE";
        }
      }
      else {
        if (getYCoord() < connectedNode.getYCoord()) {
          currentDirection = "SW";
        }
        else {
          currentDirection = "SE";
        }
      }
    }
    return currentDirection;
  }
}

