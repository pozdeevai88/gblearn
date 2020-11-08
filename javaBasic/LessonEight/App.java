package ru.geekbrains;

import javax.swing.*;
import java.awt.*;


public class App extends JFrame {
    protected boolean isAlive = true;
    protected int bombsTotal = 0;
    protected int clearedField = 0;

    public App(final int SIZE) {
        setTitle("Bombs and Deaths");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        boolean[][] bombs = new boolean[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                bombs[i][j] = Math.random() <= 0.25;
                if (bombs[i][j]) {
                    bombsTotal++;
                }
            }
        }


        JButton[][] buttons = new JButton[SIZE][SIZE];

        setLayout(new GridLayout(SIZE, SIZE));
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton button = new JButton();
                buttons[i][j] = button;
                int ii = i;
                int jj = j;
                button.addActionListener(actionEvent -> {
                    if (!isAlive) return;
                    if (bombs[ii][jj]) {
                        isAlive = false;
                        for (int k = 0; k < SIZE; k++) {
                            for (int l = 0; l < SIZE; l++) {
                                if (bombs[k][l]) {
                                    buttons[k][l].setText("Х");
                                    buttons[k][l].setFont(button.getFont().deriveFont(20.F));
                                    buttons[k][l].setBackground(Color.GRAY);
                                    buttons[k][l].setForeground(Color.WHITE);
                                }
                            }
                        }
                        button.setText("Х");
                        button.setFont(button.getFont().deriveFont(20.F));
                        button.setBackground(Color.RED);
                        button.setForeground(Color.WHITE);
                    } else {
                        clearedField++;
                        if (((SIZE * SIZE) - bombsTotal) == (clearedField)) {
                            for (int k = 0; k < SIZE; k++) {
                                for (int l = 0; l < SIZE; l++) {
                                    if (bombs[k][l]) {
                                        buttons[k][l].setText("Х");
                                        buttons[k][l].setFont(button.getFont().deriveFont(20.F));
                                        buttons[k][l].setBackground(Color.ORANGE);
                                        buttons[k][l].setForeground(Color.WHITE);
                                    }
                                }
                            }
                        }
                        button.setFont(button.getFont().deriveFont(20.F));
                        int bombCount = 0;
                        for (int row = -1; row <= 1; row++) {
                            for (int col = -1; col <= 1; col++) {
                                try {
                                    if (bombs[ii + row][jj + col]) {
                                        bombCount++;
                                    }
                                } catch (ArrayIndexOutOfBoundsException e) {
                                }
                            }
                        }
                        button.setText(Integer.toString(bombCount));
                        button.setBackground(Color.GREEN);
                        button.setEnabled(false);
                    }
                });
                add(button);
            }
        }
        setVisible(true);
    }
}
