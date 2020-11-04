package ru.geekbrains;

public class Animals {
    public static int animalsCount;
    protected String name;
    protected boolean satiety;

    public Animals(String name) {
        this.name = name;
        this.satiety = false;
        animalsCount++;
    }

    public static int getAnimalsCount(){
        return animalsCount;
    }

    public boolean isHunger() {
        return satiety;
    }

    public boolean eat(Plate plate, int food) {
        return plate.decreaseFullness(food);
    }
}
