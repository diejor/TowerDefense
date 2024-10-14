import greenfoot.*;

public class Bullet extends Actor
{
    private int speed = 5;
    private int targetX, targetY;

    public Bullet(int targetX, int targetY) {
        this.targetX = targetX;
        this.targetY = targetY;
    }

    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        turnTowards(targetX, targetY);
    }

    public void act()
    {
        move(speed);
        
        // Check if the bullet has reached the edge of the world
        if (isAtEdge()) {
            getWorld().removeObject(this);
            return; // Exit the act method early since the bullet is removed
        }
        
        // Check for collision with an Agent
        Agent hitAgent = (Agent) getOneIntersectingObject(Agent.class);
        if (hitAgent != null) {
            hitAgent.takeDamage(1); // Assume each bullet does 1 damage
            getWorld().removeObject(this);
            // Optionally, update score or trigger other events
        }
    }
}