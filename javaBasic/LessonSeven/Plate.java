package ru.geekbrains;

public class Plate {
    private int capacity;
    private int fullness;

    public Plate(int capacity) {
        this.capacity = capacity;
        fullness = 0;
    }

    public void addFood(int food) {
        if (food > 0) {
            if ((food + this.fullness) > this.capacity) {
                System.out.println("В эту тарелку столько еды не поместится");
            } else {
                this.fullness += food;
            }
        } else {
            System.out.println("Неужели вы хотите положить в тарелку ЭТО???");
        }
    }

    public boolean increaseFullness(int incr) {
        if ((this.fullness + incr) <= this.capacity) {
            this.fullness += incr;
            return true;
        }
        return false;
    }

    public boolean decreaseFullness(int decr) {
        if ((this.fullness - decr) >= 0) {
            this.fullness -= decr;
            return true;
        }
        return false;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFullness() {
        return fullness;
    }
}
