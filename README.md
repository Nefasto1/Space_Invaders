# Space Invaders Game Implementation

This repository contains an implementation of the classic arcade game Space Invaders in Java.

## About the Game

Space Invaders is a space-themed shooter video game where players control a spaceship to destroy alien invaders. The player's goal is to survive as long as possible while destroying waves of descending aliens.

## Features

- Classic Space Invaders gameplay
- Player-controlled spaceship movement
- Alien invasion waves
- Laser beam shooting system
- Barriers 
- Collision detection between player ship, aliens, and lasers
- SpeedyAlien to gain extra points
- User-friendly starting menu
- Game options (spaceship color, number of alien rows, number of barriers)
- Sound effect for shots and collision between bomb and shuttle.

## Installation

To run the game:

1. Ensure you have Java Development Kit (JDK) installed on your system.
2. Clone this repository 
3. Run the following commands:
    ```
    .\gradlew build
    ```
    this will create the build directory with the .jar file
    ```
    cd build/libs
    ```
    to navigate to the folder in which there is the .jar file
    ```
    java -jar Space_Invaders-1.0-SNAPSHOT.jar 
    ```
   to run the game.


## Usage

- Use arrow keys to move the spaceship left and right.
- Press up to shoot lasers.
- Avoid collisions with bomb.
- Shot all alien and avoid they reach the line or kill the shuttle.

## Code Structure

The source folder is organized as follows:
```
📂 src/
├── 📂 main/
│   └── 📂 java/
│       └── 📂 sdm/
│           ├────── 📂 gui/
│           │        ├── AlienFactory
│           │        ├── BarrierFactory
│           │        ├── Drawable
│           │        ├── EndMenu
│           │        ├── GameBoard
│           │        ├── GameManager
│           │        ├── GameMenu
│           │        ├── Main
│           │        ├── Player
│           │        └── StartMenu
│           └────── 📂 space/
│                    ├── Alien
│                    ├── AlienSpeedy
│                    ├── Barrier
│                    ├── Bomb
│                    ├── CollisionChecker
│                    ├── Entity
│                    ├── Projectile
│                    └── Shuttle
└── 📂 test/
     └── 📂 java/
       └── 📂 sdm.space/
            ├── TestAlien
            ├── TestAlienSpeedy
            ├── TestBarrier
            ├── TestBomb
            ├── TestCollision
            ├── TestProjectile
            └── TestShuttle
```
