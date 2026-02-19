import java.util.*;
import java.util.stream.Collectors;

public class StreamPractice {

    static class Employee {
        private String name;
        private int age;
        private String department;
        private double salary;

        public Employee(String name, int age, String department, double salary) {
            this.name = name;
            this.age = age;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", department='" + department + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, "HR", 50000),
                new Employee("Bob", 25, "IT", 70000),
                new Employee("Charlie", 35, "Finance", 60000),
                new Employee("David", 28, "IT", 80000),
                new Employee("Eve", 40, "HR", 55000),
                new Employee("Frank", 50, "Finance", 90000));

        System.out.println("Original List: " + employees);
        System.out.println("--------------------------------------------------");

        // 1. Filter: Find all employees older than 30
        List<Employee> olderThan30 = employees.stream()
                .filter(e -> e.getAge() > 30)
                .collect(Collectors.toList());
        System.out.println("Employees older than 30: " + olderThan30);

        // 2. Map: Get a list of all employee names
        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("Employee names: " + names);

        // 3. Sort: Sort employees by salary (ascending)
        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
        System.out.println("Employees sorted by salary: " + sortedBySalary);

        // 4. Group: Group employees by department
        Map<String, List<Employee>> byDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Employees grouped by department: " + byDepartment);

        // 5. Count: Count employees in each department
        Map<String, Long> countByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Count of employees by department: " + countByDepartment);

        // 6. Max: Find the employee with the highest salary
        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        highestPaid.ifPresent(e -> System.out.println("Highest paid employee: " + e));

        // 7. Sum: Calculate the total salary of all employees
        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total salary: " + totalSalary);

        // 8. Match: Check if any employee is under 18
        boolean anyUnder18 = employees.stream()
                .anyMatch(e -> e.getAge() < 18);
        System.out.println("Are there any employees under 18? " + anyUnder18);

        // 9. Distinct: List distinct departments
        List<String> distinctDepartments = employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct departments: " + distinctDepartments);

        // 10. Partition: Partition employees into two groups: younger than 30 and 30+
        Map<Boolean, List<Employee>> partitionedByAge = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() < 30));
        System.out.println("Employees < 30 (true) vs >= 30 (false): " + partitionedByAge);

        System.out.println("--------------------------------------------------");
        System.out.println("Duplicate & Frequency Practice:");

        // 11. Find duplicate elements in a list
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");
        Set<String> uniqueWords = new HashSet<>();
        List<String> duplicates = words.stream()
                .filter(w -> !uniqueWords.add(w))
                .collect(Collectors.toList());
        System.out.println("Duplicate words: " + duplicates);

        // 12. Count occurrences of each character in a string
        String inputString = "banana";
        Map<Character, Long> charCount = inputString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("Character frequency in '" + inputString + "': " + charCount);

        // 13. Find the first non-repeating character
        String streamInput = "swiss";
        Optional<Character> firstNonRepeating = streamInput.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())) // LinkedHashMap
                                                                                                   // preserves order
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println("First non-repeating character in '" + streamInput + "': " +
                firstNonRepeating.orElse(null));
    }
}
