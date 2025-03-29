import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Steel here.
 * 
 * Steel, nothing can go through
 */
public class Steel extends Actor
{
    /**
     * Steel Constructor
     * Sets image scale
     */
    public Steel()
    {
        getImage().scale(20,20);
    }
    
    /**
     * Act - do whatever the Steel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkTouching();
    }
    
    /**
     * Method checkTouching
     * Remove bullet once hit on steel wall
     */
    public void checkTouching()
    {
        if (isTouching(Bullet.class))
        {
            removeTouching(Bullet.class);
        }
    }
}
