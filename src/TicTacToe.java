import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {
    String[][] board;

    public TicTacToe() {
        this.board = initBoard();
//        //Graphics
//
//        JFrame frame = new JFrame();
//        JButton button = new JButton();
//
//        frame.add(button);
//        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400,400);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
    }

    public String[][] initBoard() { // method for initializing the game board
        String[][] board = new String[4][4];
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (i == 0) {
                    board[i][j] = "  " + Integer.toString(j + 1);
                } else {
                    if (j == 0) {
                        board[i][j] = Integer.toString(i);
                    } else {
                        board[i][j] = "[ ]";
                    }
                }
            }
        }
        return board;
    }

    public String[][] getBoard() {
        return this.board;
    }

    public void printBoard() { //method for printing the game board.

        int i = 0;
        while (i <= 3) {
            int j = 0;
            while (j <= 3) {
                if (i == 0 && j == 3) {
                    j++;
                    continue;
                }
                System.out.print(this.board[i][j]);
                j++;
            }
            System.out.print("\n");
            i++;
        }
    }

    public String[][] setX(String coordinates) {
        int x = Character.getNumericValue(coordinates.charAt(0));
        int y = Character.getNumericValue(coordinates.charAt(1));
        this.board[x][y] = "[X]";
        return this.board;
    }

    public boolean legal(String coordinates) {
        if (coordinates.length() != 2) {
            System.out.println("Position should be 2 numbers");
            return false;
        } else {
            int x = Character.getNumericValue(coordinates.charAt(0));
            int y = Character.getNumericValue(coordinates.charAt(1));
            if (x > 3 || y > 3 || y < 1 || x < 1) {
                System.out.println("Out of bounds");
                return false;
            }
            if (!this.board[x][y].equals("[ ]")) {
                System.out.println("This position is already taken");
                return false;
            }

        }
        return true;
    }

    public String[][] setO(String coordinates) {
        int x = Character.getNumericValue(coordinates.charAt(0));
        int y = Character.getNumericValue(coordinates.charAt(1));
        this.board[x][y] = "[O]";
        return this.board;
    }

    static boolean isBoardFull(String[][] board) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (board[i][j].equals("[ ]")) {
                    return false;
                }
            }
        }
        return true;
    }

    public String gameOver() {
        for (int i = 1; i <= 3; i++) {
            if ((board[i][1].equals("[O]")) && (board[i][2].equals("[O]")) && (board[i][3].equals("[O]"))) {
                return "O";
            }
            if ((board[i][1].equals("[X]")) && (board[i][2].equals("[X]")) && (board[i][3].equals("[X]"))) {
                return "X";
            }
        }
        //columns:
        for (int i = 1; i <= 3; i++) {
            if ((board[1][i].equals("[O]")) && (board[2][i].equals("[O]")) && (board[3][i].equals("[O]"))) {
                return "O";
            }
            if ((board[1][i].equals("[X]")) && (board[2][i].equals("[X]")) && (board[3][i].equals("[X]"))) {
                return "X";
            }
        }
        //diagonals:
        if ((board[1][1].equals("[O]")) && (board[2][2].equals("[O]")) && (board[3][3].equals("[O]"))) {
            return "O";
        }
        if ((board[1][3].equals("[O]")) && (board[2][2].equals("[O]")) && (board[3][1].equals("[O]"))) {
            return "O";
        }
        if ((board[1][1].equals("[X]")) && (board[2][2].equals("[X]")) && (board[3][3].equals("[X]"))) {
            return "X";
        }
        if ((board[1][3].equals("[X]")) && (board[2][2].equals("[X]")) && (board[3][1].equals("[X]"))) {
            return "X";
        }
        if(isBoardFull(board)){
            return "Draw";
        }
        return "notOver";
    }
    //Graphics:

    private class MyActionListner implements ActionListener{

        public void actionPerformed(ActionEvent ae){}

    }

}
