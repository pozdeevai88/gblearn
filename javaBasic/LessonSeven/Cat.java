package ru.geekbrains;

public class Cat extends Animals{
    private static int catCount;
    final private static int CAT_RUN_LIMIT = 200;
    final private static int CAT_SWIM_LIMIT = 0;

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

    @Override
    public boolean isHunger() {
        if (!super.satiety) {
            System.out.println("Кот  '" + super.name + "' смертельно голоден. Срочно накормите его");
        } else {
            System.out.println("Кот  '" + super.name + "' не голоден");
        }
        return super.satiety;
    }

    @Override
    public boolean eat(Plate plate, int food) {
        if (plate.getFullness() < food) {
            System.out.println("В тарелке слишком мало еды. Кот не будет есть");
            return false;
        } else {
            plate.decreaseFullness(food);
            super.satiety = true;
            System.out.println("Кот " + super.name + " поел и счастлив. В тарелке осталось еды " + plate.getFullness());
            return true;
        }
    }
}
