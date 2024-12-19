# Behaviours
## Shuttle
- Movement
  - Move Left
  - Move Right
- Die
- Check if Alive
- Check collision to projectiles

## Alien
- Movement
  - Move Left 
  - Move Right
     - If boundary met move down and change direction
  - Speed dependent from height
- Die
- Check if Alive
- Check collision to projectiles

## Projectile
- Move down if shot by Alien
- Move up if shot by shuttle

## Barrier
- Check collision to projectiles

## GUI
- Start Menu
- Game Scene
- Ending Menu

# Test
# Shuttle
## Movement
### Move Right
- ~~(2, 2) -> (4, 2)~~
- ~~(20, 8) -> (22, 8)~~
### Move Left
- ~~(2, 2) -> (0, 2)~~
- ~~(20, 8) -> (18, 8)~~
## Check is alive
- ~~default -> True~~
- ~~Die -> False~~

# Alien
## Movement
### Move Right
- ~~(2, 5) -> (4, 5)~~
- ~~(8, 10) -> (10, 10)~~

### Move Left
- ~~(2, 5) -> (0, 5)~~
- ~~(8, 10) -> (6, 10)~~

### Move Down
- ~~(2, 5) -> (2, 20)~~
- ~~(5, 10) -> (5, 25)v

## Check is alive
- ~~default -> True~~
- ~~Die -> False~~

# Bomb
## Movement
### Move Down
- (2, 5) -> (2, 0)
- (5, 7) -> (5, 2)

# Projectle
## Movement
### Move Up
- (2, 5) -> (2, 10)
- (5, 7) -> (5, 12) 
