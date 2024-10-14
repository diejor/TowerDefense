import greenfoot.*;

/**
 * Button is an interactive actor that can be clicked.
 */
public class Button extends Actor
{
    private String text;
    private GreenfootImage image;
    
    public Button(String text) {
        this.text = text;
        image = new GreenfootImage(text, 24, Color.WHITE, new Color(0,0,0,0));
        setImage(image);
    }
    
    public String getText() {
        return text;
    }
}