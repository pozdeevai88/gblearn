package ru.geekbrains;

public class MainApp {

    public static void main(String[] args) {

        Cat catFil = new Cat("Фил");
        Cat catBrown = new Cat("Браун");
        Dog dogForest = new Dog("Форест");

        dogForest.run(300);
        catFil.swim(50);

        System.out.println(Animals.getAnimalsCount());
        System.out.println(Cat.getCatCount());
        System.out.println(Dog.getDogCount());
    }
}
