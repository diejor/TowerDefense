import greenfoot.*;

/**
 * Label is a simple class to display text.
 */
public class Label extends Actor
{
    private String text;
    private GreenfootImage image;
    
    public Label(String text, int fontSize) {
        this.text = text;
        image = new GreenfootImage(text, fontSize, Color.WHITE, new Color(0,0,0,0));
        setImage(image);
    }
}