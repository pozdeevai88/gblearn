package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        /*
         * Написать программу, которая загадывает случайное число от 0 до 9
         * и пользователю дается 3 попытки угадать это число.
         * При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число,
         * чем загаданное, или меньше. После победы или проигрыша выводится запрос –
         * «Повторить игру еще раз? 1 – да / 0 – нет» (1 – повторить, 0 – нет).
         */

        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int rnd;
        boolean repeat;
        int userNum;

        System.out.println("Ситема загадала число от 0 до 9. Попробуйте его угадать за три попытки");

        do {
            rnd = random.nextInt(10);
            repeat = false;
            for (int i = 1; i <= 3; i++) {

                do {
                    System.out.println("Попытка №" + i + ". Введите число от 0 до 9");
                    userNum = scan.nextInt();
                } while (userNum < 0 || userNum > 9);

                if (userNum == rnd) {
                    System.out.println("Вы угадали!");
                    break;
                } else if (userNum > rnd) {
                    System.out.println("Не верно. Загаданное число меньше");
                } else if (userNum < rnd) {
                    System.out.println("Не верно. Загаданное число больше");
                }
            }

            System.out.println("Повторить игру? Введите '1' если да, '0' если нет");
            if (scan.nextInt() == 1) {
                repeat = true;
            }

        } while (repeat);


        /*
         * 2 Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
         * "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
         * "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
         * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
         * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
         * Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
         *
         * apple – загаданное
         * apricot - ответ игрока
         * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
         * Для сравнения двух слов посимвольно, можно пользоваться:
         * String str = "apple";
         * str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
         * Играем до тех пор, пока игрок не отгадает слово
         * Используем только маленькие буквы
         */

        String[] arr = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        String keyWord = arr[random.nextInt(25)];
        String userWord;
        System.out.println("Ситема загадала слово. Попробуйте его угадать");

        do {
            userWord = scan.nextLine();
            if (userWord.equals(keyWord)) {
                System.out.println("Вы угадали!");
                break;
            }

            for (int i = 0; i < 15; i++) {
                if (i < keyWord.length() && i < userWord.length()) {
                    if (keyWord.charAt(i) == userWord.charAt(i)) {
                        System.out.print(keyWord.charAt(i));
                    } else {
                        System.out.print("#");
                    }
                    continue;
                }
                System.out.print("#");
            }
            System.out.println("");

        } while (true);
    }
}
