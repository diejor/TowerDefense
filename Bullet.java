import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int speed = 5;
    private int x, y;
    private int targetX, targetY;

    public Bullet(int x, int y, int targetX, int targetY) {
        super();
        this.targetX = targetX;
        this.targetY = targetY;
        pointTowardsTarget();       
    }

    private void pointTowardsTarget() {
        double angle = Math.atan2(targetY - y, targetX - x);
        setRotation((int) Math.toDegrees(angle));
    }
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        move(speed);
    }
}
