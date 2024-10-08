import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower extends Actor
{
    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        shootAgents();
    }

    private void shootAgents() {
        for (Agent agent : getObjectsInRange(100, Agent.class)) {
            Rock bullet = new Rock(getX(), getY(), agent.getX(), agent.getY());
            getWorld().addObject(bullet, getX(), getY());
        }
    }
}
