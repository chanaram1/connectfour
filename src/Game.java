public class Game {

  boolean winner;
  public static final int ROW = 6;
  public static final int COL = 7;
  char player;
  char[][] gameBoard;

  public Game() {
    gameBoard = new char[ROW][COL];

    for (int row = 0; row < ROW; row++) {
      for (int col = 0; col < COL; col++) {
        gameBoard[row][col] = '.';
      }
    }

    this.winner = false;
    this.player = 'b';
  }

  public boolean isPlaying() {
    if (this.winner == true) {
      return false;
    }
    return true;

  }

  public void printBoard() {
    for (int row = ROW - 1; row >= 0; row--) {
      for (int col = 0; col < COL; col++) {
        System.out.print(gameBoard[row][col]);
      }
      System.out.println('\n');
    }
  }

  public char pickColumn(char activePlayer, int move) {
    int addIndex = -1;
    if (this.player == 'b') {
      if (move >= 0 && move < 7) {
        for (int i = ROW - 1; i >= 0; i--) {
          if (gameBoard[i][move] == '.') {
            addIndex = i;
          }
        }
      } else {
        System.out.println("Enter a valid column between 0 and 6");
        return 'b';
      }
      if (addIndex == -1) {
        System.out.println("This column is full. Please enter another column");
        return 'b';
      } else {
        gameBoard[addIndex][move] = 'b';
        getWinner('b');
        return 'r';
      }

    } else {
      if (this.player == 'r') {
        if (move >= 0 && move < 7) {
          for (int i = ROW - 1; i >= 0; i--) {
            if (gameBoard[i][move] == '.') {
              addIndex = i;
            }
          }
        } else {
          System.out.println("Enter a valid column between 0 and 6");
          return 'r';
        }
        if (addIndex == -1) {
          System.out.println("This column is full. Please enter another column");
          return 'r';
        } else {
          gameBoard[addIndex][move] = 'r';
          getWinner('r');
          return 'b';
        }
      }
    }
    return 0;
  }

  public char getWinner(char player) {

    boolean tie = true;

    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COL; j++) {
        if (gameBoard[i][j] == '.') {
          tie = false;
        }
      }
    }

    if (tie == true) {
      this.winner = true;
      return '=';
    }

    for (int row = 0; row < gameBoard.length; row++) {
      for (int col = 0; col < gameBoard[0].length - 3; col++) {
        if (gameBoard[row][col] == player &&
            gameBoard[row][col + 1] == player &&
            gameBoard[row][col + 2] == player &&
            gameBoard[row][col + 3] == player) {
          this.winner = true;
          return player;
        }
      }
    }

    for (int row = 0; row < gameBoard.length - 3; row++) {
      for (int col = 0; col < gameBoard[0].length; col++) {
        if (gameBoard[row][col] == player &&
            gameBoard[row + 1][col] == player &&
            gameBoard[row + 2][col] == player &&
            gameBoard[row + 3][col] == player) {
          this.winner = true;
          return player;
        }
      }
    }

    for (int row = 3; row < gameBoard.length; row++) {
      for (int col = 0; col < gameBoard[0].length - 3; col++) {
        if (gameBoard[row][col] == player &&
            gameBoard[row - 1][col + 1] == player &&
            gameBoard[row - 2][col + 2] == player &&
            gameBoard[row - 3][col + 3] == player) {
          this.winner = true;
          return player;
        }
      }
    }
    
    for (int row = 0; row < gameBoard.length - 3; row++) {
      for (int col = 0; col < gameBoard[0].length - 3; col++) {
        if (gameBoard[row][col] == player &&
            gameBoard[row + 1][col + 1] == player &&
            gameBoard[row + 2][col + 2] == player &&
            gameBoard[row + 3][col + 3] == player) {
          this.winner = true;
          return player;
        }
      }
    }

    if (isPlaying() == false) {
      return '-';
    }

    return 1;
  }

}
