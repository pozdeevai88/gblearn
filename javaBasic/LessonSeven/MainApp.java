package ru.geekbrains;

public class MainApp {

    public static void main(String[] args) {

        Plate plate1 = new Plate(300);
        plate1.addFood(300);

        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Дональд");
        cats[1] = new Cat("Байден");
        cats[2] = new Cat("Трамп");
        cats[3] = new Cat("Джо");

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate1, 50);
        }

        for (int i = 0; i < cats.length; i++) {
            cats[i].isHunger();
        }
    }
}
