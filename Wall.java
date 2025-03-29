import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Brick wall, can be destroyed
 */
public class Wall extends Actor
{
    private int iter;
    
    /**
     * Wall Constructor
     * Initializes iter, sets image scale
     */
    public Wall()
    {
        iter = 0;
        getImage().scale(20, 20);
    }
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        iter++;
        checkTouching();
    }
    
    /**
     * Method checkTouching
     * Removes wall once got hit by bullet
     */
    public void checkTouching()
    {
        if (isTouching(Bullet.class))
        {
            Bullet b = (Bullet)getOneIntersectingObject(Bullet.class);
            if (b != null)
            {
                if (b.getType())
                {
                    Greenfoot.playSound("GunShotEnemy.mp3");//Only play sound if destroyed by player
                }
            }
            removeTouching(Bullet.class);
            getWorld().removeObject(this);
        }
    }
}
