package ru.geekbrains;

public class Employees {
    private String fullName;
    private String function;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employees(String fullName, String function, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.function = function;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void getEmployeeInfo() {
        System.out.println("Работник " + fullName + ", возраст: "+ age);
        System.out.println("Должность: " + function + ", оклад: " + salary + "р");
        System.out.println("Телефон: " + phone + ", email: " + email);
        System.out.println();
    }

    public int getEmployeeAge() {
        return age;
    }
}
