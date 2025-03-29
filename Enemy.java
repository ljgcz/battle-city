import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * Enemy class (silver tanks)
 */
public class Enemy extends Actor
{
    private boolean canMoveR, canMoveU, canMoveD, canMoveL, shot;
    private int add, iter, life;
    
    /**
     * Enemy Constructor
     * Initializes image, speed, rotation, image size
     */
    public Enemy()
    {
        canMoveR = true; canMoveU = true; canMoveD = true; canMoveL = true;shot = false;
        add = 2; iter = 0;
        setRotation(90 * changeDirection());
        switch (Greenfoot.getRandomNumber(4)+1)
        {
            case 1:
                setImage("Enemy1.png");
                break;
            case 2:
                setImage("Enemy2.png");
                add = 4;
                break; 
            case 3:
                setImage("Enemy3.png");
                break;
            case 4:
                setImage("Enemy4.png");
                break;
        }
        getImage().scale(40,40);
    }
    /**
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        iter++; //Increases iteration
        shootMoveClear(); //Shoot bullet, move tank, upper bound of iter
        move(add); //Move based on speed
        applyBoundary(40, 40); //Keeps the tank inside game field
        applyBricks(20, 20 ,40, 40); //Wall collision checking
        checkTouching(); //Removes once hit bullet
    }    
    
    /**
     * Method move
     *
     * @param speed A parameter
     * 
     * Moves the enemy tank based on a given speed and current direction
     */
    public void move(int speed)
    {
        switch (getRotation())
        {
            case 0:
                if (canMoveU)
                {
                    setLocation(getX(), getY()-speed);
                }
                break;
            case 90:
                if (canMoveR)
                {
                    setLocation(getX()+speed, getY());
                }
                break;
            case 180:
                if (canMoveD)
                {
                    setLocation(getX(), getY()+speed);
                }
                break;
            case 270:
                if (canMoveL)
                {
                    setLocation(getX()-speed, getY());
                }
                break;
        }
    }
    
    /**
     * Method applyBoundary
     *
     * @param TankX A parameter
     * @param TankY A parameter
     * 
     * Keeps the tank inside game field
     */
    public void applyBoundary(int TankX, int TankY)
    {
        if (getRotation() == 0 && getY() <= 25+TankY/2){
            canMoveU = false;
            setLocation(getX(), 25+TankY/2);
            turn(90 * changeDirection());
        } else if (getRotation() == 180 && getY() >= 625-TankY/2){
            canMoveD = false;
            setLocation(getX(), 625-TankY/2);
            turn(90 * changeDirection());
        } else if (getRotation() == 90 && getX() >= 650-TankX/2){
            canMoveR = false;
            setLocation(650-TankX/2, getY());
            turn(90 * changeDirection());
        } else if (getRotation() == 270 && getX() <= 50+TankX/2){
            canMoveL = false;
            setLocation(50+TankX/2, getY());
            turn(90 * changeDirection());
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
                    if (Greenfoot.getRandomNumber(10) < 5){getWorld().addObject(new Bullet(getRotation(), 10, false), getX(), getY());}
                    turn(90 * changeDirection());
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
                    if (Greenfoot.getRandomNumber(10) < 5){getWorld().addObject(new Bullet(getRotation(), 10, false), getX(), getY());}
                    turn(90 * changeDirection());
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
                    if (Greenfoot.getRandomNumber(10) < 5){getWorld().addObject(new Bullet(getRotation(), 10, false), getX(), getY());}
                    turn(90 * changeDirection());
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
                    if (Greenfoot.getRandomNumber(10) < 5){getWorld().addObject(new Bullet(getRotation(), 10, false), getX(), getY());}
                    turn(90 * changeDirection());
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
     * Method shootMoveClear
     * As described below
     */
    public void shootMoveClear()
    {
        if (iter % (100) == 0 && !shot){ //Shoots a bullet every 100 iterations, ensure no continuous shooting
            getWorld().addObject(new Bullet(getRotation(), 10, false), getX(), getY());
            shot = true;
        } else {
            shot = false;
        }
        if (iter % (Greenfoot.getRandomNumber(20)+50) == 0)//Changes direction randomly
        {
            turn(90 * changeDirection());
        }
        if (iter == 200)//Makes iter no larger than 200, prevent overflow error
        {
            iter = 0;
        }
    }
    
    /**
     * Method changeDirection
     *
     * @return The return value
     * 
     * Randomly generates an integer between 0 and 3
     */
    public int changeDirection()
    {
        return Greenfoot.getRandomNumber(100) % 4;
    }

    /**
     * Method checkTouching
     * Removes enemy tank once got hit
     */
    public void checkTouching()
    {
        Bullet b = (Bullet)getOneIntersectingObject(Bullet.class);
        if (b != null)
        {
            if (b.getType())
            {
                Greenfoot.playSound("DeadEnemy.mp3");
                getWorld().removeObject(this);
            }
        }
    }
}
