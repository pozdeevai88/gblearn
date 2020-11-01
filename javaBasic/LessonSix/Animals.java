package ru.geekbrains;

public class Animals {
    public static int animalsCount;
    protected String name;

    public Animals(String name) {
        this.name = name;
        animalsCount++;
    }

    public static int getAnimalsCount(){
        return animalsCount;
    }

}
