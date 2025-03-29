import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AddUp here.
 * 
 * Gives the tank more bullet
 */
public class AddUp extends Actor
{
    private int iter;
    
    /**
     * AddUp Constructor
     * Initialize iter, set image size
     */
    public AddUp()
    {
        iter = 0;
        getImage().scale(40, 40);
    }
    /**
     * Act - do whatever the AddUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        countDown();
    }
    
    /**
     * Method countDown
     * Displays the add up object for only 500 iterations. Remove it once reach 500
     */
    public void countDown()
    {
        iter++;
        if (iter == 500)
        {
            getWorld().removeObject(this);
        }
    }
}
