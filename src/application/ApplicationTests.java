package application;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test cases for the Application package
 *
 * @author Annisha Akosah 300399598
 */

public class ApplicationTests {

  /**
   * Attempts to launch the start menu for 1 second
   * @throws InterruptedException
   */
  @Test
  public void launchStartMenu() throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        new JFXPanel(); // Initializes the JavaFx Platform
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
            try {
              GUI gui = new GUI();
              Stage stage = new Stage();
              gui.start(stage);
            }
            catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
      }
    });
    thread.start(); // Initialize the thread
    Thread.sleep(1000); // gui window stays up for 1 seconds
  }


  /**
   * Attempts to launch the levels menu for 1 second
   * @throws InterruptedException
   */
  @Test
  public void launchLevelsScreen() throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        new JFXPanel(); // Initializes the JavaFx Platform
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
            try {
              GUI gui = new GUI();
              Stage stage = new Stage();
              gui.start(stage);
              gui.getWindow().setScene(gui.createLevelsScreen(stage));
            }
            catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
      }
    });
    thread.start();// Initialize the thread
    Thread.sleep(1000); //gui window stays up for 1 second
  }


  /**
   * Attempts to launch the game scene with no file given to it
   * @throws InterruptedException
   */
  @Test
  public void launchGameWithNoFile() throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        new JFXPanel(); // Initializes the JavaFx Platform
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
            try {
              GUI gui = new GUI();
              Stage stage = new Stage();
              gui.start(stage);
              gui.getWindow().setScene(gui.createGameScene(stage));
              //assertEquals(gui.currentGame, null); // no game has been parsed yet
            }
            catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
      }
    });
    thread.start();// Initialize the thread
    Thread.sleep(1000); //gui window stays up for 1 second
  }

  /**
   * Attempts to launch an Easy game with a provided file
   * @throws InterruptedException
   */
  @Test
  public void launchEasyGame() throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        new JFXPanel(); // Initializes the JavaFx Platform
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
            try {
              GUI gui = new GUI();
              Stage stage = new Stage();
              gui.start(stage);
              gui.startNewEasyGame(stage);
             // gui.start(stage);
              //gui.getWindow().setScene(gui.createGameScene(stage));
            }
            catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
      }
    });
    thread.start();// Initialize the thread
    Thread.sleep(1000); //gui window stays up for 1 second
  }

  /**
   * Attempts to launch an Medium game with a provided file
   * @throws InterruptedException
   */
  @Test
  public void launchMedGame() throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        new JFXPanel(); // Initializes the JavaFx Platform
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
            try {
              GUI gui = new GUI();
              Stage stage = new Stage();
              gui.start(stage);
              gui.startNewMedGame(stage);
            }
            catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
      }
    });
    thread.start();// Initialize the thread
    Thread.sleep(1000); //gui window stays up for 1 second
  }

  /**
   * Attempts to launch an Hard game with a provided file
   * @throws InterruptedException
   */
  @Test
  public void launchHardGame() throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        new JFXPanel(); // Initializes the JavaFx Platform
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
            try {
              GUI gui = new GUI();
              Stage stage = new Stage();
              gui.start(stage);
              gui.startNewHardGame(stage);
            }
            catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
      }
    });
    thread.start();// Initialize the thread
    Thread.sleep(1000); //gui window stays up for 1 second
  }


  /**
   * Attempts to launch the help dialog within a game
   * @throws InterruptedException
   */
  @Test
  public void launchHelpDialog() throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        new JFXPanel(); // Initializes the JavaFx Platform
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
            try {
              GUI gui = new GUI();
              Stage stage = new Stage();
              gui.start(stage);
              gui.startNewEasyGame(stage);
              gui.displayHelp();
            }
            catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
      }
    });
    thread.start();// Initialize the thread
    Thread.sleep(1000); //gui window stays up for 1 second
  }

  /**
   * Attempts to launch a confirm quit dialog within a game
   * @throws InterruptedException
   */
  @Test
  public void launchConfirmQuitDialog() throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        new JFXPanel(); // Initializes the JavaFx Platform
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
            try {
              GUI gui = new GUI();
              Stage stage = new Stage();
              gui.start(stage);
              gui.confirmExit();
            }
            catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
      }
    });
    thread.start();// Initialize the thread
    Thread.sleep(1000); //gui window stays up for 1 second
  }

  /**
   * Attempts to display the win/lose scene
   * @throws InterruptedException
   */
  @Test
  public void displayWinLoseScene() throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        new JFXPanel(); // Initializes the JavaFx Platform
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
            try {
              GUI gui = new GUI();
              Stage stage = new Stage();
              gui.start(stage);
              gui.getWindow().setScene(gui.createWinLoseScene("win"));
            }
            catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
      }
    });
    thread.start();// Initialize the thread
    Thread.sleep(1000); //gui window stays up for 1 second
  }

  /**
   * Attempts to load a game
   * @throws InterruptedException
   */
  @Test
  public void loadGame() throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        new JFXPanel(); // Initializes the JavaFx Platform
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
            try {
              GUI gui = new GUI();
              Stage stage = new Stage();
              gui.start(stage);
              gui.loadFile(stage);
            }
            catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
      }
    });
    thread.start();// Initialize the thread
    Thread.sleep(1000); //gui window stays up for 1 second
  }

  /**
   * Attempts to save a current game state
   * @throws InterruptedException
   */
  @Test
  public void saveGame() throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        new JFXPanel(); // Initializes the JavaFx Platform
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
            try {
              GUI gui = new GUI();
              Stage stage = new Stage();
              gui.start(stage);
              gui.startNewEasyGame(stage); // start a new game
              //gui.getCurrentGame().getPlayer().

              gui.saveFile(stage); // save dialog should appear
            }
            catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
      }
    });
    thread.start();// Initialize the thread
    Thread.sleep(1000); //gui window stays up for 1 second
  }

  /**
   * Tests that toggle buttons that should be toggled off, is off
   * as the player initially has no items in their inventory
   * @throws InterruptedException
   */
  @Test
  public void testToggleButtons() throws InterruptedException {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        new JFXPanel(); // Initializes the JavaFx Platform
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
            try {
              GUI gui = new GUI();
              Stage stage = new Stage();
              gui.start(stage);
              gui.startNewEasyGame(stage); // start a new game
              ToggleButton button = gui.inventoryButtons.get("GoldenCoin");
              assertTrue(button.isDisabled()); // button should be disabled since player doesn't have coin
            }
            catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
      }
    });
    thread.start();// Initialize the thread
    Thread.sleep(1000); //gui window stays up for 1 second
  }




}
