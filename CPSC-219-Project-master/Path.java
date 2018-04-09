import java.util.ArrayList;

/**
 * Class that finds the shortest path from point A to point B
 * on a single array of integers, avoiding any obstacles
 * pathfinding portion of the program
 * Last Edited by Dayan J.
 * 4 Mar 2018
 */
public class Path {
  int[][] floorGrid;
  int[][] copyGrid;
  int startRoomNum;
  int endRoomNum;
  ArrayList<Node> nodes = new ArrayList<Node>();


  /**
   * Contructor requires a grid on which to find a path
   *
   * @param newGrid of a desired grid
   */
  public Path(int[][] newGrid) {
    setFloorGrid(newGrid);
  }

  /**
   * Constructor that will set start and end room numbers on a Grid
   *
   * @param aGrid         containing a 2-d integer grid
   * @param aStartRoomNum a desired start point
   * @param aEndRoomNum   a desired end point
   */
  public Path(int[][] aGrid, int aStartRoomNum, int aEndRoomNum) {
    setFloorGrid(aGrid);
    setStartRoomNum(aStartRoomNum);
    setEndRoomNum(aEndRoomNum);
  }

  /**
   * Copy Constructor
   *
   * @param aCopyPath a desired path to copy
   */
  public Path(Path aCopyPath) {
    setFloorGrid(aCopyPath.getFloorGrid());
    setStartRoomNum(aCopyPath.getStartRoomNum());
    setEndRoomNum(aCopyPath.getEndRoomNum());
  }

  /**
   * Getter method for the grid
   *
   * @return integer two dimensional grid
   */
  public int[][] getFloorGrid() {
    return floorGrid;
  }

  /**
   * Setter Method for the grid
   *
   * @param aGrid the two dimensional integer grid containing the floorplan
   */
  public void setFloorGrid(int[][] aGrid) {
    floorGrid = aGrid;
    copyGrid = aGrid;
  }

  /**
   * Getter and Setter methods for the starting room number
   *
   * @return the start room number
   */
  public int getStartRoomNum() {
    return startRoomNum;
  }

  /**
   * Setter method for the starting room number
   *
   * @param newStart must be a positive integer
   */
  public void setStartRoomNum(int newStart) {
    if (newStart >= 0) {
      startRoomNum = newStart;
    }
  }


  /**
   * Getter method for the endpoint room number
   *
   * @return the endpoint room number
   */
  public int getEndRoomNum() {
    return endRoomNum;
  }

  /**
   * Setter method for the ending room number
   *
   * @param newEnd must be a positive integer
   */
  public void setEndRoomNum(int newEnd) {
    if (newEnd >= 0) {
      endRoomNum = newEnd;
    }
  }

  /**
   * Getter method for the start node
   *
   * @param nodes an Arraylist that of the nodes of the grid
   * @return the node that specifies it is the start location
   */
  public Node getStartNode(ArrayList<Node> nodes) {
    Node startNode = null;
    if (nodes != null) {
      for (Node node : nodes) {
        if (node.getStartNodeVal() == true) {
          startNode = new Node(node);
        }
      }
    }
    return startNode;
  }

  /**
   * Getter method for the end node
   *
   * @param nodes an Arraylist that of the nodes of the grid
   * @return the node that specifies it is the end location
   */
  public Node getEndNode(ArrayList<Node> nodes) {
    Node endNode = null;
    if (nodes != null) {
      for (Node node : nodes) {
        if (node.getEndNodeVal() == true) {
          endNode = new Node(node);
        }
      }
    }
    return endNode;
  }

  /**
   * Add node to an arraylist list of nodes
   *
   * @param nodes arraylist of nodes
   * @param aNode the node to add to the arraylist
   */
  public void addNodeToList(ArrayList<Node> nodes, Node aNode) {
    if (aNode != null) {
      nodes.add(new Node(aNode));
    }
  }

  /**
   * Removing a specific node from a list
   *
   * @param nodes   containing the the arraylist of nodes
   * @param newNode that is to be removed from the arraylist
   * @return an arraylist with the removed node
   */
  public ArrayList<Node> removeNodeFromList(ArrayList<Node> nodes, Node newNode) {
    ArrayList<Node> copyList = getCopyNodes(nodes);
    ArrayList<Node> removeList = new ArrayList<Node>();
    for (Node node : copyList) {
      if (node.equals(newNode)) {
        removeList.add(node);
      }
    }
    for (Node removeNode : removeList) {
      copyList.remove(removeNode);
    }
    return copyList;
  }

  /**
   * Create a copy of an arraylist and its items
   *
   * @param nodes the arraylist to copy
   * @return the copy of the arraylist
   */
  public ArrayList<Node> getCopyNodes(ArrayList<Node> nodes) {
    ArrayList<Node> copyNodes = new ArrayList<Node>();
    if (nodes != null) {
      for (int i = 0; i < nodes.size(); i++) {
        addNodeToList(copyNodes, nodes.get(i));
      }
    }
    return copyNodes;
  }

  /**
   * Determining the node with the lowest distance instance value from the start node
   *
   * @param nodes containing the arraylist of nodes
   * @return the node with the lowest distance from the start
   */
  public Node getLowestDistanceNode(ArrayList<Node> nodes) {
    Node lowestNode = null;
    Node finalLowestNode = null;
    if (nodes != null) {
      for (int i = 0; i < nodes.size(); i++) {
        if (lowestNode != null) {
          if (lowestNode.getStartDistance() > nodes.get(i).getStartDistance()) {
            lowestNode = nodes.get(i);
          }
        } else {
          lowestNode = nodes.get(i);
        }
        finalLowestNode = new Node(lowestNode);
      }
    }
    return finalLowestNode;
  }

  /**
   * From a grid create an array of nodes that are traversable
   *
   * @param aGrid the grid from which to create an arraylist of nodes
   * @return the created arraylist
   */
  public ArrayList<Node> createNodeArray(int[][] aGrid) {
    ArrayList<Node> nodes = new ArrayList<Node>();
    for (int row = 0; row < aGrid.length; row++) {
      for (int column = 0; column < aGrid[row].length; column++) {
        //used for the Node constuctor
        boolean endNode = false;

        if (aGrid[row][column] == 1) {
          addNodeToList(nodes, new Node(row, column, endNode));
        } else if (floorGrid[row][column] == endRoomNum) {
          endNode = true;
          addNodeToList(nodes, new Node(row, column, endNode));
        } else if (floorGrid[row][column] == startRoomNum) {
          addNodeToList(nodes, new Node(row, column, 0));
        }
      }
    }
    return nodes;
  }

  /**
   * Sets the instance variables of the Neighboring nodes to their appropriate
   * value
   *
   * @param initialNode that the node is currently being analyzed
   * @param newNode     which will have its intance variables altered accordingly
   */
  public void setNeighborInstances(Node initialNode, Node newNode) {
    double diagonalMoveWeight = 14;
    double otherMoveWeight = 10;
    double initialNodeDistance = initialNode.getStartDistance();
    double newNodeDistance = newNode.getStartDistance();
    double finalDiagonalDistance = diagonalMoveWeight + initialNodeDistance;
    double finalOtherDistance = otherMoveWeight + initialNodeDistance;
    //Checking Euclidean distance for Neighboring Nodes, includes diagonals
    if (newNode.calcDistance(initialNode) < 2) {
      //Euclidean distance for Diagonal; move weighted lower
      if (newNode.calcDistance(initialNode) > 1) {
        if (newNodeDistance > finalDiagonalDistance) {
          newNode.setStartDistance(finalDiagonalDistance);
          newNode.setConnectedNode(new Node(initialNode));
        }
      }
      //Euclidean distance for Horizontal; move weighted higher
      else {
        if (newNodeDistance > finalOtherDistance) {
          newNode.setStartDistance(finalOtherDistance);
          newNode.setConnectedNode(new Node(initialNode));
        }
      }
    }
  }

  /**
   * Takes the arraylist of nodes and initializes different values
   * for the distance based on the best move
   *
   * @param nodes containing the arraylist of nodes
   * @return an arraylist of nodes with all the appropriate instance
   * variables set to create the shortest path
   */
  public ArrayList<Node> setNodeDistances(ArrayList<Node> nodes) {
    int counter = 0;
    ArrayList<Node> unvisitedNodes = getCopyNodes(nodes);
    Node endNode = getEndNode(unvisitedNodes);
    ArrayList<Node> visitedNodes = new ArrayList<Node>();
    boolean endNodeVisited = false;
    do {
      counter += 1;

      Node vertex = getLowestDistanceNode(unvisitedNodes);
      if (vertex.equals(endNode)) {
        endNodeVisited = true;
      }
      //System.out.println(counter);
      addNodeToList(visitedNodes, vertex);
      //ArrayList<Node> removeList = new ArrayList<Node>();
      unvisitedNodes = removeNodeFromList(unvisitedNodes, vertex);
      //System.out.println(unvisitedNodes);
      //System.out.println(visitedNodes);
      for (Node eachNode : unvisitedNodes) {
        //System.out.println(eachNode.getStartDistance());
        setNeighborInstances(vertex, eachNode);
        //System.out.println(eachNode.getStartDistance());
      }
    } while (endNodeVisited != true);


    return getCopyNodes(visitedNodes);
  }

  /**
   * Returns a list of only the fully created path nodes to be used when
   * altering the grid
   *
   * @param visitedNodes containing an arraylist of nodes
   * @return an arraylist of nodes that only contain the direct path nodes
   */

  public ArrayList<Node> getConnectedNodes(ArrayList<Node> visitedNodes) {
    ArrayList<Node> shortestPathNodes = new ArrayList<Node>();
    Node currentNode = getEndNode(visitedNodes);
    if (visitedNodes != null) {
      while (currentNode.getConnectedNode() != null) {
        addNodeToList(shortestPathNodes, currentNode);
        Node nextNode = currentNode.getConnectedNode();
        currentNode = nextNode;
      }
    }
    return getCopyNodes(shortestPathNodes);
  }

  /**
   * Takes an Arraylist of connected nodes forming the shortest path
   * and alters the grid to show the final path
   *
   * @param shortPathNodes containing an arraylist of the shortest path nodes
   * @return a grid with the altered values showing the shortest path from point a to point b
   */
  public int[][] addPathToGrid(ArrayList<Node> shortPathNodes) {
    for (Node aNode : shortPathNodes) {
      int nodeRow = aNode.getXCoord();
      int nodeCol = aNode.getYCoord();
      if (aNode.getEndNodeVal() == false) {
        copyGrid[nodeRow][nodeCol] = 7;
      }

    }
    return copyGrid;
  }

  /**
   * Method that will combine other methods into simpler step
   *
   * @return a grid that will show the shortest path on a grid
   */
  public int[][] createPath() {
    ArrayList<Node> gridNodes = createNodeArray(floorGrid);
    int[][] finGrid = addPathToGrid(getConnectedNodes(setNodeDistances(gridNodes)));
    return finGrid;
  }
}
