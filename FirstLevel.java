import greenfoot.*;

public class FirstLevel extends World
{
    private LevelManager levelManager;
    private HUD hud;
    
    public FirstLevel()
    {    
        super(600, 400, 1); 
        
        levelManager = LevelManager.getInstance();
        
        // Initialize background
        GreenfootImage background = new GreenfootImage(getWidth(), getHeight());
        background.setColor(Color.DARK_GRAY);
        background.fill();
        setBackground(background);
        
        // Add Tower
        Tower tower = new Tower();
        addObject(tower, 150, 150);
        
        // Add Agent(s)
        Agent agent = new Agent();
        addObject(agent, 50, 50);
        
        // Add HUD
        if (getObjects(HUD.class).isEmpty()) {
            hud = new HUD(5); // Starting with 5 lives
            addObject(hud, getWidth() - 100, 25); // Position at top-right corner
        }
    }
    
    public void act()
    {
        // Example: Check for level completion
        if (isLevelComplete()) {
            levelManager.nextLevel(); // Move to next level
        }
    }
    
    private boolean isLevelComplete() {
        // Define level completion criteria
        return getObjects(Agent.class).isEmpty();
    }
}