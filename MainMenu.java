import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MainMenu is the initial World that displays the game title and options to start the game.
 */
public class MainMenu extends World
{
    private GreenfootImage background;
    
    /**
     * Constructor for objects of class MainMenu.
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        // Initialize background
        background = new GreenfootImage(getWidth(), getHeight());
        background.setColor(Color.BLACK);
        background.fill();
        setBackground(background);
        
        // Add Title
        Label title = new Label("Tower Defense", 48);
        addObject(title, getWidth() / 2, getHeight() / 3);
        
        // Add Start Button
        Button startButton = new Button("Start Game");
        addObject(startButton, getWidth() / 2, getHeight() / 2);
    }
    
    /**
     * Act method to handle user interactions.
     */
    public void act()
    {
        // Check if the start button is clicked
        if (Greenfoot.mouseClicked(null)) {
            Actor clicked = Greenfoot.getMouseInfo().getActor();
            if (clicked instanceof Button) {
                Button button = (Button) clicked;
                if (button.getText().equals("Start Game")) {
                    LevelManager.getInstance().loadLevel(1); // Load Level 1
                }
                // Future buttons can be handled here
            }
        }
    }
}
