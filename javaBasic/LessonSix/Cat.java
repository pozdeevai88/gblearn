package ru.geekbrains;

public class Cat extends Animals{
    private static int catCount;
    private static int CAT_RUN_LIMIT = 200;
    private static int CAT_SWIM_LIMIT = 0;

    public Cat (String catName) {
        super(catName);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    public void run(int distance) {
        if (distance < CAT_RUN_LIMIT) {
            System.out.println("Кот '" + super.name + "' пробежал " + distance + " метров");
        } else {
            System.out.println("Кот столько не пробежит. Это много для него");
        }
    }

    public void swim(int distance) {
        if (distance < CAT_SWIM_LIMIT) {
            System.out.println("Кот '" + super.name + "' проплыл " + distance + " метров");
        } else {
            System.out.println("Кот столько не проплывёт. Это много для него.");
        }
    }
}
