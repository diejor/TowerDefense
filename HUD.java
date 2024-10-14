import greenfoot.*;

/**
 * HUD displays the player's score and remaining lives.
 */
public class HUD extends Actor
{
    private int score;
    private int lives;
    
    public HUD(int initialLives) {
        this.score = 0;
        this.lives = initialLives;
        updateImage();
    }
    
    public void addScore(int points) {
        score += points;
        updateImage();
    }
    
    public void loseLife(int count) {
        lives -= count;
        if (lives < 0) lives = 0;
        updateImage();
        
        if (lives <= 0) {
            // Trigger game over
            LevelManager.getInstance().loadLevel(0); // Assuming 0 is GameOver
        }
    }
    
    private void updateImage() {
        GreenfootImage img = new GreenfootImage(200, 50);
        img.setColor(Color.WHITE);
        img.fill();
        img.setColor(Color.BLACK);
        img.drawRect(0, 0, 199, 49);
        img.drawString("Score: " + score, 10, 20);
        img.drawString("Lives: " + lives, 10, 40);
        setImage(img);
    }
}