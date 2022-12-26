import java.util.Scanner;

public class GamePlayer {
  public static void main(String[] args) {
    Game game = new Game();
    Scanner userInput = new Scanner(System.in);

    System.out.println("Beginning the game!");

    char P1 = 'b';
    char P2 = 'r';

    while (game.isPlaying()) {
      if (game.player == P1) {
        System.out.println("Player 1's move:");
        int move = userInput.nextInt();
        game.pickColumn(game.player, move);
        game.printBoard();
        game.player = P2;
      } else {
        System.out.println("Player 2's move:");
        int move = userInput.nextInt();
        game.pickColumn(game.player, move);
        game.printBoard();
        game.player = P1;
      }
    }
    if (game.getWinner(game.player) == '=') {
      System.out.println("Game is a tie");
    } else {
      if (game.player == P1) {
        System.out.println("The winner is P2");
      } else {
        System.out.println("The winner is P1");
      }
    }
  }
}
