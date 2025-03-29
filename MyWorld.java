import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world class:
 * add up generating, initializes maps, sets screen
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * Initializes the world
     */
    private int iter;
    private int score;
    public MyWorld()
    { 
        //Initializes the screen
        super(800, 650, 1); 
        setPaintOrder(AddUp.class, Appear.class, Plant.class, Player.class, Enemy.class, Bullet.class, Water.class, Steel.class, Wall.class, Eagle.class, Life.class, Gamefield.class, Background.class);
        addObject(new Background(), getWidth()/2, getHeight()/2); 
        addObject(new Gamefield(), getWidth()/2-50, getHeight()/2);
        
        //Add the player
        addObject(new Appear('P'), getWidth()/2-120, getHeight()/2+275);
        
        //Initializes the variables
        iter = 0;
        score = 0;
        
        //Add the first enemy
        addObject(new Appear('E'), Greenfoot.getRandomNumber(500)+75, 50);
        
        //Construct walls
        constructWalls();
        
        //Initializes text display
        showText("Life left", 725, 410);
        showText("Level", 725, 300);
        showText("" + 0, 725, 330);
        showText("Bullet left", 725, 180);
        showText("" + 50, 725, 210);
    }
    
    /**
     * Method act
     */
    public void act()
    {
        spawnAddUp();//Spawns bullet add-up blocks
        
        //Wins the game when reaches level 35
        if (score == 35)
        {
            Greenfoot.playSound("Win.mp3");
            showText("YOU WON", getWidth()/2-50, getHeight()/2);
            Greenfoot.stop();
        }
        
        iter++;//Increases iteration
        showText("" + score, 725, 330);//Updates level (score)
        
        //Generate enemies based on iterations. Note that it will generate faster as iter gets cloer to 35
        if (iter % (350 - score * 10 + 1) == 0)
        {
            addObject(new Appear('E'), Greenfoot.getRandomNumber(500)+75, (50 + 40 * (Greenfoot.getRandomNumber(2)+1)));
            addObject(new Appear('E'), Greenfoot.getRandomNumber(500)+75, (50 + 40 * (Greenfoot.getRandomNumber(2)+1)));
            addObject(new Appear('E'), Greenfoot.getRandomNumber(500)+75, (50 + 40 * (Greenfoot.getRandomNumber(2)+1)));
            addObject(new Appear('E'), Greenfoot.getRandomNumber(500)+75, (50 + 40 * (Greenfoot.getRandomNumber(2)+1)));
            addObject(new Appear('E'), Greenfoot.getRandomNumber(500)+75, (50 + 40 * (Greenfoot.getRandomNumber(2)+1)));
        }
        
        //Level increases every 200 iterations
        if (iter % 200 == 0)
        {
            score++;
            showText("" + score, 725, 330);
        }
        
        //Sets upper bound for iter, prevents overflow error
        if (iter == 1000)
        {
            iter = 0;
        }
    }
    
    /**
     * Method constructWalls
     * Construct the map of the game
     */
    public void constructWalls()
    {
        //Plant
        fby4Plant(110, 500, 20);
        fby4Plant(150, 500, 20);
        fby4Plant(190, 500, 20);
        fby4Plant(430, 500, 20);
        fby4Plant(470, 500, 20);
        fby4Plant(510, 500, 20);
        fby4Plant(590, 500, 20);
        
        fby4Plant(70, 460, 20);
        fby4Plant(230, 460, 20);
        fby4Plant(270, 460, 20);
        fby4Plant(310, 460, 20);
        fby4Plant(350, 460, 20);
        fby4Plant(390, 460, 20);
        fby4Plant(550, 460, 20);
        fby4Plant(630, 460, 20);
        
        fby4Plant(590, 380, 20);
        fby4Plant(630, 380, 20);
        
        fby4Plant(630, 340, 20);
        
        fby4Plant(590, 300, 20);
        
        fby4Plant(590, 260, 20);
        
        fby4Plant(110, 220, 20);        
        fby4Plant(150, 220, 20);
        fby4Plant(190, 220, 20);
        fby4Plant(430, 220, 20);        
        fby4Plant(470, 220, 20);
        fby4Plant(510, 220, 20);
        fby4Plant(590, 220, 20);
        
        fby4Plant(70, 180, 20);
        fby4Plant(230, 180, 20);
        fby4Plant(310, 180, 20);
        fby4Plant(390, 180, 20);
        fby4Plant(550, 180, 20);
    
        //Water
        fby4Water(110, 460, 20);
        fby4Water(150, 460, 20);
        fby4Water(190, 460, 20);
        fby4Water(430, 460, 20);
        fby4Water(470, 460, 20);
        fby4Water(510, 460, 20);
        fby4Water(590, 460, 20);
        
        fby4Water(190, 420, 20);
        fby4Water(230, 420, 20);
        fby4Water(270, 420, 20);
        fby4Water(350, 420, 20);
        fby4Water(390, 420, 20);
        fby4Water(430, 420, 20);
        fby4Water(590, 420, 20);
        fby4Water(630, 420, 20);
        
        fby4Water(230, 380, 20);
        fby4Water(390, 380, 20);
        
        fby4Water(70, 340, 20);
        fby4Water(550, 340, 20);
        fby4Water(590, 340, 20);
        
        fby4Water(70, 300, 20);
        fby4Water(110, 300, 20);
        fby4Water(150, 300, 20);
        
        fby4Water(470, 300, 20);
        fby4Water(510, 300, 20);
        fby4Water(550, 300, 20);
        
        //Brick
        fby4Wall(70, 420, 20);
        fby4Wall(110, 420, 20);        
        fby4Wall(150, 420, 20);
        fby4Wall(310, 420, 20);
        fby4Wall(470, 420, 20);
        fby4Wall(510, 420, 20);
        fby4Wall(550, 420, 20);
        
        fby4Wall(70, 380, 20);
        fby4Wall(110, 380, 20);
        fby4Wall(150, 380, 20);
        fby4Wall(190, 380, 20);
        fby4Wall(270, 380, 20);
        fby4Wall(310, 380, 20);
        fby4Wall(350, 380, 20);
        fby4Wall(430, 380, 20);
        fby4Wall(470, 380, 20);
        fby4Wall(510, 380, 20);
        fby4Wall(550, 380, 20);
        
        fby4Wall(110, 340, 20);
        fby4Wall(150, 340, 20);
        fby4Wall(190, 340, 20);
        fby4Wall(230, 340, 20);
        fby4Wall(270, 340, 20);
        fby4Wall(310, 340, 20);
        fby4Wall(350, 340, 20);
        fby4Wall(390, 340, 20);
        fby4Wall(430, 340, 20);
        fby4Wall(470, 340, 20);
        fby4Wall(510, 340, 20);
        
        fby4Wall(190, 300, 20);
        fby4Wall(230, 300, 20);
        fby4Wall(270, 300, 20);
        fby4Wall(310, 300, 20);
        fby4Wall(350, 300, 20);
        fby4Wall(390, 300, 20);
        fby4Wall(430, 300, 20);
        
        fby4Wall(70, 260, 20);
        fby4Wall(110, 260, 20);        
        fby4Wall(150, 260, 20);
        fby4Wall(190, 260, 20);
        fby4Wall(230, 260, 20);
        fby4Wall(310, 260, 20);
        fby4Wall(390, 260, 20);
        fby4Wall(430, 260, 20);
        fby4Wall(470, 260, 20);
        fby4Wall(510, 260, 20);
        fby4Wall(550, 260, 20);
        
        fby4Wall(70, 220, 20);
        fby4Wall(230, 220, 20);
        fby4Wall(270, 220, 20);
        fby4Wall(310, 220, 20);
        fby4Wall(350, 220, 20);
        fby4Wall(390, 220, 20);
        fby4Wall(550, 220, 20);
        
        fby4Wall(270, 180, 20);
        fby4Wall(350, 180, 20);
        
        fby4Wall(270, 140, 20);
        fby4Wall(350, 140, 20);
        
        //Steel
        fby4Steel(270, 260, 20);
        fby4Steel(350, 260, 20);
        
        //Egale
        addObject(new Eagle(), 350, 605);
        addObject(new Wall(), 350-30, 615);
        addObject(new Wall(), 350+30, 615);
        addObject(new Wall(), 350-30, 615-20);
        addObject(new Wall(), 350+30, 615-20);
        addObject(new Wall(), 350+30, 615-40);
        addObject(new Wall(), 350-30, 615-40);
        addObject(new Wall(), 350-30+20, 615-40);
        addObject(new Wall(), 350-30+20+20, 615-40);
        addObject(new Wall(), 350-30+20+20+20, 615-40);
        
        //Life
        addObject(new Life('L'), 675, 450);
        addObject(new Life('L'), 725, 450);
        addObject(new Life('L'), 775, 450);
    }
    
    /**
     * Method fby4Steel
     *
     * @param x A parameter
     * @param y A parameter
     * @param walL A parameter
     * 
     * Forms 4 by 4 block from four steel bricks
     */
    public void fby4Steel(int x, int y, int walL)
    {
        addObject(new Steel(), x-walL/2, y-walL/2);
        addObject(new Steel(), x+walL/2, y+walL/2);
        addObject(new Steel(), x-walL/2, y+walL/2);
        addObject(new Steel(), x+walL/2, y-walL/2);
    }
    
    /**
     * Method fby4Wall
     *
     * @param x A parameter
     * @param y A parameter
     * @param walL A parameter
     * 
     * Forms 4 by 4 block from four wall bricks
     */
    public void fby4Wall(int x, int y, int walL)
    {
        addObject(new Wall(), x-walL/2, y-walL/2);
        addObject(new Wall(), x+walL/2, y+walL/2);
        addObject(new Wall(), x-walL/2, y+walL/2);
        addObject(new Wall(), x+walL/2, y-walL/2);
    }
    
    /**
     * Method fby4Plant
     *
     * @param x A parameter
     * @param y A parameter
     * @param walL A parameter
     * 
     * Forms 4 by 4 block from four plant bricks
     */
    public void fby4Plant(int x, int y, int walL)
    {
        addObject(new Plant(), x-walL/2, y-walL/2);
        addObject(new Plant(), x+walL/2, y+walL/2);
        addObject(new Plant(), x-walL/2, y+walL/2);
        addObject(new Plant(), x+walL/2, y-walL/2);
    }
    
    /**
     * Method fby4Water
     *
     * @param x A parameter
     * @param y A parameter
     * @param walL A parameter
     * 
     * Forms 4 by 4 block from four water bricks
     */
    public void fby4Water(int x, int y, int walL)
    {
        addObject(new Water(), x-walL/2, y-walL/2);
        addObject(new Water(), x+walL/2, y+walL/2);
        addObject(new Water(), x-walL/2, y+walL/2);
        addObject(new Water(), x+walL/2, y-walL/2);
    }
    
    /**
     * Method spawnAddUp
     * Generates bullet add-up on random location near bottom of the game field
     */
    public void spawnAddUp()
    {
        if (iter % 600 == 0)
        {
            if (Greenfoot.getRandomNumber(10) % 2 == 0)//Left of the egale
            {
                addObject(new AddUp(), Greenfoot.getRandomNumber(200)+75, (500 + 40 * (Greenfoot.getRandomNumber(2)+1)));
            }
            else//Right of the egale
            {
                addObject(new AddUp(), Greenfoot.getRandomNumber(200)+410, (500 + 40 * (Greenfoot.getRandomNumber(2)+1)));
            }
            
        }
    }
}
