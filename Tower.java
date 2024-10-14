import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tower extends Actor
{
    private int shootingCooldown = 50; // Adjust this to change the shooting speed
    private int cooldownTimer = 1;

    public void act() {
        shootAgents();
        cooldownTimer++;
    
        // For debugging: draw a line to the target
        //Agent target = getClosestAgent();
        //if (target != null) {
        //    GreenfootImage bg = getWorld().getBackground();
        //    bg.setColor(Color.RED); // Choose a color that stands out
        //    bg.drawLine(getX(), getY(), target.getX(), target.getY());
        //}
    }

    private void shootAgents() {
        if (cooldownTimer >= shootingCooldown) {
            Agent target = getClosestAgent();
            if (target != null) {
                Rock bullet = new Rock(target.getX(), target.getY());
                getWorld().addObject(bullet, getX(), getY());
                cooldownTimer = 0; // Reset cooldown timer
            }
        }
    }

    private Agent getClosestAgent() {
        Agent closestAgent = null;
        double closestDistance = Double.MAX_VALUE;

        for (Agent agent : getObjectsInRange(1000, Agent.class)) {
            double distance = Math.hypot(agent.getX() - getX(), agent.getY() - getY());
            if (distance < closestDistance) {
                closestAgent = agent;
                closestDistance = distance;
            }
        }

        return closestAgent;
    }
}