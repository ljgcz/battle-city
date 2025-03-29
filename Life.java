import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Life here.
 * 
 * Life display (max 3)
 */
public class Life extends Actor
{
    /**
     * Life Constructor
     *
     * @param type A parameter
     * 
     * Take in argument, determines whether if life or no life
     */
    public Life(char type)
    {
        if (type == 'L')
        {
            setImage("Life.png");
        }
        else if (type == 'N')
        {
            setImage("noLife.png");
        }
        getImage().scale(30,30); //sets scale
    }
    /**
     * Act - do whatever the Life wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
