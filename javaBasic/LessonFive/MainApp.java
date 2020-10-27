package ru.geekbrains;

public class MainApp {
    public static void main(String[] args) {
        Employees[] employeesArray = new Employees[5];
        employeesArray[0] = new Employees("Ivanov Ivan", "Electric", "ivanov@mail.com",
                "8-800-1000-100", 10000, 56);
        employeesArray[1] = new Employees("Petrov Petr", "Driver", "petrov@mail.com",
                "8-800-1000-200", 20000, 23);
        employeesArray[2] = new Employees("Sidorov Sidr", "Engineer", "sidorov@mail.com",
                "8-800-1000-300", 30000, 42);
        employeesArray[3] = new Employees("Antonov Antov", "Doctor", "antonov@mail.com",
                "8-800-1000-400", 20000, 36);
        employeesArray[4] = new Employees("Leha", "Senior Engineer", "leha@mail.com",
                "8-800-1000-500", 80000, 31);

        for (int i = 0; i < 5; i++) {
            if (employeesArray[i].getEmployeeAge() > 40) {
                employeesArray[i].getEmployeeInfo();
            }
        }
    }
}
