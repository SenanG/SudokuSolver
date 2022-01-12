# SudokuSolver

A simple soduku solver made using java

This program essentially works by doing the following:

Goes through the board row by row, stopping at blank spaces. It cycles through 1 - 9 to check if they can be inputted.
This check is done by veryfing if the number already exists in the row and column by cycling through and seeing if there is a match.
It also checks if that number already exists in the smaller 3x3 box. It does so by taking the the coordinate (rowNum,colNum), each subtracting itself mod 3 from itself.
If the placemnt is valid it moves on and repeats, if not it goes back and replaces the number with a 0.

This function is recursive and calls itself until the board is solved.
