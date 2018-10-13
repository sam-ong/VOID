package gameworld;

import java.util.ArrayList;
import java.util.List;

public class Player {

  private static final int HEALTH_BOOST = 20;
  private static final int MAX_HEALTH = 100;

  private AccessibleTile tile;
  private List<Item> inventory;
  private Room room;
  private int health;
  private Direction directionFacing;

  public Player(Room room, AccessibleTile tile, int health, Direction direction) {

    this.room = room;
    this.tile = tile;
    this.inventory = new ArrayList<>();
    this.health = (health > 0) ? health : MAX_HEALTH;
    this.directionFacing = direction;

  }

  public Direction getDirectionFacing() {
    return directionFacing;
  }

  public void setDirectionFacing(Direction directionFacing) {
    this.directionFacing = directionFacing;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void boostHealth() {

    health += HEALTH_BOOST;

    if (health > MAX_HEALTH)
      health = MAX_HEALTH;

  }

  public void loseHealth() {

    if (health > 0)
      health--;
    else
      health = 0;

  }

  public Room getRoom() {
    return room;
  }

  public void moveTile(int dx, int dy) {
    Direction direction = null;
    if(dx < 0) {
      direction = Direction.NORTH;
    } else if(dx > 0){
      direction = Direction.SOUTH;
    } else if(dy < 0){
      direction = Direction.WEST;
    } else if(dy > 0){
      direction = Direction.EAST;
    }

    if (direction == null){
      return;
    }

    if(directionFacing != direction){
      directionFacing = direction;
      return;
    }

    if (room.moveTile(tile, dx, dy) == null) {
      return;
    }
    tile.setPlayer(false);
    tile = (AccessibleTile) room.moveTile(tile, dx, dy);
    tile.setPlayer(true);
  }

  public AccessibleTile getTile() {
    return tile;
  }

  public void setTile(AccessibleTile tile) {
    this.tile = tile;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public List<Item> getInventory() {
    return inventory;
  }

  public void removeItem(Item item) {
    inventory.remove(item);
  }

  public void addItem(Item item) {
    inventory.add(item);
  }

  public void pickUp(Item item) {
    this.inventory.add(item);
  }

}
