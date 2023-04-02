import java.util.ArrayList;

public class MinimaxPlayer {
    String play(String[][] board) {
        String bestMove = new String();
        int bestVal = 0;
        //ArrayList moves = availableMoves(board);
        for(int i = 1; i < 4; i++){
            for(int j = 1; j < 4; j++){
                if (board[i][j].equals("[ ]")){
                    board[i][j] = "[O]";
                    int value = minimax(board, false);
                    if (value >= bestVal){
                        bestVal = value;
                        bestMove = Integer.toString(i)+Integer.toString(j);

                    }
                    board[i][j] = "[ ]";
                }
            }
        }
        /*for (int i = 0; i < moves.size(); i++) {
            if (minimax(board, true) > bestVal) {
                bestVal = minimax(board, true);
                bestMove = moves.get(i).toString();
            }
        }*/
        return bestMove;
    }

    static ArrayList availableMoves(String[][] board) {
        ArrayList playableLoc = new ArrayList<String>();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (board[i][j].equals("[ ]")) {
                    playableLoc.add(i + Integer.toString(j));
                }
            }
        }
        return playableLoc;
    }

    String isGameOver(String[][] board) {
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
        return "noWinner";
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

    int minimax(String[][] board, boolean isMaxPlayer) {  //Maximizing Player is O's
        String isOver = isGameOver(board);
        if (isOver.equals("O")) {
            return 10;
        } else if (isOver.equals("X")) {
            return -10;

        } else {
            if (isBoardFull(board)) {
                return 0;
            } else {
                if (isMaxPlayer) {
                    int bestVal = Integer.MIN_VALUE;
                    for (int i = 1; i < 4; i++) {
                        for (int j = 1; j < 4; j++) {
                            if (board[i][j].equals("[ ]")) {
                                board[i][j] = "[O]";
                                bestVal = Math.max(bestVal, minimax(board, false));
                                board[i][j] = "[ ]";
                            }
                        }

                    }
                    return bestVal;
                } else {
                    int bestVal = Integer.MAX_VALUE;
                    for (int i = 1; i < 4; i++) {
                        for (int j = 1; j < 4; j++) {
                            if (board[i][j].equals("[ ]")) {
                                board[i][j] = "[X]";
                                bestVal = Math.min(bestVal, minimax(board, true));
                                board[i][j] = "[ ]";
                            }
                        }

                    }
                    return bestVal;
                }

            }
        }

    }
}