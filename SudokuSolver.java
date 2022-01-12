import java.util.Scanner;  

public class SudokuSolver {
  
    private static final int GRID_SIZE = 9;
    
    public static void main(String[] args) {
      
      int[][] sudokuBoard = {
          {0,6,0,0,0,0,1,0,0},
          {0,0,2,3,0,7,0,0,6},
          {0,0,0,4,0,0,0,0,0},
          {0,0,9,0,1,0,0,0,0},
          {3,0,0,7,0,9,5,0,0},
          {0,0,0,0,4,0,0,0,7},
          {0,0,3,6,0,2,0,0,1},
          {5,0,0,0,0,0,0,8,0},
          {0,0,0,0,9,0,0,0,0},
        };
      
      printBoard(sudokuBoard);
      
      if (sudokuSolve(sudokuBoard)) {
        System.out.println("Solved successfully!");
      }
      else {
        System.out.println("Unsolvable board");
      }
      
      printBoard(sudokuBoard);
      
    }
    
    
    private static void printBoard(int[][] sudokuBoard) {
      for (int row = 0; row < GRID_SIZE; row++) {
        if (row % 3 == 0 && row != 0) {
          System.out.println("-----------");
        }
        for (int column = 0; column < GRID_SIZE; column++) {
          if (column % 3 == 0 && column != 0) {
            System.out.print("|");
          }
          System.out.print(sudokuBoard[row][column]);
        }
        System.out.println();
      }
    }
  
  
    private static boolean numberInRowCheck(int[][] sudokuBoard, int number, int row) {
      for (int i = 0; i < GRID_SIZE; i++) {
        if (sudokuBoard[row][i] == number) {
          return true;
        }
      }
      return false;
    }
    
    private static boolean numberInColumnCheck(int[][] sudokuBoard, int number, int column) {
      for (int i = 0; i < GRID_SIZE; i++) {
        if (sudokuBoard[i][column] == number) {
          return true;
        }
      }
      return false;
    }
    
    private static boolean numberInBoxCheck(int[][] sudokuBoard, int number, int row, int column) {
      int localBoxRow = row - row % 3;
      int localBoxColumn = column - column % 3;
      
      for (int i = localBoxRow; i < localBoxRow + 3; i++) {
        for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
          if (sudokuBoard[i][j] == number) {
            return true;
          }
        }
      }
      return false;
    }
    
    private static boolean validPlacementCheck(int[][] sudokuBoard, int number, int row, int column) {
      return !numberInRowCheck(sudokuBoard, number, row) &&
          !numberInColumnCheck(sudokuBoard, number, column) &&
          !numberInBoxCheck(sudokuBoard, number, row, column);
    }
    
    private static boolean sudokuSolve(int[][] sudokuBoard) {
      for (int row = 0; row < GRID_SIZE; row++) {
        for (int column = 0; column < GRID_SIZE; column++) {
          if (sudokuBoard[row][column] == 0) {
            for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
              if (validPlacementCheck(sudokuBoard, numberToTry, row, column)) {
                sudokuBoard[row][column] = numberToTry;
                
                if (sudokuSolve(sudokuBoard)) {
                  return true;
                }
                else {
                  sudokuBoard[row][column] = 0;
                }
              }
            }
            return false;
          }
        }
      }
      return true;
    }
  }