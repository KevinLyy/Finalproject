import java.util.*;

public class TicTacToeRedux{
  boolean ifWin,turn;
  int[][] lrgBoard = new int[3][3];
  int[][] b1,b2,b3,b4,b5,b6,b7,b8,b9 = new int[3][3];
  int[][] nextBoard;
  int winner;

  public TicTacToeRedux(){
    turn = true;
    nextBoard = b5;
  }

  public String toString(int[][] board){
    return "";
  }

  public int checkBoard(int[][] board){
    if(board[0][0] == board[0][1] && board[0][1] == board[0][2]){
      if(board[0][0] == 1) return 1;
      else return 2;
    }
    if(board[0][0] == board[1][0] && board[1][0] == board[2][0]){
      if(board[0][0] == 1) return 1;
      else return 2;
    }
    if(board[0][0] == board[1][1] && board[1][1] == board[2][2]){
      if(board[0][0] == 1) return 1;
      else return 2;
    }
    if(board[0][2] == board[1][1] && board[1][1] == board[2][0]){
      if(board[0][2] == 1) return 1;
      else return 2;
    }
    if(board[0][2] == board[1][2] && board[1][2] == board[2][2]){
      if(board[0][2] == 1) return 1;
      else return 2;
    }
    if(board[1][0] == board[1][1] && board[1][1] == board[1][2]){
      if(board[1][0] == 1) return 1;
      else return 2;
    }
    if(board[2][0] == board[2][1] && board[2][1] == board[2][2]){
      if(board[2][0] == 1) return 1;
      else return 2;
    }
    if(board[0][1] == board[1][1] && board[1][1] == board[2][1]){
      if(board[0][0] == 1) return 1;
      else return 2;
    }
    return 0;
  }

  public void getNextTurn(int x, int y){
    if(x == 0 && y == 0) nextBoard = b1;
    if(x == 1 && y == 0) nextBoard = b2;
    if(x == 2 && y == 0) nextBoard = b3;
    if(x == 0 && y == 1) nextBoard = b4;
    if(x == 1 && y == 1) nextBoard = b5;
    if(x == 2 && y == 1) nextBoard = b6;
    if(x == 0 && y == 2) nextBoard = b7;
    if(x == 1 && y == 2) nextBoard = b8;
    if(x == 2 && y == 2) nextBoard = b8;
  }
  public int getXInt(int[][] board){

  }
  public int getYInt(int[][] board){

  }



  public void play(int a, int b){
    if(turn) nextBoard[a][b] = 1;
    else nextBoard[a][b] = 2;
    if(checkBoard(nextBoard) == 1) lrgBoard[][] = 1;
    else if(checkBoard(nextBoard) == 2) lrgBoard[][] = 2;
    
    if(checkBoard(lrgBoard) == 1) System.out.println("the winner is player 1");
    else if (checkBoard(lrgBoard) == 2)System.out.println("the winner is player 2");
    turn = !turn;
    getNextTurn(a,b);
  }
}