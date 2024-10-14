import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * LevelManager handles the transition between different levels and manages the game state.
 * It follows the Singleton design pattern to ensure only one instance exists throughout the game.
 */
public class LevelManager
{
    // Singleton instance
    private static LevelManager instance = null;

    // Current level number
    private int currentLevel;

    // Reference to the main menu world
    private World mainMenu;

    // Private constructor to prevent instantiation
    private LevelManager() {
        currentLevel = 0; // 0 represents the Main Menu
        mainMenu = new MainMenu();
    }

    /**
     * Returns the single instance of LevelManager.
     * If it doesn't exist, it creates one.
     *
     * @return The singleton instance of LevelManager.
     */
    public static LevelManager getInstance() {
        if (instance == null) {
            instance = new LevelManager();
        }
        return instance;
    }

    /**
     * Starts the game by setting the world to the Main Menu.
     */
    public void startGame() {
        Greenfoot.setWorld(mainMenu);
    }

    /**
     * Loads the specified level based on the level number.
     *
     * @param level The level number to load.
     */
    public void loadLevel(int level) {
        World newWorld;
        switch(level) {
            case 1:
                newWorld = new FirstLevel();
                break;
            // Add more cases for additional levels as needed
            default:
                // If the level number doesn't match any case, display a message and return to Main Menu
                System.out.println("Level " + level + " is not implemented yet.");
                newWorld = mainMenu; // Optionally, create a GameOver or PlaceholderWorld
                break;
        }
        Greenfoot.setWorld(newWorld);
        currentLevel = level;
    }

    /**
     * Advances the game to the next level.
     * If there are no more levels, it can transition to a GameOver or Victory screen.
     */
    public void nextLevel() {
        loadLevel(currentLevel + 1);
    }

    /**
     * Restarts the current level.
     */
    public void restartLevel() {
        loadLevel(currentLevel);
    }

    /**
     * Returns the current level number.
     *
     * @return The current level number.
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Resets the LevelManager to its initial state.
     * Useful for restarting the entire game.
     */
    public void reset() {
        currentLevel = 0;
        startGame();
    }
}
