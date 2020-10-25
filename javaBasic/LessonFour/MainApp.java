
/*
 * Выполнены все задания. За основу взят код из методички.
 * Что изменилось:
 * 1. Переделана проверка победы для ЛЮБЫХ размеров полей и длинн последовательностей.
 * 2. Расширены возможности ИИ: блокирование выигрышных последовательностей человека,
 *    реализация своих выигрышных последовательностей.
 * Победить ИИ стало гораздо труднее
 */



package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static int SIZE = 6;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb) {
        String strHor;
        String strVert;
        String strDiagLeftPos;
        String strDiagLeftNeg;
        String strDiagRightPos;
        String strDiagRightNeg;

        for (int i = 0; i < SIZE; i++) {
            strHor = "";
            strVert = "";
            for (int j = 0; j < SIZE; j++) {
                strHor += map[i][j];
                strVert += map[j][i];
            }
            if (strHor.contains((Character.toString(symb)).repeat(DOTS_TO_WIN))) return true;
            if (strVert.contains((Character.toString(symb)).repeat(DOTS_TO_WIN))) return true;
        }

        for (int i = 0; i < SIZE; i++) {
            strDiagLeftPos = "";
            strDiagLeftNeg = "";
            strDiagRightPos = "";
            strDiagRightNeg = "";

            for (int j = 0; j < (SIZE - i); j++) {
                strDiagLeftNeg += map[i + j][j];
                strDiagLeftPos += map[j][i + j];
                strDiagRightNeg += map[i + j][SIZE - j - 1];
                strDiagRightPos += map[j][SIZE - 1 - i - j];
            }

            if (strDiagLeftNeg.contains((Character.toString(symb)).repeat(DOTS_TO_WIN)) ||
                    strDiagLeftPos.contains((Character.toString(symb)).repeat(DOTS_TO_WIN)) ||
                    strDiagRightNeg.contains((Character.toString(symb)).repeat(DOTS_TO_WIN)) ||
                    strDiagRightPos.contains((Character.toString(symb)).repeat(DOTS_TO_WIN))
            ) return true;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean winForecast(char symbCheck) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = symbCheck;
                    if (checkWin(symbCheck)) {
                        map[i][j] = DOT_O;
                        System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i + 1));
                        return true;
                    } else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        return false;
    }

    public static void aiTurn() {
        int x, y;
        if (!winForecast(DOT_O)) {
            if (!winForecast(DOT_X)) {
                do {
                    x = rand.nextInt(SIZE);
                    y = rand.nextInt(SIZE);
                } while (!isCellValid(x, y));
                System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
                map[y][x] = DOT_O;
            }
        }
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

