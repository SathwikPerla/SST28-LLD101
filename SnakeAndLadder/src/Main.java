
// Entry point of the application
// Simulates client interaction with the game
import game.Difficulty;
import game.Game;

// Initializes the game with board size, number of players and difficulty
// Starts the game loop
public class Main {
    public static void main(String[] args) {
        Game game = new Game(10, 3, Difficulty.EASY);
        game.start();
    }
}