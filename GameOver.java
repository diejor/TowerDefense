import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GameOver World displays when the player loses or finishes the game.
 */
public class GameOver extends World
{
    public GameOver(String message)
    {    
        super(600, 400, 1); 
        
        // Initialize background
        GreenfootImage background = new GreenfootImage(getWidth(), getHeight());
        background.setColor(Color.BLACK);
        background.fill();
        setBackground(background);
        
        // Add Game Over Message
        Label gameOverLabel = new Label(message, 36);
        addObject(gameOverLabel, getWidth() / 2, getHeight() / 3);
        
        // Add Restart Button
        Button restartButton = new Button("Restart");
        addObject(restartButton, getWidth() / 2, getHeight() / 2);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(null)) {
            Actor clicked = Greenfoot.getMouseInfo().getActor();
            if (clicked instanceof Button) {
                Button button = (Button) clicked;
                if (button.getText().equals("Restart")) {
                    LevelManager.getInstance().restartLevel(); // Restart the game
                }
                // Add more buttons if needed
            }
        }
    }
}