package gameworld;

import java.awt.*;
import java.util.List;

public class Room {

  private int row;
  private int col;
  private Tile[][] tiles;
  private List<Item> items;
  private List<String> doors;

  public static final Point TOP = new Point(0, 5);
  public static final Point BOTTOM = new Point(9, 5);
  public static final Point LEFT = new Point(5, 0);
  public static final Point RIGHT = new Point(5, 9);
  public static final int ROOMSIZE = 10;

  public Room() {
    //TODO: Used for testing
    this.tiles = new Tile[ROOMSIZE][ROOMSIZE];
  }

  public Room(int row, int col, List<String> doors, List<Item> items) {

    this.row = row;
    this.col = col;
    this.items = items;
    this.doors = doors;
    this.tiles = new Tile[ROOMSIZE][ROOMSIZE];

    //For now until we can load in an XML file
    for (int i = 0; i < ROOMSIZE; i++) {
      for (int j = 0; j < ROOMSIZE; j++) {
        if (i == 0 || j == 0 || j == ROOMSIZE - 1 || i == ROOMSIZE - 1)
          tiles[i][j] = new InaccessibleTile(this, i, j);
        else tiles[i][j] = new AccessibleTile(this, i, j);
      }
    }

    for (Item item : this.items) {
      boolean itemPlaced = false;
      while (!itemPlaced) {
        int randomX = (int) (Math.random() * 8) + 1;
        int randomY = (int) (Math.random() * 8) + 1;
        if (tiles[randomY][randomX] instanceof AccessibleTile) {
          AccessibleTile tile = (AccessibleTile) tiles[randomY][randomX];
          if (!tile.hasToken()) {
            tile.setItem(item);
            itemPlaced = true;
          }
        }
      }
    }
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public List<Item> getItems() {
    return items;
  }

  public List<String> getDoors() {
    return doors;
  }

  public Tile moveTile(Tile t, int dx, int dy) {
    int[] coords = getTileCoordinates(t);

    int x = coords[0];
    int y = coords[1];

    int newX = x + dx;
    int newY = y + dy;


    //if the newCoordinates are inbounds and the tile is not inaacessible
    if (newX < 11 && newY < 11 && !(tiles[newX][newY] instanceof InaccessibleTile)) {
      return tiles[newX][newY];
    }

    return null;
  }

  private int[] getTileCoordinates(Tile t) {
    for (int i = 0; i < ROOMSIZE; i++) {
      for (int j = 0; j < ROOMSIZE; j++) {

        //returns coordinates of the tile
        if (tiles[i][j].equals(t)) return new int[]{i, j};
      }
    }

    return null;
  }

  public Tile getTile(int row, int col) {
    return tiles[row][col];
  }

  public void setTile(Tile tile, int row, int col) {
    tiles[row][col] = tile;
  }

  public Tile getNeighbour() {

    return null;
  }

  /**
   * This method creates and prints out the visual
   * representation of the room to the user.
   */
  public String draw() {

    StringBuilder room = new StringBuilder();

    for (int row = 0; row < ROOMSIZE; row++) {
      for (int col = 0; col < ROOMSIZE; col++) {

        Tile tile = tiles[row][col];

        if (tile instanceof InaccessibleTile)
          room.append("X");
        else if (tile instanceof DoorTile) {
          DoorTile doorTile = (DoorTile) tile;

          if (doorTile.hasPlayer())
            room.append("!");
          else
            room.append("0");
        } else if (tile instanceof AccessibleTile) {
          AccessibleTile accessibleTile = (AccessibleTile) tile;

          if (accessibleTile.hasPlayer() && accessibleTile.hasToken())
            room.append("!");
          else if (accessibleTile.hasPlayer())
            room.append("P");
          else if (accessibleTile.hasToken()) {
            Item item = accessibleTile.getItem();
            if (item instanceof Diffuser)
              room.append("D");
            if (item instanceof Antidote)
              room.append("A");
            if (item instanceof Coin)
              room.append("C");
            if (item instanceof Beer)
              room.append("R");
            if (item instanceof BoltCutter)
              room.append("Z");
          } else
            room.append(" ");
        }
        if (col < ROOMSIZE - 1)
          room.append(" ");
      }
      room.append("\n");
    }
    System.out.println(room.toString());
    return room.toString();
  }

  public DoorTile getNextDoorTile(Direction dir) {

    Point point = null;

    for (String direction : doors) {

      String d = dir.toString();

      assert d != null;

      if (d.equals(direction)) {
        point = getNextPoint(d);
      }
    }

    assert point != null;

    String s = tiles[point.x][point.y].toString();

    return (DoorTile) (tiles[point.x][point.y]);

  }

  public Point getNextPoint(String direction) {
    switch (direction) {
      case "left":
        return LEFT;
      case "right":
        return RIGHT;
      case "bottom":
        return BOTTOM;
      case "top":
        return TOP;
      default:
        return null;
    }
  }

  public AccessibleTile getPlayerTile() {
    for (int row = 0; row < ROOMSIZE; row++) {
      for (int col = 0; col < ROOMSIZE; col++) {
        if (this.tiles[row][col] instanceof AccessibleTile) {
          AccessibleTile tile = (AccessibleTile) this.tiles[row][col];
          if (tile.hasPlayer()) {
            return tile;
          }
        }
      }
    }
    return null;
  }

  public void rotateRoomClockwise() {
    int x = ROOMSIZE / 2;
    int y = ROOMSIZE - 1;
    for (int i = 0; i < x; i++) {
      for (int j = i; j < y - i; j++) {
        Tile value = this.tiles[i][j];
        this.tiles[i][j] = this.tiles[y - j][i];
        this.tiles[y - j][i] = this.tiles[y - i][y - j];
        this.tiles[y - i][y - j] = this.tiles[j][y - i];
        this.tiles[j][y - i] = value;
      }
    }
  }

}
