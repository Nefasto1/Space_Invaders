# Behaviours

- Print on standard output the game status
    - Implement a GUI
- Make the aliens move over the time
  - Move Right
  - Move Left
  - Move Down when meet the boundaries
  - Shoot
  - Take Damage
- Make the shuttle move by player inputs
  - Move Right
  - Move Left
  - Shoot
  - Take Damage
- Make the bullet move
  - Move Up if shot by shuttle
  - Move Down if shot by shuttle
- Print the current score
  - Increase the score for each killed alien

# Tests
### Shuttle
  - Shuttle Move Right
      - (0, 0) -> (1, 0)
      - (5, 10) -> (6, 10)
  - Shuttle Move Left
      - (1, 0) -> (0, 0)
      - (6, 10) -> (5, 10)

### Aliens
  - Aliens Move Right
      - (0, 0) -> (5, 0)
      - (5, 10) -> (10, 10)
  - Aliens Move Left
      - (5, 0) -> (0, 0)
      - (10, 10) -> (5, 10)
  - Aliens Move Down
      - (0, 20) -> (0, 15)
      - (10, 15) -> (10, 10)

### Bullet
  - Bullet Move Up
      - (0, 15) -> (0, 20)
      - (10, 10) -> (10, 15)
  - Bullet Move Down
      - (0, 20) -> (0, 15)
      - (10, 15) -> (10, 10)

### Score
  - Increase score
    - 500 -> 500
    - 1000 -> 1000
    - -500 -> -500
    - 500, 250, -250 -> 500