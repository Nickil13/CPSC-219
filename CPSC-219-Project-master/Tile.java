// Last updated 29 by Nicki.

/**
 * Class that represents a single point in the grid
 * Last edited by Dayan - 27 Mar 2018
 */
import java.io.Serializable;
public class Tile implements Serializable{
  private int xCoord;
  private int yCoord;


  /**
   * Constructor used for setting the node with an x and y coordinate as well as the endnode value
   *
   * @param initX xcoordinate integer
   * @param initY ycoordinate integer
   */
  public Tile(int initX, int initY) {
    setXCoord(initX);
    setYCoord(initY);
  }

  /**
   * Copy Constuctor for the node
   *
   * @param copyNode
   */
  public Tile(Tile copyTile) {
    setXCoord(copyTile.getXCoord());
    setYCoord(copyTile.getYCoord());
  }

  /**
   * Setter method for the xcoordinate
   *
   * @param newX an xcoordinate cannot be a negative value
   */
  public void setXCoord(int newX) {
    if (newX >= 0) {
      xCoord = newX;
    } else {
      xCoord = 0;
    }
  }

  /**
   * Getter method for the xcoordinate
   *
   * @return an xcoordinate
   */
  public int getXCoord() {
    return xCoord;
  }

  /**
   * Setter method for the ycoordinate
   *
   * @param newY an ycoordinate cannot be a negative value
   */
  public void setYCoord(int newY) {
    if (newY >= 0) {
      yCoord = newY;
    } else {
      yCoord = 0;
    }
  }

  /**
   * Getter method for the ycoordinate
   *
   * @return a yoordinate
   */
  public int getYCoord() {
    return yCoord;
  }

  /**
   * Euclidean distance calculator between tiles
   *
   * @param aTile for which to calculate the distance for
   * @return the distance
   */
  public double calcDistance(Tile aTile) {
    int xDistance = getXCoord() - aTile.getXCoord();
    int yDistance = getYCoord() - aTile.getYCoord();
    double eucDistance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
    return eucDistance;
  }

  /**
   * Check is the position of another tile is the same as this tile
   *
   * @param aTile for which to compare
   * @return whether or not they are equivalent in terms of coordinates
   */
  public boolean equals(Tile aTile) {
    boolean equality = false;
    if (aTile.getXCoord() == getXCoord() && aTile.getYCoord() == getYCoord()) {
      equality = true;
    }
    return equality;
  }
}

