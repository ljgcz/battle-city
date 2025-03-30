Project Title:
Battle City

Project Author:
LZ

Date: 
June 14, 2023

How to Play:
  1. Clone the repository, for example, to ~/fun-game
  2. Download and install Greenfoot from https://www.greenfoot.org
  3. Launch Greenfoot and open the ~/fun-game directory.
  4. Click on the Start button to begin.

Game Premise:
Battle City is a multi-directional shooter video game for the Family 
Computer produced and published in 1985 by Namco. The player controls a 
tank and shoot bullets to destroy enemy tanks around the playfield. 
The enemy tanks enter from the top of the screen and attempt to destroy
the player's base. It is especially popular in Asia, where it first
released.

Playing Instructions:
    - Enter key: starts the game
    - Up arrow key: move up
    - Down arrow key: move down
    - Left arrow key: move to the left
    - Right arrow key: move to the right
    - Space bar: shoot bullet
Your goal is to protect the eagle at all cost. Once reaches level 35, 
you win! You can destroy bricks to create pathways or hide in the 
woods (there are no special effects to this "hiding"). Steel walls 
and water cannot be destroyed nor cross. Bullet can go through woods
and water. You can kill enemies by shooting a bullet towards them, and
enemies can also kill you. You have three lives: you lose once you have
no life left. Note that there is a bullet count, you cannot shoot if
there are no bullets left. To gain more bullets, you need to "eat" 
those star bricks randomly generating at the bottom of the game field. 
Level increases by one per 200 iterations. As you reach a higher level, 
enemies will spawn faster.

Some Fun Features:
    - Fully random, automatic motion of enemy tanks.
    - Wall collision checking with specific mechanism ensuring that
    the tank will never be "half in a wall" since all images have 
    a size.
    - When a tank spawns, a blinking animation will appear first. Once
    this animation is finished, the tank will appear. This was 
    achieved without the usage of delay functions.
    - No "isAtEdge()" were used since the game field is far inside 
    the edge of the world class. All edge checking were done using
    my special algorithms.

Note that no arrays were used in making the animations. I used a
simpler method by adding a decimal number like 0.03 every iteration,
then used modulus to set the image. I fully understands the function,
application, and usage of arrays, it just that there is a better way
to do it. I fully understand that it is slight less efficient to set
the image every time, but this game does not require such high level 
of efficiency.

This game is not very easy to win, so be prepared to lose ;)

Fun Facts:
    - The layout of this game is an exact copy of the last level in the 
    actual game.
    - There are only 35 levels in the actual game, and that's why
    you win at level 35.
