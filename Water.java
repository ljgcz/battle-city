import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Animating water that tank cannot cross, but bullet can
 */
public class Water extends Actor
{
    private double iter;//keep track of iterations
    
    /**
     * Water Constructor
     * Initializes iter, set scale for image
     */
    public Water()
    {
        iter = 0;
        getImage().scale(20,20);
    }
    
    /**
     * Act - do whatever the Water wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        iter+=0.03;
        animate();
    }
    
    /**
     * Method animate
     * Animation for water using modulus and setImage
     */
    public void animate()
    {
        setImage("Water-" + ((int)iter % 2 + 1) + ".png");
        getImage().scale(20,20);
    }
}
