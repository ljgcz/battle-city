import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Eagle here.
 * 
 * The egale which player must defend
 */
public class Eagle extends Actor
{
    /**
     * Eagle Constructor
     * Sets image scale
     */
    public Eagle()
    {
        getImage().scale(40, 40);
    }
    /**
     * Act - do whatever the Eagle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkTouching();
    }    
    
    /**
     * Method checkTouching
     * Ends the game once got hit
     */
    public void checkTouching()
    {
        if (isTouching(Bullet.class))
        {
            Greenfoot.playSound("Lost.mp3");
            getWorld().showText("GAME OVER", getWorld().getWidth()/2-50, getWorld().getHeight()/2);
            setImage("Destroyed.png");
            getImage().scale(40, 40);
            Greenfoot.stop();
        }
    }
}
