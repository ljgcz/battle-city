import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * The bullet which player and enemy shots
 */
public class Bullet extends Actor
{
    private int rotation;
    private static int speed;
    private boolean isInWorld, ifByPlayer;//If created by player or enmey
    
    /**
     * Bullet Constructor
     * Sets bullet speed, sets image rotation and scale
     */
    public Bullet()
    {
        speed = 5;
        isInWorld = true;
        setRotation(270);
        getImage().scale(15, 10);
    }
    
    /**
     * Bullet Constructor
     *
     * @param rot A parameter
     * @param sped A parameter
     * @param type A parameter
     * 
     * Obtains shooter type, speed, rotation degree
     */
    public Bullet(int rot, int sped, boolean type)
    {
        ifByPlayer = type;
        rotation = rot;
        speed = sped;
        isInWorld = true;
        setRotation(270+rot);
        getImage().scale(15, 10);
    }
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkTouching();
        go();
    }    
    
    /**
     * Method go
     * Moves the bullet with game field edge checking
     */
    public void go()
    {
        switch (rotation)
        {
            case 0:
                if (getY() <= 25){
                    getWorld().removeObject(this);
                    isInWorld = false;
                } else {
                    setLocation(getX(), getY() - speed);
                }
                break;
            case 90:
                if (getX() >= 650){
                    getWorld().removeObject(this);
                    isInWorld = false;
                } else {
                    setLocation(getX() + speed, getY());
                }
                break;
            case 180:
                if (getY() >= 625){
                    getWorld().removeObject(this);
                    isInWorld = false;
                } else {
                    setLocation(getX(), getY() + speed);
                }
                break;
            case 270:
                if (getX() <= 50){
                    getWorld().removeObject(this);
                    isInWorld = false;
                } else {
                    setLocation(getX() - speed, getY());
                }
                break;
        }
    }
    
    /**
     * Method getType
     *
     * @return The return value
     * 
     * Accessor to return type of shooter
     */
    public boolean getType()
    {
        return ifByPlayer;
    }
    
    /**
     * Method checkTouching
     * Removes the enemy bullet if a player bullet hits an enemy bullet
     */
    public void checkTouching()
    {
        Bullet b = (Bullet)getOneIntersectingObject(Bullet.class);
        if (b != null)
        {
            if ((b.getType() && !this.getType())||(!b.getType() && this.getType())) //two cases
            {
                removeTouching(Bullet.class);
            }
        }
    }
}
