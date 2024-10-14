import greenfoot.*;

public class Agent extends Actor
{
    private int speed = 1;
    private int health = 3; // Example health value
    
    public Agent() {

    }

    public void act()
    {
        move(speed);
        // Add more behaviors like pathfinding, attacking, etc.
        
        // Example: Remove agent if it reaches the edge
        if (isAtEdge()) {
            getWorld().removeObject(this);
            // Optionally, deduct player's life or other penalties
            if (getWorld() instanceof FirstLevel) {
                HUD hud = (HUD) getWorld().getObjects(HUD.class).get(0);
                hud.loseLife(1);
            }
        }
    }
    
    /**
     * Reduces the agent's health when hit by a bullet.
     */
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            getWorld().removeObject(this);
            // Optionally, increase player's score
            if (getWorld() instanceof FirstLevel) {
                HUD hud = (HUD) getWorld().getObjects(HUD.class).get(0);
                hud.addScore(10); // Example: Add 10 points per agent killed
            }
        }
    }
}