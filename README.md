# Battle City

![Battle City Gameplay](demo.gif)

## Table of Contents

- [About](#about)
- [How to Play](#how-to-play)
- [Game Premise](#game-premise)
- [Controls](#controls)
- [Gameplay Mechanics](#gameplay-mechanics)
- [Fun Features](#fun-features)
- [Fun Facts](#fun-facts)
- [Screenshots / Demo](#screenshots--demo)

## About

**Battle City** is a multi-directional shooter video game originally released in 1985 by Namco for the Family Computer. Players control a tank, destroy enemy tanks, and protect their base. The game is especially popular in Asia, where it first launched.

## How to Play

1. Clone this repository:
   ```bash
   git clone https://github.com/ljgcz/battle-city.git
   ```

2. Download and install Greenfoot from [https://www.greenfoot.org/download](https://www.greenfoot.org/download).

3. Launch Greenfoot and open the `battle-city` directory.

4. Click the **Start** button to begin the game.

## Game Premise

The player controls a tank and must destroy enemy tanks that appear from the top of the screen while defending the eagle base. Enemies try to destroy your base, and you must protect it at all costs. The game progresses in levels, increasing difficulty as enemy tanks spawn faster.

## Controls

| Key       | Action         |
|-----------|----------------|
| Enter     | Start the game |
| ↑ (Up)    | Move up        |
| ↓ (Down)  | Move down      |
| ← (Left)  | Move left      |
| → (Right) | Move right     |
| Space     | Shoot bullet   |

## Gameplay Mechanics

- **Objective:** Protect the eagle and reach level 35 to win.
- **Destructible Obstacles:** Bricks can be destroyed to create pathways or hide in woods (no special hiding effect).
- **Indestructible Obstacles:** Steel walls and water cannot be destroyed or crossed. Bullets can pass through woods and water.
- **Enemies:** Destroy enemies by shooting bullets at them. Enemies can also destroy the player.
- **Lives:** You have 3 lives. The game ends when all lives are lost.
- **Bullets:** Limited bullet count. Collect star bricks randomly appearing at the bottom of the field to gain more bullets.
- **Levels:** Level increases every 200 iterations. Higher levels spawn enemies faster.

## Fun Features

- Fully random, automatic motion of enemy tanks.
- Wall collision checking ensures tanks never overlap walls.
- Tank spawn includes a blinking animation without using delay functions.
- Custom edge detection algorithm used instead of `isAtEdge()`.
- Animation without arrays using a decimal counter and modulus for image switching. Simple yet effective.

## Fun Facts

- The game layout replicates the final level of the original Battle City game.
- There are only 35 levels in the original game, which is why winning occurs at level 35.
- The game is challenging—expect to lose occasionally!

---

Enjoy defending your eagle and blasting enemy tanks! 🎮
