import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Appear here.
 * 
 * Appear animation for tanks
 */
public class Appear extends Actor
{
    private double iter;
    private char type;
    private int enemyCount;
    
    /**
     * Appear Constructor
     *
     * @param thing A parameter
     * 
     * Obtain type of obejct, initializes iter, set image size
     */
    public Appear(char thing)
    {
        type = thing;
        iter = 0;
        getImage().scale(40, 40);
    }
    /**
     * Act - do whatever the Appear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (iter > 11)
        {
            if (type == 'P'){
                getWorld().addObject(new Player(), getX(), getY()); //Add a new player if type 'P'
            } else if (type == 'E'){
                getWorld().addObject(new Enemy(), getX(), getY()); //Add a new enemy if type 'E'
            }
            getWorld().removeObject(this); //Removes animation
        }
        iter+=0.3; //increases iter
        animate();
    }
    
    /**
     * Method animate
     * Animation for apppear using modulus and setImage
     */
    public void animate()
    {
        setImage("appear-" + ((int)iter % 11 + 1) + ".png");
        getImage().scale(40,40);
    }
}
