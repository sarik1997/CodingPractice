import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String position;

    // Constructor
    public Employee(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", position='" + position + "'}";
    }
}

