package ru.geekbrains;

public class Dog extends Animals {
    private static int dogCount;
    private static int DOG_RUN_LIMIT = 500;
    private static int DOG_SWIM_LIMIT = 10;

    public Dog(String dogName) {
        super(dogName);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    public void run(int distance) {
        if (distance < DOG_RUN_LIMIT) {
            System.out.println("Собака '" + super.name + "' пробежала " + distance + " метров");
        } else {
            System.out.println("Собака столько не пробежит. Это много для неё");
        }
    }

    public void swim(int distance) {
        if (distance < DOG_SWIM_LIMIT) {
            System.out.println("Собака '" + super.name + "' проплыла " + distance + " метров");
        } else {
            System.out.println("Собака столько не проплывёт. Это много для неё");
        }
    }
}
