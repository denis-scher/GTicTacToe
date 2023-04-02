import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GTicTacToe extends JFrame {

    JButton[] buttons;
    GTicTacToe(){
        MinimaxPlayer smartPlayer = new MinimaxPlayer();
        TicTacToe game = new TicTacToe();
        JPanel buttonsPanel = new JPanel();
        buttons = new JButton[9];
        buttonsPanel.setLayout(new GridLayout(3,3));
        ActionListener ae = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < 9; i++){
                    if(e.getSource() == buttons[i]){
                        if(buttons[i].getText() == ""){
                            buttons[i].setText("X");
                            game.setX(getX(i));
                            gameOverC(game.gameOver());
                            if(game.gameOver() != "notOver"){
                                break;
                            }
                            String newPlayerMove = smartPlayer.play(game.getBoard());
                            game.setO(newPlayerMove);
                            buttons[getO(newPlayerMove)].setText("O");
                            gameOverC(game.gameOver());
                            if(game.gameOver() != "notOver"){
                                break;
                            }
                        }else{
                            continue;
                        }
                    }
                }
            }
        };
        for(int i = 0;i < 9; i++){
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(ae);
            buttonsPanel.add(buttons[i]);
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setLayout(new BorderLayout());
        this.add(buttonsPanel);
        this.setVisible(true);
    }

    private String getX(int loc){
        String[] boardLocations = new String[] {"11","12","13","21","22","23","31","32","33"};
        return boardLocations[loc];
    }


    private int getO(String loc){
        String[] boardLocations = new String[] {"11","12","13","21","22","23","31","32","33"};
        for (int i = 0;i < 9; i++){
            if (boardLocations[i].equals(loc)){
                return i;
            }
        }
        return -1;
    }

    private void gameOverC(String ind){
        if(ind != "notOver"){
            switch (ind){
                case "X":
                    System.out.println("X is the winner");
                    for(int i = 0; i < 9; i++){
                        this.buttons[i].setEnabled(false);
                    }

                    return;
                case "O":
                    System.out.println("O is the winner");
                    for(int i = 0; i < 9; i++){
                        this.buttons[i].setEnabled(false);
                    }
                    return;
                case "Draw":
                    System.out.println("It's a draw");
                    for(int i = 0; i < 9; i++){
                        this.buttons[i].setEnabled(false);
                    }
                    return;
            }
        }
    }



}
