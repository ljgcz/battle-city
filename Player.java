import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The tank which user controls
 */
public class Player extends Actor
{
    private boolean canMoveU, canMoveD, canMoveL, canMoveR, pressed;//Tracks whether if the tank can move in the four directions
    private int add, iter, lifeCount;//add: speed of the tank, iter: keep track of iterations, lifeCount: the three lives of the tank
    private int bulletCount;//Keep track of the bullet amount
    
    /**
     * Player Constructor
     * Initialized variables, set image
     */
    public Player()
    {
        bulletCount = 50;
        canMoveU = true;canMoveD = true;canMoveL = true;canMoveR = true;
        pressed = false;
        getImage().scale(40, 40);
        iter = 0;
        add = 3;
        lifeCount = 3;
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        iter++;//increases iteration
        move(add);//move based on keypress
        shoot();//shoot based on keypress
        applyBoundary(40, 40);//prevents the tank from levaing game field
        applyBricks(20, 20 ,40, 40);//brick collision checking
        checkTouching();//if hits addup or bullet
    }
    
    /**
     * Method move
     *
     * @param speed A parameter
     * 
     * Moves the tank based on arrow keys and ifMove booleans
     */
    public void move(int speed)
    {
        if (Greenfoot.isKeyDown("Right")){
            setRotation(90);
            if (canMoveR){setLocation(getX()+speed, getY());}
        } else if (Greenfoot.isKeyDown("Left")){
            setRotation(270);
            if (canMoveL){setLocation(getX()-speed, getY());}
        } else if (Greenfoot.isKeyDown("Up")){
            setRotation(0);
            if (canMoveU){setLocation(getX(), getY()-speed);}
        } else if (Greenfoot.isKeyDown("Down")){
            setRotation(180);
            if (canMoveD){setLocation(getX(), getY()+speed);}
        }
    }
    
    /**
     * Method applyBoundary
     *
     * @param TankX A parameter
     * @param TankY A parameter
     * 
     * Prevent the tank from leaving the game field, note that tank width and height need to be considered
     */
    public void applyBoundary(int TankX, int TankY)
    {
        if (getRotation() == 0 && getY() <= 25+TankY/2){
            setLocation(getX(), 25+TankY/2);
        } else if (getRotation() == 180 && getY() >= 625-TankY/2){
            setLocation(getX(), 625-TankY/2);
        } else if (getRotation() == 90 && getX() >= 650-TankX/2){
            setLocation(650-TankX/2, getY());
        } else if (getRotation() == 270 && getX() <= 50+TankX/2){
            setLocation(50+TankX/2, getY());
        }
        
        if (getY() >= 625-TankY/2)
        {
            setLocation(getX(), 625-TankY/2);
        }
        if (getY() <= 25+TankY/2)
        {
            setLocation(getX(), 25+TankY/2);
        }
        if (getX() >= 650-TankX/2)
        {
            setLocation(650-TankX/2, getY());
        }
        if (getX() <= 50+TankX/2)
        {
            setLocation(50+TankX/2, getY());
        }
    }
    
    /**
     * Method shoot
     * Shoots bullet based on key press, boolean, bullet count
     */
    public void shoot()
    {
        if (Greenfoot.isKeyDown("space") && !pressed && bulletCount > 0){//space bar pressed && not long pressing && there are bullet left
            Greenfoot.playSound("GunShotPlayer.mp3");
            getWorld().addObject(new Bullet(getRotation(), 10, true), getX(), getY());
            pressed = true;
            bulletCount--;
            getWorld().showText("" + bulletCount, 725, 210);
        } else if (!Greenfoot.isKeyDown("space")){
            pressed = false;
        }
    }
    
    /**
     * Method applyBricks
     *
     * @param brickWidth A parameter
     * @param brickLength A parameter
     * @param tankWidth A parameter
     * @param tankLength A parameter
     * 
     * Wall collision checking for Wall, Steel, and Water based on wall size and tank size
     */
    public void applyBricks(int brickWidth, int brickLength, int tankWidth, int tankLength)
    { 
        canMoveU = true;canMoveD = true;canMoveL = true;canMoveR = true;
        switch (getRotation())
        {
            case 0:
                if (getOneObjectAtOffset(0, -(tankLength)/2, Wall.class)!=null||getOneObjectAtOffset(0, -(tankLength)/2, Steel.class)!=null||getOneObjectAtOffset(0, -(tankLength)/2, Water.class)!=null){
                    setLocation(getX(), getY()+add);
                    canMoveU = false;
                }
                if (getOneObjectAtOffset((tankWidth)/2-3, 0, Wall.class)!=null||getOneObjectAtOffset((tankWidth)/2-3, 0, Steel.class)!=null||getOneObjectAtOffset((tankWidth)/2-3, 0, Water.class)!=null){
                    setLocation(getX()-add, getY());
                    canMoveU = false;
                }
                if (getOneObjectAtOffset(-(tankWidth)/2+3, 0, Wall.class)!=null||getOneObjectAtOffset(-(tankWidth)/2+3, 0, Steel.class)!=null||getOneObjectAtOffset(-(tankWidth)/2+3, 0, Water.class)!=null){
                    setLocation(getX()+add, getY());
                    canMoveU = false;
                }
                break;
            case 90:
                if (getOneObjectAtOffset((tankWidth)/2, 0, Wall.class)!=null||getOneObjectAtOffset((tankWidth)/2, 0, Steel.class)!=null||getOneObjectAtOffset((tankWidth)/2, 0, Water.class)!=null){
                    setLocation(getX()-add, getY());
                    canMoveR = false;
                }
                if (getOneObjectAtOffset(0, -(tankLength)/2+3, Wall.class)!=null||getOneObjectAtOffset(0, -(tankLength)/2+3, Steel.class)!=null||getOneObjectAtOffset(0, -(tankLength)/2+3, Water.class)!=null){
                    setLocation(getX(), getY()+add);
                    canMoveR = false;
                }
                if (getOneObjectAtOffset(0, (tankLength)/2-3, Wall.class)!=null||getOneObjectAtOffset(0, (tankLength)/2-3, Steel.class)!=null||getOneObjectAtOffset(0, (tankLength)/2-3, Water.class)!=null){
                    setLocation(getX(), getY()-add);
                    canMoveR = false;
                }
                break;
            case 180:
                if (getOneObjectAtOffset(0, (tankLength)/2, Wall.class)!=null||getOneObjectAtOffset(0, (tankLength)/2, Steel.class)!=null||getOneObjectAtOffset(0, (tankLength)/2, Water.class)!=null){
                    setLocation(getX(), getY()-add);
                    canMoveD = false;
                }
                if (getOneObjectAtOffset((tankWidth)/2-3, 0, Wall.class)!=null||getOneObjectAtOffset((tankWidth)/2-3, 0, Steel.class)!=null||getOneObjectAtOffset((tankWidth)/2-3, 0, Water.class)!=null){
                    setLocation(getX()-add, getY());
                    canMoveD = false;
                }
                if (getOneObjectAtOffset(-(tankWidth)/2+3, 0, Wall.class)!=null||getOneObjectAtOffset(-(tankWidth)/2+3, 0, Steel.class)!=null||getOneObjectAtOffset(-(tankWidth)/2+3, 0, Water.class)!=null){
                    setLocation(getX()+add, getY());
                    canMoveD = false;
                }
                break;
            case 270:
                if (getOneObjectAtOffset(-(tankWidth)/2, 0, Wall.class)!=null||getOneObjectAtOffset(-(tankWidth)/2, 0, Steel.class)!=null||getOneObjectAtOffset(-(tankWidth)/2, 0, Water.class)!=null){
                    setLocation(getX()+add, getY());
                    canMoveL = false;
                }
                if (getOneObjectAtOffset(0, (tankLength)/2-3, Wall.class)!=null||getOneObjectAtOffset(0, (tankLength)/2-3, Steel.class)!=null||getOneObjectAtOffset(0, (tankLength)/2-3, Water.class)!=null){
                    setLocation(getX(), getY()-add);
                    canMoveL = false;
                }
                if (getOneObjectAtOffset(0, -(tankLength)/2+3, Wall.class)!=null||getOneObjectAtOffset(0, -(tankLength)/2+3, Steel.class)!=null||getOneObjectAtOffset(0, -(tankLength)/2+3, Water.class)!=null){
                    setLocation(getX(), getY()+add);
                    canMoveL = false;
                }
                break;
        }      
    }

    
    /**
     * Method checkTouching
     * Decreases life if bullet hit, change life display
     */
    public void checkTouching()
    {
        Bullet b = (Bullet)getOneIntersectingObject(Bullet.class);
        if (b != null)
        {
            if (!b.getType())
            {
                lifeCount--;
                switch (lifeCount)
                {
                    case 1:
                        getWorld().addObject(new Life('L'), 675, 450);
                        getWorld().addObject(new Life('N'), 725, 450);
                        getWorld().addObject(new Life('N'), 775, 450);
                        break;
                    case 2:
                        getWorld().addObject(new Life('L'), 675, 450);
                        getWorld().addObject(new Life('L'), 725, 450);
                        getWorld().addObject(new Life('N'), 775, 450);
                        break;
                    case 3:
                        getWorld().addObject(new Life('L'), 675, 450);
                        getWorld().addObject(new Life('L'), 725, 450);
                        getWorld().addObject(new Life('L'), 775, 450);
                        break;
                    default:
                        getWorld().addObject(new Life('N'), 675, 450);
                        getWorld().addObject(new Life('N'), 725, 450);
                        getWorld().addObject(new Life('N'), 775, 450);
                }
                Greenfoot.playSound("DeadPlayer.mp3");
                removeTouching(Bullet.class);
                setLocation(getWorld().getWidth()/2-120, getWorld().getHeight()/2+275);
                setRotation(0);
                if (lifeCount <= 0)
                {
                    Greenfoot.playSound("Lost.mp3");
                    getWorld().showText("GAME OVER", getWorld().getWidth()/2-50, getWorld().getHeight()/2);
                    Greenfoot.stop(); //Ends the game once no life left
                }
            }
        }
        
        if (isTouching(AddUp.class)) //Add 15 bullets once hit add-up
        {
            Greenfoot.playSound("GetBullet.mp3");
            bulletCount += 15;
            getWorld().showText("" + bulletCount, 725, 210);
            removeTouching(AddUp.class);
        }
    }
}
