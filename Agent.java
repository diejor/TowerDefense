import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Agent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Agent extends Actor
{
    private int SPEED = 3;
    
    /**
     * Act - do whatever the Agent wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        processMovement();
    }
    
    private void processMovement() {
        int x = getX();
        int y = getY();
    
        if (Greenfoot.isKeyDown("a")) {
            setLocation(x - SPEED, y);
        } if (Greenfoot.isKeyDown("w")) {
            setLocation(x, y - SPEED);
        } if (Greenfoot.isKeyDown("d")) {
            setLocation(x + SPEED, y);
        } if (Greenfoot.isKeyDown("s")) {
            setLocation(x, y + SPEED);
        }
    }
}
