# Cat & Mouse Chase Game

Welcome to the Cat & Mouse Chase Game! This project is an object-oriented programming challenge where you play as a cat chasing mice in a house filled with obstacles, traps, and dogs.

## Game Overview

### Basic Rules (v1.0.0)

  1.	Objective: Collect as many mice as possible while avoiding dogs. Reach the helicopter to save your mice and advance to the next house.
 
  2.	Navigation:
  •	Use N, S, E, and W commands to move North, South, East, and West.
  •	Reach the stairs to move to the next floor with more mice and more challenges.
  •	Each saved mouse scores points when you escape via the helicopter.
  3.	Obstacles: Navigate around walls and other obstacles in the house.
  4.	Game Over: If a dog catches the player, the game ends.

### New Features (v1.1.0)

1. Life System
	•	Players start the game with 3 lives.
	•	Additional lives can be earned by leveling up, up to a maximum of 5 lives.
	•	If a dog attacks the player:
	•	A life is lost.
	•	The current level resets.
	•	Losing all lives results in game over.

2. Trap System
	•	The game begins with no traps. As levels increase, traps are introduced based on specific rules.
	•	Stepping into a trap causes the player to lose all currently collected mice.
	•	If the player has no mice, stepping into a trap has no effect.

## How to Play
  1.	Compile and run the project files.
  2.	Move using directional commands: N, S, E, W.
  3.	Avoid dogs, collect mice, and navigate around obstacles to reach the helicopter.

## Future Plans

Additional features and improvements are planned for future versions, including:
	•	Enhanced enemy behavior
	•	New challenges and rewards

Feel free to explore the code, suggest improvements, or contribute to the project!
