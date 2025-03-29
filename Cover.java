import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cover here.
 * 
 * The cover screen of the game
 */
public class Cover extends World
{

    /**
     * Constructor for objects of class Cover.
     * Sets image size
     */
    public Cover()
    {
        super(800, 650, 1);  
    }

    /**
     * Method act
     *
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("Enter")) //Starts the game
        {
            Greenfoot.playSound("BattleCity.mp3");//Play sound
            Greenfoot.setWorld(new MyWorld());//Change world
        }
    }
}
