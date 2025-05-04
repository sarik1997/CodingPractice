import java.util.*;
import java.util.stream.Collectors;

public class GroupByAgeExample {

    public static Map<Integer, List<Employee>> groupByAge(List<Employee> employees) {
//        return employees.stream()
//                .collect(Collectors.groupingBy(Employee::getAge));
//Count of employees group by dept
//        Map<String, Long> departmentCount = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        Map<Integer, List<Employee>> grouped = new HashMap<>();

        for (Employee employee : employees) {
            int age = employee.getAge();
            if (!grouped.containsKey(age)) {
                grouped.put(age, new ArrayList<>());
            }
            grouped.get(age).add(employee);
        }

        return grouped;
    }


    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("Alice", 25, "Developer"), new Employee("Bob", 30, "Manager"), new Employee("Charlie", 25, "Designer"), new Employee("Diana", 30, "Tester"), new Employee("Eve", 35, "Analyst"));

        Map<Integer, List<Employee>> groupedEmployees = GroupByAgeExample.groupByAge(employees);

        // Display grouped employees
        groupedEmployees.forEach((age, group) -> {
            System.out.println("Age " + age + ": " + group);
        });
    }
}
/**
 * 
 */

